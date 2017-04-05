/**
 * Created by caleb on 4/5/17.
 */
public class ViewableMaps {


    void MapMain() {
        String mapOption = AdvMain.readLine("(full) Full Map or (city) City Maps");

    }

    void fullMap() { // displays a print out version of map
        System.out.println("Map:" +
                "\n                              2 ---------- [Sansk]       " +
                "\n                              |               |          " +
                "\n                              |               |          " +
                "\n        [Eska] ------ 1 --  [Lana] ---------  3          " +
                "\n           |          |                       |          " +
                "\n           |          |                       |          " +
                "\n   6 -- [Teal] -- [CAPITAL] ------- [Jex]     |          " +
                "\n   |                  |                       4 -- [Ketl]" +
                "\n[Seths]               |                       |          " +
                "\n   |                [Zar] -- 5 -- [Quet] -- [Lzar]       " +
                "\n   |                         |                |          " +
                "\n   |                         |              [Sung]       " +
                "\n[Marl] ------------------ [Carl]                         ");
    }

}