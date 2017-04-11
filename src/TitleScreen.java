/**
 * Created by C on 11/15/2016.
 */

/*
Class which have all the information available on the title screen.  It allows the player the see the game instructions, score explained, maps and to just start the game.
 */
public class TitleScreen {

    static Player p = new Player();

    static void Instructions() {
        boolean instruct = true;
        while (instruct) {
            instruct = true;
            int instructionsOption = 0;
            while (instructionsOption < 1) {
                try {
                    instructionsOption = Integer.valueOf(AdvMain.readLine("Which would you like to learn about: \n<1> Game Instructions\n<2> Score Explained\n<3> Return to Title\n"));
                } catch (NumberFormatException ex) {
                }
            }
            if (instructionsOption == 1) {
                TitleScreen.gameInstruct();
            } else if (instructionsOption == 2) {
                TitleScreen.ScoreExp();
            } else if (instructionsOption == 3) {
                instruct = false;
            }
        }
    }

    static void gameInstruct() {
        System.out.println("");
    }

    static void ScoreExp() {
        System.out.println("");
    }
}
