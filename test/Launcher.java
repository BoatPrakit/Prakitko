
import Model.Map;
import Model.Character;
import Field.Field;
import java.util.ArrayList;
import Model.Prakitko;
import Model.Item;
import static databaseManagement.DatabaseSystem.*;
import java.util.Scanner;
import static Service.MapService.*;
import static Service.PrakitkoService.*;
import java.util.InputMismatchException;

/**
 *
 * @author Pattarapol coding , Sapondanai & Prakit debug
 */

public class Launcher {

    private static Prakitko prakitko;
    private static ArrayList<Item> item = new ArrayList<Item>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Apply(input);
        input.close();

    }

    public static void Apply(Scanner scanner) { //หน้า Login
        int number = 0;
        boolean checkString; // ตัว checkString ที่ user จะกรอกเข้ามา
        System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
        System.out.println("    ◄ 𝐏𝐑𝐀𝐊𝐈𝐓𝐊𝐎 : 𝐎𝐅𝐅𝐋𝐈𝐍𝐄𝐒𝐎𝐋𝐎𝐀𝐃𝐕𝐄𝐍𝐓𝐔𝐑𝐄™ ►   ");
        System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("\u001b[32m   Login & Register  \u001b[0m");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("[press 1] Login ");
        System.out.println("[press 2] Register ");
        System.out.println("[press 3] Credit ");
        do {
            System.out.print("Please choose your number : ");
            try {
                number = scanner.nextInt(); //ใช้ตัวเลข
                checkString = false; // set ตัวเเปล เพื่อเก็บเงื่อนไข while
            } catch (InputMismatchException ex) {
                scanner.nextLine(); // เก็บตัวอักษรที่หลุดมาจาก try
                checkString = true; // set ตัวเเปล เพื่อเก็บเงื่อนไข while
            }
        } while (checkString || number > 3 || number < 1); // check ค่าที่รับมาจาก checkString ว่าเป็น true / false || ถ้าเป็น int ห้ามมากกว่า 3 || ถ้าเป็น int ห้ามน้อยกว่า 1
        if (number == 2) { // register
            register();
            loading(scanner);

        }
        if (number == 1) { //login
            login(); // login
            System.out.println("--- Your Prakitko ---"); // เด่วเเก้เป็น profile();
            showPrakitkoForSelect(); // show prakitko ของ user

            int num = 0;
            do {
                if (choosePrakitko() != null) {
                    prakitko = choosePrakitko(); // prakitko ของ user
                }
                System.out.println("[press 1] Select "); //เลือกเพื่อเล่น
                System.out.println("[press 2] Delete "); //ลบเพื่อสร้างใหม่
                System.out.print("Choose : ");
                try {
                    num = scanner.nextInt();
                    checkString = false;
                } catch (InputMismatchException ex) {
                    scanner.nextLine();
                    checkString = true;
                }
                if (num == 1) {
                    if (prakitko == null) {
                        System.out.println("Please create prakitko first");
                        CreatePrakitko(scanner);
                    } else {
                        chooseMap(scanner); // เข้าไปเลือก map
                    }
                } else if (num == 2) {
                    deletePrakitko(prakitko); // ลบ prakitko
                    System.out.println("--- Your Prakitko has been delete ---");
                    System.out.println("--- Please Create Your new Prakitko ---");
                    CreatePrakitko(scanner); // สร้าง prakitko ใหม่
                }

            } while (checkString || num > 2 || num < 1); // รับ input เข้ามาไม่เกิน 5
        } else if (number == 3) {
            Credit(scanner);
            System.out.print("[press 1] Back To Login ");
            int input = scanner.nextInt();
            if (input == 1) {
                Apply(scanner);
            }
        }
    }

    public static void Credit(Scanner scanner) { // credit
        int num = scanner.nextInt();
        System.out.println("--- Credit ---");
        System.out.println("Boat : leader");
        System.out.println("Beng : member");
        System.out.println("Diz : member");
        System.out.println("--------------");
        System.out.println("[press 1] Back to Login");
        if (num == 1) {
            Apply(scanner);
        }
    }

    public static void loading(Scanner scanner) { // loading
        int input = 0; //เพื่อรับ int ได้ตั้งเเต่ 0
        boolean checkString; // ตัวเเปรที่ มารับค่า condition
        do {
            System.out.println("--- Do you want create your Prakitko?? ---");
            System.out.println("[press 1] Create Prakitko");
            System.out.println("[press 2] Back to Login");
            System.out.print("Choose : ");
            try {
                input = scanner.nextInt(); //รับค่า int เพื่อทำ statement ต่อไป
                checkString = false;// ตัวเเปรที่ มารับค่า condition
            } catch (InputMismatchException ex) { //ถ้า error ก็จะเเสดงใน catch
                scanner.nextLine(); // ถ้า try รับมาเป็น อักษร จะเเสดง อักษร เเละลงไปใน while
                checkString = true;// ตัวเเปรที่ มารับค่า condition
            }
            if (input == 1) {
                CreatePrakitko(scanner);
            }
            if (input == 2) {
                logout();
                Apply(scanner);
            }
        } while (checkString || input > 2 || input < 1);// check ค่าที่รับมาจาก checkString ว่าเป็น true / false || input ห้ามมากกว่า 2 || input ห้ามน้อยกว่า 1

    }

    public static void Menu(Scanner scanner) {
        int input = 0;
        boolean checkString;
        do {
            System.out.println("--- Menu ---");
            System.out.println("[press 1] Profile ");
            System.out.println("[press 2] Inventory ");
            System.out.println("[press 3] Choose Maps");
            System.out.println("[press 4] Logout");
            System.out.print("Choose : ");
            try {
                input = scanner.nextInt();
                checkString = false;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                checkString = true;
            }
            switch (input) {
                case 1:
                    profile(scanner);
                    break;
                case 2:
                    useItemInInventory();
                    break;
                case 3:
                    chooseMap(scanner);
                    break;
                case 4:
                    logout();
                    prakitko = null;
                    try {
                        System.out.println("Logging out...");
                        Thread.sleep(3000); // set delay เวลา 3 วินาที
                        System.out.println("Logout Completed");
                    } catch (Exception e) { // ถ้า error โชว์ใน catch 
                        System.out.println("Got EX");
                    }
                    Apply(scanner);
                    break;
            }
        } while (checkString || input > 4 || input < 1);

    }

    public static void profile(Scanner scanner) {
        int input = 0;
        boolean checkString;
        do {
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("--- Profile ---");
            System.out.println("Your Name : " + getUsername()); // โชว์ชื่อ user
            System.out.println("Your Prakitko : ");
            showPrakitkoForSelect(); // โชว์ prakitko ของ user
            System.out.println("[press 1] Inventory");
            System.out.println("-------------------");
            System.out.println("[press 2] Back to Menu");
            System.out.print("Choose : ");
            try {
                input = scanner.nextInt();
                checkString = false;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                checkString = true;
            }
            if (input == 1) {
                prakitko.showInventory();
            } else if (input == 2) {
                Menu(scanner);
            }
        } while (checkString || input > 2 || input < 1);

    }

    public static void CreatePrakitko(Scanner scanner) { // สร้าง Prakitko
        int number = 0;
        boolean checkString;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("--- Choose Prakitko ---");
            System.out.println("[press 1] Dog");
            System.out.println("Stat : Hp = 120 | Atk = 30 | AtkSpeed = 20 | Stamina = 100");
            System.out.println("[press 2] Cat");
            System.out.println("Stat : Hp = 100 | Atk = 30 | AtkSpeed = 24 | Stamina = 100");
            System.out.println("[press 3] Bird");
            System.out.println("Stat : Hp = 90 | Atk = 35 | AtkSpeed = 22 | Stamina = 100");
            System.out.println("[press 4] Fish");
            System.out.println("Stat : Hp = 90 | Atk = 32 | AtkSpeed = 21 | Stamina = 150");
            System.out.println("");
            System.out.print("Choose your number : ");
            try {
                number = scanner.nextInt();
                checkString = false;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                checkString = true;
            }
            if (number == 1) {
                System.out.print("Prakitko name : ");
                String name = input.nextLine();
                userEntryDogName(name); // ใส่ชื่อให้ prakitko
                createPrakitko(prakitko); // สร้าง prakitko ที่ user เลือก เเละนำเก็บในระบบ
                showPrakitkoForSelect(); // show prakitko ของ user 
                System.out.println("");
                Menu(scanner);

            } else if (number == 2) {
                System.out.print("Prakitko name : ");
                String name = input.nextLine();
                userEntryCatName(name);
                createPrakitko(prakitko);
                showPrakitkoForSelect();
                System.out.println("");
                Menu(scanner);

            } else if (number == 3) {
                System.out.print("Prakitko name : ");
                String name = input.nextLine();
                userEntryBirdName(name);
                createPrakitko(prakitko);
                showPrakitkoForSelect();
                System.out.println("");
                Menu(scanner);

            } else if (number == 4) {
                System.out.print("Prakitko name : ");
                String name = input.nextLine();
                userEntryFishName(name);
                createPrakitko(prakitko);
                showPrakitkoForSelect();
                System.out.println("");
                Menu(scanner);
            }

        } while (checkString || number > 4 || number < 1);
    }

    public static Character userEntryDogName(String name) { // สร้าง Dog
        prakitko = createDog(name);
        return prakitko;
    }

    public static Character userEntryCatName(String name) { // สร้าง Cat
        prakitko = createCat(name);
        return prakitko;
    }

    public static Character userEntryBirdName(String name) {// สร้าง Bird
        prakitko = createBird(name);
        return prakitko;
    }

    public static Character userEntryFishName(String name) {// สร้าง Fish
        prakitko = createFish(name);
        return prakitko;
    }

    public static void chooseMap(Scanner scanner) { // เลือกเเผนที่
        int number = 0;
        boolean checkString;
        do {
            System.out.println("--- Choose Map ---");
            System.out.println("[press 1] Map1 ");
            System.out.println("[coming soon] Map2 ");
            System.out.println("[coming soon] Map3 ");
            System.out.println("[press 4] Back to Menu ");
            System.out.println("[press 5] Logout");
            System.out.print("Choose : ");
            try {
                number = scanner.nextInt();
                checkString = false;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                checkString = true;
            }

            if (number == 1) {
                System.out.println("===================");
                System.out.println("   ✿ Forest ✿   ");
                System.out.println("===================");
                UserChooseMap1(scanner);
            } else if (number == 4) {
                Menu(scanner);
            } else if (number == 5) {
                logout();
                prakitko = null; // ทำให้ prakitko ในระบบหลัง logout
                try {
                    System.out.println("Logging out...");
                    Thread.sleep(3000);// ใช้ เวลา 3 วิ 
                    System.out.println("Logout Completed");
                } catch (Exception e) {
                    System.out.println("Got EX");
                }// logout เสร็จ เด้งหน้า login
                Apply(scanner);
            }

        } while (checkString || number != 1 || number != 4 || number != 5);

    }

    public static void UserChooseMap1(Scanner scanner) { // prepare to battle
        Map forest;
        forest = createForest();
        forest.clearMonster();
        forest = createForest();
        forest.arrayCheck(); //เช็คว่าในอยู่ใน map 
        inBattle(scanner, fightMode(forest));
    }

    private static Field fightMode(Map m) { // เเสดงชื่อ prakitko ใน map เเละ สร้าง field
        System.out.println("\u001b[33;1m Your Prakitko ⬇ \n" + prakitko);
        Field x = m.fight(prakitko);
        return x;
    }

    public static void inBattle(Scanner scanner, Field field) { // อยู่ใน Battle
        boolean checkString;
        int num = 0;
        do {
            do {
                int turn = 1;
                System.out.println("---------------------");
                System.out.println("Crash[press 1]");
                System.out.println("Use item[press 2]");
                System.out.println("Run!![press 3]");
                try {
                    num = scanner.nextInt();
                    checkString = false;
                } catch (InputMismatchException ex) {
                    scanner.nextLine();
                    checkString = true;
                }
                switch (num) {
                    case 1:
                        System.out.println("============================");
                        System.out.println(" ▂▃▅▆█ BATTLE!!! █▆▅▃▂ ");
                        System.out.println("           Turn " + turn);
                        System.out.println("============================");
                        turn += 1;
                        field.attack();
                        break;
                    case 2:
                        useItemInInventory();
                        break;
                    case 3:
                        try {
                            System.out.println("--- Start Escape!!! ---");
                            for (int i = 0; i < 3; i++) {
                                Thread.sleep(1000); // ใช้เวลาหนี 1 sec ต่อ Run!!! 1 ที
                                System.out.print("\u001b[32b Run!!! \n");
                            }
                            System.out.println("--- Escape Completed ---");
                            chooseMap(scanner);
                        } catch (Exception T) {
                            System.out.println("Got Ex");
                        }
                        break;
                }
            } while (!field.isMonsterDie() && !prakitko.isDead()); // ถ้ามอนตายไม่ต่อ ถ้ามอนไม่ตายจะทำต่อจนกว่ามอนจะตาย
            FightisEnd(scanner, field);
        } while (checkString || num > 3 || num < 1);
    }

    public static void FightisEnd(Scanner scanner, Field field) {
        if (field.isBattleEnd() == 1) {
            System.out.println("--- You win!!! ---");
            field.battleReward();
            try {
                Thread.sleep(2000);
                Menu(scanner);
            } catch (Exception e) {
                System.out.println("Got EX");
            }
            if (field.isBattleEnd() == 2) {
                System.out.println("--- You lose!!! ---");
                field.loseExp(prakitko.getCurrentExp());
                System.out.println("Try again [press 1]");
                System.out.println("Back to Menu [press 2]");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        chooseMap(scanner);
                        break;
                    case 2:
                        Menu(scanner);
                        break;
                }
            }
        }
    }
    
    public static void useItemInInventory() {
        System.out.println("--- Inventory ---");
        int currentNum = 1;
        for (Item currentItem : item) { // นำของใน item มาทำทีละชิ้นตาม array เเต่ละช่อง Ex Bur ช่องเเรก ก็จะเรียก Burger เเละทำต่อ
            System.out.println("[Press " + currentNum + "] " + currentItem);
            currentNum += 1;
        }
    }

}
