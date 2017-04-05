import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by caleb on 3/30/17.
 */
public class AdvMain {

    static AdvMap map = new AdvMap();
    static Player p = new Player();
    static ViewableMaps seemaps = new ViewableMaps();

    static int nDistance;
    //pick map
    static int chooseMap;
    static int turn = 0;

    static int Cityndx;

    //loops
    static String reEdit;
    static boolean city;
    private static boolean replayFull;

    public static int currentRoomIndex = 1;


    static String readLine(String prompt) {
        String line = null;
        Console c = System.console();
        if (c != null) {
            line = c.readLine(prompt);
        } else {
            System.out.print(prompt);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                //Ignore
            }
        }
        return line;
    }

    static void End() {
        // Console asks if player wants to play again
        String replay = readLine("Play again? (yes) or (no)");
        replay = replay.toLowerCase();
        if (replay.equals("no")) {
            replayFull = false;
        }
    }

    public static void main (String[] args) {

        replayFull = true; // play again boolean
        do {
            turn = 0; // for armour experience
//            spawn.nRTT = 0; //for item spawn
            int gamemodeTitle = 0;
            while (gamemodeTitle < 1) {
                try {
                    gamemodeTitle = Integer.valueOf(readLine("STARYL\n<1> Play\n<2> Instructions\n<3> Leave\n"));
                } catch (NumberFormatException ex) {
                }
            }
            if (gamemodeTitle == 1) {

                currentRoomIndex = map.randomCity();

                do {
                    // prints info
                    map.getRoom(currentRoomIndex).printInfo();

                    String userInput = readLine(">");
                    userInput = userInput.toLowerCase();
                    if (userInput.equals("s") || userInput.equals("stats") || userInput.equals("gear info")) {
                        p.Stats();
                    } else if (userInput.equals("m") || userInput.equals("map")) {
                        seemaps.fullMap();
                    } else if (userInput.equals("b") || userInput.equals("backpack") || userInput.equals("inventory")) {
                        p.Inventory();
                    } else if (userInput.equals("l") || userInput.equals("leave")) {
                        map.getRoom(currentRoomIndex).printTravel();
                        String travel = readLine("\nWhere would you like to travel to? (Enter: (explore) or (e) to stay in current location)");
                        travel = travel.toLowerCase();
                        int direction = 0;
                        if ((direction = AdvMap.directionNumber(travel)) != 0) {
                            nDistance += 1;
                            Cityndx = AdvMap.directionNumber(travel);
                            AdvLocation nowRoom = map.getRoom(currentRoomIndex);
                            AdvLocation targetRoom = nowRoom.roomInDirection(direction);
                            if (targetRoom != null) {
                                currentRoomIndex = targetRoom.getIndex();
                                targetRoom.handleElement();
                            } else {
                                System.out.println("You can't move in that direction.");
                            }
                        } else if (travel.equals("bye")) {
                            Player.playerStats[0] = 0;
                        } else {
                            System.out.println("Command not understood");
                        }
                    } else if (userInput.equals("e") || userInput.equals("explore")) {
                        // org.cityOrganization(currentRoomIndex);
                    } else if (userInput.equals("bye")) {
                        Player.playerStats[0] = 0;
                    } else {
                        System.out.println("Command not understood.");
                    }
                } while (Player.playerStats[0] > 0);
                End();
                p.arrayReset();

            } else if (gamemodeTitle == 2) {
                TitleScreen.Instructions();
            } else if (gamemodeTitle == 3) {
                seemaps.fullMap();
            }

        } while (replayFull);


    }
}
