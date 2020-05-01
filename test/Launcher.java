
import Field.Character;
import Field.Field;
import java.util.ArrayList;
import java.util.Collections;
import prakitkomodel.Cat;
import prakitkomodel.Dog;
import prakitkomodel.Fish;
import prototype.Prakitko;
import Field.Item;
import Field.*;
import prakitkomodel.Dog;
import prototype.Prakitko;
import Item.*;
import static databaseManagement.DatabaseSystem.*;
import java.util.Scanner;
import monstermodel.Slime;
import prakitkomodel.Bird;
import prototype.Monster;
import status.STATUS;
import Item.*;

public class Launcher {

    private static Prakitko prakitko;
    private static Item item;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Apply(input);
        input.close();

    }

    public static void Apply(Scanner scanner) {
        System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
        System.out.println("    ◄ 𝐏𝐑𝐀𝐊𝐈𝐓𝐊𝐎 : 𝐎𝐅𝐅𝐋𝐈𝐍𝐄𝐒𝐎𝐋𝐎𝐀𝐃𝐕𝐄𝐍𝐓𝐔𝐑𝐄™ ►   ");
        System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("\u001b[32m   Login & Register  \u001b[0m");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("[press 1] Login ");
        System.out.println("[press 2] Register ");
        System.out.println("[press 3] Credit ");
        System.out.print("Please choose your number : ");
        int number = scanner.nextInt();

        if (number == 2) { // หน้า register
            register(); // register
            loading(scanner);

        }
        if (number == 1) { //หน้า login
            login(); // login
//            MenuSwCase(scanner); // Menu
            System.out.println("--- Your Prakitko ---"); // เด่วเเก้เป็น profile();
            showPrakitkoForSelect(); // show prakitko ของ user

            int num;
            do {
                try {
                    prakitko = choosePrakitko(); // prakitko ของ user
                } catch (NullPointerException ex) {

                }

                System.out.println("[press 1] Select "); //เลือกเพื่อเล่น
                System.out.println("[press 2] Delete "); //ลบเพื่อสร้างใหม่

                num = scanner.nextInt();

                if (num == 1) {
                    chooseMap(scanner); // เข้าไปเลือก map
                }
                if (num == 2) {
                    deletePrakitko(prakitko); // ลบ prakitko
                    System.out.println("--- Your Prakitko has been delete ---");
                    System.out.println("--- Please Create Your new Prakitko ---");
                    CreatePrakitko(scanner); // สร้าง prakitko ใหม่
                }
            } while (num != 5); // รับ input เข้ามาไม่เกิน 5
        }
        if (number == 3) {
            Credit();
            System.out.print("[press 1] Back To Menu ");

            int input = scanner.nextInt();
            if (input == 1) {
                Apply(scanner);
            }
        }
    }

//    public static void MenuSwCase(Scanner scanner) {
//        System.out.println("--- Game Name ---");
//        System.out.println("Play Game[press 1]");
//        System.out.println("Logout [press 2]");
//        System.out.println("Credit[press 3]");
//        Scanner num = new Scanner(System.in);
//        System.out.print("Choose : ");
//        int choose = num.nextInt();
//        switch (choose) {
//            case 1:
//                System.out.println("--- Your Prakitko ---");
//                showPrakitkoForSelect(); // show prakitko ของ user
//                loading(scanner); // หน้า ถาม user ว่ามี prakitko มั้ย?
//                break;
//            case 2:
//                logout();
//                break;
//            case 3:
//
//                Credit();
//                System.out.println("Back To Menu [press 0]");
//
//        }
//    }
    public static void Credit() {
        System.out.println("Boat : leader");
        System.out.println("Beng : member");
        System.out.println("Diz : member");
    }

    public static void loading(Scanner scanner) {
        System.out.println("--- Do u want create ur Prakitko?? ---");
        System.out.println("Create Prakitko[press 1]");
        System.out.println("Back to menu[press 2]");
        System.out.print("Choose : ");
        int input = scanner.nextInt();
        if (input == 1) {
            CreatePrakitko(scanner);
        }
        if (input == 2) {
            Apply(scanner);
        }
    }

    public static void profile(Scanner scanner) {
        System.out.println("Yourname : ");

        System.out.println("Your Prakitko : ");
        showPrakitkoForSelect();
        System.out.print("Inventory [press i] : ");
        String input = scanner.next();

        if (input == input) {
            prakitko.showInventory();
        }

        System.out.println("----------------");
        System.out.println("Choose map [press 1]");
        int number = scanner.nextInt();
        if (number == 1) {
            chooseMap(scanner);
        }
    }

    public static void CreatePrakitko(Scanner scanner) { // สร้าง Prakitko
        Scanner input = new Scanner(System.in);
        System.out.println("--- Choose Prakitko ---");
        System.out.println("Dog[press 1]");
        System.out.println("Cat[press 2]");
        System.out.println("Bird[press 3]");
        System.out.println("Fish[press 4]");
        System.out.println("");

        System.out.print("Choose ur number : ");
        int number = scanner.nextInt();

        if (number == 1) {
            System.out.print("Prakitko name : ");
            String name = input.nextLine();
            userEntryDogName(name);
            createPrakitko(prakitko);
            showPrakitkoForSelect(); // show prakitko ของ user อีกรอบเพื่อ เช็คว่า มี prakitko หรือไม่ 
            System.out.println("");
            chooseMap(scanner);

        }
        if (number == 2) {
            System.out.print("Prakitko name : ");
            String name = input.nextLine();
            userEntryCatName(name);
            createPrakitko(prakitko);
            showPrakitkoForSelect();
            System.out.println("");
            chooseMap(scanner);

        }
        if (number == 3) {
            System.out.print("Prakitko name : ");
            String name = input.nextLine();
            userEntryBirdName(name);
            createPrakitko(prakitko);
            showPrakitkoForSelect();
            System.out.println("");
            chooseMap(scanner);

        }
        if (number == 4) {
            System.out.print("Prakitko name : ");
            String name = input.nextLine();
            userEntryFishName(name);
            createPrakitko(prakitko);
            showPrakitkoForSelect();
            System.out.println("");
            chooseMap(scanner);
        }

    }

    public static Character userEntryDogName(String name) {
        prakitko = new Dog(name);
        return prakitko;
    }

    public static Character userEntryCatName(String name) {
        prakitko = new Cat(name);
        return prakitko;
    }

    public static Character userEntryBirdName(String name) {
        prakitko = new Bird(name);
        return prakitko;
    }

    public static Character userEntryFishName(String name) {
        prakitko = new Fish(name);
        return prakitko;
    }

    public static void chooseMap(Scanner scanner) {
        System.out.println("Choose Map");
        System.out.println("Map1 [press 1]");
        System.out.println("Map2 [coming soon]");
        System.out.println("Map3 [coming soon 3]");
        System.out.println("Back to Profile [press 4]");
        System.out.println("Back to menu [press 5]");
        System.out.print("Choose : ");

        int number = scanner.nextInt();

        if (number == 1) {
            System.out.println("===================");
            System.out.println("   ✿ Forest ✿   ");
            System.out.println("===================");
            UserChooseMap1(scanner);
        }
        if (number == 4) {
            profile(scanner);
        }
        if (number == 5) {
            Apply(scanner);
        }

    }

    public static void UserChooseMap1(Scanner scanner) { // prepare to battle
        Map1 forest = new Map1();
        forest.arrayCheck();
        inBattle(scanner, fightMode(forest));
    }

    private static Field fightMode(Map m) { // เเสดงชื่อ prakitko ใน map เเละ สร้าง field
        System.out.println("Your Prakitko : " + prakitko);
        Field x = m.fight(prakitko);
        return x;
    }

    public static void inBattle(Scanner scanner, Field field) {
        do {
            System.out.println("---------------------");
            System.out.println("Crash[press 1]");
            System.out.println("Use item[press 2]");
            System.out.println("Run!![press 3]");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("============================");
                    System.out.println(" ▂▃▅▆█ BATTLE!!! █▆▅▃▂ ");
                    System.out.println("============================");
                    field.attack();
                    break;
                case 2:
                    useItemInInventory();
                    break;
                case 3:
                    try {
//                        System.out.println("Run! \n");
//                        Thread.sleep(3000);
//                        System.out.println("Completed \n");
//                        chooseMap(scanner);
                        for (int i = 0; i < 100; i++) {
                            Thread.sleep(100);
                            System.out.println("\r\u001b[32b;1m"+i+"%");
                        }
                    } catch (Exception T) {
                        System.out.println("Got Ex");
                    }
                    break;

            }

        } while (!field.isMonsterDie() || !prakitko.isDead()); // ถ้ามอนตายไม่ต่อ ถ้ามอนไม่ตายจะทำต่อจนกว่ามอนจะตาย
        FightisEnd(scanner, field);
    }

    public static void FightisEnd(Scanner scanner, Field field) {
        if (prakitko.isDead()) {
            System.out.println("--- You lose!!! ---");
            System.out.println("Try again [press 1]");
            System.out.println("Back to Profile [press 2]");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    chooseMap(scanner);
                    break;
                case 2:
                    profile(scanner);
                    break;
            }
        } else if (field.isMonsterDie()) {
            System.out.println("--- You win!!! ---");
            System.out.println("");
        }
    }

    public static Item useTaco() {
        item = new Taco();
        return item;
    }

    public static Item useCake() {
        item = new Cake();
        return item;
    }

    public static Item useBurger() {
        item = new Burger();
        return item;
    }

    public static Item useHelingPotion() {
        item = new HealingPotion();
        return item;
    }

    public static Item useStaminaPotion() {
        item = new StaminaPotion();
        return item;
    }

    public static void useItemInInventory() {
        System.out.println("--- Inventory ---");
        prakitko.showInventory();

    }

}
