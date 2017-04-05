/**
 * Created by coffincw on 11/24/16.
 */
public class Gearset {

    int weaponClass = 0;

    static Player p = new Player();

    static String armour[] = {"Helmet", "Shirt", "Pants", "Boots"};
    static String weapons[] = {"Slingshot", "Machete", "Hunting Rifle", "Saber"};
    static String gear[] = {"Helmet", "Shirt", "Pants", "Boots", "Weapon"};

    static final String AMO_NAMES[] = {"Pebbles", "Bullets"};
    static int amo[] = {0, 0};

    static final String weaponStart[] = {"Wooden", "Rusted", "Cricket", "Wooden"};

    //v gear upgrades v

    //armour upgrades
    static final String armourUpgrade[] = {"Tin Foil", "Steel", "Ultimate", "Staryl - X"};
    // weapon upgrades
    static final String slingshotUpgrade[] = {"Wooden", "Metal", "Guardian", "Staryl - X"};
    static final String macheteUpgrade[] = {"Rusted", "Stainless Steel", "Wrath", "Staryl - X"};
    static final String rifleUpgrade[] = {"Cricket", "Winchester", "Remington", "Staryl - X"};
    static final String saberUpgrade[] = {"Wooden", "Metal", "Darkness", "Staryl - X" };

    static int armourUpValue[] = {0, 0, 0, 0}; // level of the weapon
    static int armourExp[] = {0, 0, 0, 0}; // exp held by armour

    static int weaponUpValue[] = {0, 0, 0, 0}; // level of weapon
    static int weaponExp[] = {0, 0, 0, 0}; // exp held by weapon

    void gearInfo(int i) {
        if (i > 0) {
            System.out.println("Gear Info: \n------");
        }
        for (int g = 0; g <= armour.length - 2 ; g++) {
            System.out.println(armourUpgrade[armourUpValue[g]] + " " + armour[g]);
        }
        if (weaponClass == 0) { // slingshot
            System.out.println(slingshotUpgrade[weaponUpValue[0]] + " " + weapons[weaponClass]);
        } else if (weaponClass == 1) { // machete
            System.out.println(macheteUpgrade[weaponUpValue[1]] + " " + weapons[weaponClass]);
        } else if (weaponClass == 2) { // rifle
            System.out.println(rifleUpgrade[weaponUpValue[2]] + " " + weapons[weaponClass]);
        } else if (weaponClass == 3) { // saber
            System.out.println(saberUpgrade[weaponUpValue[3]] + " " + weapons[weaponClass]);
        }
    }

    void armourLevelUp() {
        for (int e = 0; e <= armourExp.length - 1 ; e++) {
            if (armourExp[e] >= 100) {
                armourUpValue[e] ++;
                p.additionalDefense[e] += 10;
                System.out.println(armour[e] + " leveled up to: " + armourUpgrade[armourUpValue[e]]);
                armourExp[e] = 0;
            }
        }
        System.out.println();
    }

    void weaponLevelUp() {
        for (int e = 0 ; e <= weaponExp.length - 1 ; e++) {
            if (weaponExp[e] >= 100) {
                if (weaponClass >= 3 && weaponUpValue[e] >= 100) {}
                else {
                    weaponUpValue[e]++;
                    p.additionalDamage[0] += 10;
                    if (weaponClass == 0) {
                        System.out.println("Slingshot level up to " + slingshotUpgrade[weaponUpValue[e]]);
                    } else if (weaponClass == 1) {
                        System.out.println("Machete level up to " + macheteUpgrade[weaponUpValue[e]]);
                    } else if (weaponClass == 2) {
                        System.out.println("Hunting Rifle level up to " + rifleUpgrade[weaponUpValue[e]]);
                    } else if (weaponClass == 3) {
                        System.out.println("Saber leveled up to " + saberUpgrade[weaponUpValue[e]]);
                    }
                    weaponExp[e] = 0;
                }
            }
        }
    }

    void weaponClassUp() {
        for (int c = 0 ; c <= weaponUpValue.length - 1 ; c++) {
            if (weaponUpValue[c] > 4) {
                weaponClass ++;
                System.out.println("Your " + weapons[weaponClass - 1] + " classed up to " + weapons[weaponClass]);
                weaponUpValue[c] = 0;
                weaponExp[c] = 0;
            }
        }
    }

}
