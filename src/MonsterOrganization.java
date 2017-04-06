/**
 * Created by coffincw on 11/30/16.
 */
public class MonsterOrganization {

    static PlayerAttack p_attack = new PlayerAttack();
    static Player p = new Player();
    static Gearset gear = new Gearset();
    static MonsterAttack m_attack = new MonsterAttack();

    boolean test = false;
    boolean training = false;


    final static String MONSTER_NAMES[] = {"Giv", "Kar", "Perrkill", "Turtower"};
    static int monsterHealth[] = {40, 50, 30, 60};
    final static int MONSTER_HEALTH_START[] = {40, 50, 30, 60};
    final static int monsterExp[] = {10, 15, 5, 20};
    final static int monsterDefense[] = {3, 10, 1, 20};

    void spawnMonster(int monsterIndex, int[] monsterhealthArray, String[] monsterNames, int possiblemonsterDMG_lowest, int possiblemonsterDMG_highest) {
        System.out.println("A " + monsterNames[monsterIndex] + " approaches...");
        p_attack.attack = 0;
        while (monsterhealthArray[monsterIndex] > 0 && p.playerStats[0] > 0) {
            p_attack.playerAttack(monsterNames[monsterIndex], monsterIndex, monsterhealthArray, training);
            if (monsterhealthArray[monsterIndex] > 0) {
                m_attack.mAttack(monsterNames[monsterIndex], AdvMain.randomInt(possiblemonsterDMG_lowest, possiblemonsterDMG_highest), test);
            }
        }
        if (monsterhealthArray[0] <= 0) {
            System.out.println("You defeated the " + monsterNames[monsterIndex] + " with " + p.playerStats[0] + " lives remaining!");
            expWon(monsterIndex);
        } else if (p.playerStats[0] <= 0) {
            System.out.println("You were defeated by the " + monsterNames[monsterIndex] + " who had " + monsterhealthArray[monsterIndex] + " health remaining.");
        }
        resetMonsterHealth();
    }

    void expWon(int monsterIndex) {
        int random = AdvMain.randomInt(0, 4);
        for (int i = 0; i <= gear.gear.length; i++) {
            if (random == i) {
                if (i == 4) {
                    gear.weaponExp[gear.weaponClass] += monsterExp[monsterIndex];
                    System.out.println(gear.gear[i] + " experience increased by " + monsterExp[monsterIndex]);
                    gear.weaponLevelUp();
                    gear.weaponClassUp();
                } else {
                    gear.armourExp[i] += monsterExp[monsterIndex];
                    System.out.println(gear.gear[i] + " experience increased by " + monsterExp[monsterIndex]);
                    gear.armourLevelUp();
                }

            }
        }

    }

    void resetMonsterHealth() {
        for (int r = 0; r <= monsterHealth.length - 1; r++) {
            monsterHealth[r] = MONSTER_HEALTH_START[r];
        }
    }

}
