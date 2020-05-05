package Controller;

import Model.Map;
import Model.Character;
import Field.Field;
import java.util.ArrayList;
import Model.Prakitko;
import Model.Item;
import Model.Monster;
import static databaseManagement.DatabaseSystem.*;
import java.util.Scanner;
import static Service.MapService.*;
import static Service.PrakitkoService.*;
import static Service.MonsterService.*;
import java.util.InputMismatchException;

/**
 *
 * @author Pattarapol coding , Sapondanai & Prakit debug
 */
public class Controller {

    private static Prakitko prakitko;

    //=============================================================================== All menu
    public static void Apply(Scanner scanner) { //หน้า Login
        int number = 0;
        boolean checkString; // ตัว checkString ที่ user จะกรอกเข้ามา
        System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
        System.out.println("   ◄\u001b[33;1m 𝐏𝐑𝐀𝐊𝐈𝐓𝐊𝐎 : 𝐎𝐅𝐅𝐋𝐈𝐍𝐄𝐒𝐎𝐋𝐎𝐀𝐃𝐕𝐄𝐍𝐓𝐔𝐑𝐄™ \u001b[0m►   ");
        System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
        System.out.println("");
        System.out.println("            ▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("           \u001b[33;1m   Login & Register  \u001b[0m");
        System.out.println("            ▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("            \u001b[32;1m[press 1]\u001b[0m Login ");
        System.out.println("            \u001b[32;1m[press 2]\u001b[0m Register ");
        System.out.println("            \u001b[32;1m[press 3]\u001b[0m Exit");
        System.out.println("");
        do { // คุมตัวเลขทีร insert เพื่อเลือก Login Regis Exit
            System.out.print("\u001b[4mPlease choose your number : \u001b[4m");
            try {
                number = scanner.nextInt(); //ใช้ตัวเลข
                checkString = false; // set ตัวเเปล เพื่อเก็บเงื่อนไข while
            } catch (InputMismatchException ex) {
                scanner.nextLine(); // เก็บตัวอักษรที่หลุดมาจาก try
                checkString = true; // set ตัวเเปล เพื่อเก็บเงื่อนไข while
            }
            if (checkString || number > 3 || number < 1) {
                System.out.println("Please insert again");
            }
        } while (checkString || number > 3 || number < 1); // check ค่าที่รับมาจาก checkString ว่าเป็น true / false || ถ้าเป็น int ห้ามมากกว่า 3 || ถ้าเป็น int ห้ามน้อยกว่า 1

        if (number == 2) { // --------------------------------------------------register
            register();
            loading(scanner);

        } else if (number == 3) { // ------------------------------------------------------------ออกจากเกม

            try {
                System.out.println("--- Thank you & See you again ... ---");
                for (int i = 0; i < 4; i++) {
                    Thread.sleep(1000); // ใช้เวลาหนี 1 sec ต่อ . 1 ที
                    System.out.print("\u001b[32b  . \n");
                }
                logout();
                prakitko = null;
                System.exit(0);

            } catch (Exception T) {
            }

        } else if (number == 1) { //---------------------------------------------------------------login
            login(); // login
            
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("\u001b[33;1m    Your Prakitko \u001b[0m");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒"); 
            showPrakitkoForSelect(); // show prakitko ของ user

            int num = 0;
            do { //คุมตัวเลขที่เลือก Go menu กับ Delete
                if (choosePrakitko() != null) {
                    prakitko = choosePrakitko(); // prakitko ของ user
                }
                System.out.println("\u001b[32;1m[press 1]\u001b[0m Go to Menu "); //เลือกเพื่อเล่น
                System.out.println("\u001b[32;1m[press 2]\u001b[0m Delete "); //ลบเพื่อสร้างใหม่
                System.out.println("");
                System.out.print("Choose : ");
                try {
                    num = scanner.nextInt(); //ใช้ตัวเลข
                    checkString = false; // set ตัวเเปล เพื่อเก็บเงื่อนไข while
                } catch (InputMismatchException ex) {
                    scanner.nextLine(); // เก็บตัวอักษรที่หลุดมาจาก try
                    checkString = true; // set ตัวเเปล เพื่อเก็บเงื่อนไข while
                }
                if (num == 1) {
                    if (prakitko == null) { // ถ้า prakitko เป็น null หรือ user ไม่มี prakitko
                        System.out.println("Please create prakitko first");
                        CreatePrakitko(scanner);
                    } else {
                        Menu(scanner); // เข้าไปเลือก map
                        System.out.println("");
                    }
                } else if (num == 2) {
                    if (prakitko != null) {
                        deletePrakitko(prakitko); // ลบ prakitko
                        try {
                            System.out.println("Deleting...");
                            Thread.sleep(3000); // set delay เวลา 3 วินาที เพื่อ logout
                            System.out.println("--- Your Prakitko has been delete ---");
                            System.out.println("--- Please Create Your new Prakitko ---");
                        } catch (Exception e) { // ถ้า error โชว์ใน catch 
                        }
                        CreatePrakitko(scanner); // สร้าง prakitko ใหม่
                    } else {
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
                        System.out.println("Please create Prakitko");
                        CreatePrakitko(scanner);
                    }

                }
            } while (checkString || num > 2 || num < 1); // check ค่าที่รับมาจาก checkString ว่าเป็น true / false || ถ้าเป็น int ห้ามมากกว่า 3 || ถ้าเป็น int ห้ามน้อยกว่า 1
        }
    }

    public static void loading(Scanner scanner) { // loading
        int input = 0; //เพื่อรับ int ได้ตั้งเเต่ 0
        boolean checkString; // ตัวเเปรที่ มารับค่า condition
        do {
            System.out.println("--- Do you want create your Prakitko?? ---");
            System.out.println("\u001b[32;1m[press 1]\u001b[0m Create Prakitko");
            System.out.println("\u001b[32;1m[press 2]\u001b[0m Back to Login");
            System.out.println("");
            System.out.print("Choose : ");
            try {
                input = scanner.nextInt(); //รับค่า int เพื่อทำ statement ต่อไป
                checkString = false;// ตัวเเปรที่ มารับค่า condition
            } catch (InputMismatchException ex) { //ถ้า error ก็จะเเสดงใน catch
                scanner.nextLine(); // ถ้า try รับมาเป็น อักษร จะเเสดง อักษร เเละลงไปใน while
                checkString = true;// ตัวเเปรที่ มารับค่า condition
            }
            if (input == 1) { // สร้าง prakitko
                CreatePrakitko(scanner);
            }
            if (input == 2) { // logout
                logout(); // account ผู้เล่นออก
                prakitko = null; //เพื่อให้ prakitko ที่ค้างไว้ในเกม หายไปด้วย
                try {
                    System.out.println("Logging out...");
                    Thread.sleep(3000); // set delay เวลา 3 วินาที เพื่อ logout
                    System.out.println("Logout Completed");
                } catch (Exception e) { // ถ้า error โชว์ใน catch 
                }
                Apply(scanner); // logout เสร็จ กลับไปหน้า Menu
            }
        } while (checkString || input > 2 || input < 1);// check ค่าที่รับมาจาก checkString ว่าเป็น true / false || input ห้ามมากกว่า 2 || input ห้ามน้อยกว่า 1

    }

    public static void Menu(Scanner scanner) { // Menu
        int input = 0;
        boolean checkString;
        do {
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("\u001b[33;1m         Menu \u001b[330m");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("\u001b[32;1m[press 1]\u001b[0m Profile ");
            System.out.println("\u001b[32;1m[press 2]\u001b[0m Inventory ");
            System.out.println("\u001b[32;1m[press 3]\u001b[0m Choose Maps");
            System.out.println("\u001b[32;1m[press 4]\u001b[0m Logout");
            System.out.println("\u001b[32;1m[press 5]\u001b[0m Exit");
            System.out.println("");
            System.out.print("Choose : ");
            try {
                input = scanner.nextInt();
                checkString = false;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                checkString = true;
            }
            switch (input) {
                case 1: // เลือก profile
                    profile(scanner);
                    break;
                case 2: // เลือก Inventory
                    useItemInInventory(scanner); //โชว์ หรือ ใช้ item
                    Menu(scanner);// เมื่อ show || Use item เสร็จก็จะเด้งไปหน้า Menu เเบบ auto
                    break;
                case 3:// เลือก เเผนที่
                    chooseMap(scanner);
                    break;
                case 4:// เลือก logout
                    logout();
                    prakitko = null;
                    try {
                        System.out.println("Logging out...");
                        Thread.sleep(3000); // set delay เวลา 3 วินาที
                        System.out.println("Logout Completed");
                    } catch (Exception e) { // ถ้า error โชว์ใน catch 
                    }
                    Apply(scanner);
                    break;
                case 5:// Exit
                    try {
                        logout();
                        prakitko = null;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                        System.out.println("        \u001b[33;1mExit\u001b[330m ");
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                        System.out.println("Thank you & See you again...");
                        for (int i = 0; i < 4; i++) {
                            Thread.sleep(1000); // ใช้เวลาหนี 1 sec ต่อ . 1 ที
                            System.out.print("\u001b[32b  . \n");
                        }
                        System.exit(0);
                    } catch (Exception T) {
                    }

            }
        } while (checkString || input > 5 || input < 1);

    }

    public static void profile(Scanner scanner) { // profile
        int input = 0;
        boolean checkString;
        do { //คุมตัวเลขที่ใช้เลือก Inventory & Back to menu
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("        \u001b[33;1mProfile\u001b[330m ");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.format("%-10s : %s\n","Username",getUsername());
            showPrakitkoForSelect(); // โชว์ prakitko ของ user
            try{
                   double x = ((double)prakitko.getCurrentExp()*10)/((double)prakitko.getCurrentMaxExp());
                   if (x > 8) {
                       System.out.println("\u001b[0mExp : "+x*10+"%"+"┣\u001b[33;1m█████████\u001b[0m█┫");
                   }
                   else if (x > 7) {
                       System.out.println("\u001b[0mExp : "+x*10+"%"+"┣\u001b[33;1m████████\u001b[0m██┫");
                   }
                   else if (x > 6) {
                       System.out.println("\u001b[0mExp : "+x*10+"%"+"┣\u001b[33;1m███████\u001b[0m███┫");
                   }
                   else if (x > 5) {
                       System.out.println("\u001b[0mExp : "+x*10+"%"+"┣\u001b[33;1m██████\u001b[0m████┫");
                   }
                   else if (x > 4) {
                       System.out.println("\u001b[0mExp : "+x*10+"%"+"┣\u001b[33;1m█████\u001b[0m█████┫");
                   }
                   else if (x > 3) {
                       System.out.println("\u001b[0mExp : "+x*10+"%"+"┣\u001b[33;1m████\u001b[0m██████┫");
                   }
                   else if (x > 2) {
                       System.out.println("\u001b[0mExp : "+x*10+"%"+"┣\u001b[33;1m███\u001b[0m███████┫");
                   }
                   else if (x > 1) {
                       System.out.println("\u001b[0mExp : "+x*10+"%"+"┣\u001b[33;1m██\u001b[0m████████┫");
                   }
                   else if (x < 0) {
                       System.out.println("\u001b[0mExp : "+x*10+"%"+"┣\u001b[33;1m█\u001b[0m█████████┫");
                   }else
                       System.out.println("\u001b[0mExp : "+x*10+"%"+"┣┣██████████┫");
            }catch(NullPointerException nullex){}
            System.out.println("\u001b[32;1m[press 1]\u001b[0m Inventory");

            System.out.println("\u001b[32;1m[press 2]\u001b[0m Back to Menu");
            System.out.println("");
            System.out.print("Choose : ");
            try {
                input = scanner.nextInt();
                checkString = false;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                checkString = true;
            }
            if (input == 1) { // โชว์ เเละ ใช้ Item ใน Inventory
                useItemInInventory(scanner);
                System.out.println("");
                Menu(scanner); //โชว์เสร็จ || ใช้เสร็จ กลับไปหน้า Menu

            } else if (input == 2) { // กลับไปหน้า Menu
                Menu(scanner);
            }
        } while (checkString || input > 2 || input < 1);

    }

    //================================================================================= // Prakitko
    public static void CreatePrakitko(Scanner scanner) { // สร้าง Prakitko
        int number = 0;
        boolean checkString;
        do { //คุมตัวเลขเลือก prakitko เเต่ละตัว
            Scanner input = new Scanner(System.in);
            System.out.println("");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("    \u001b[33;1mChoose Prakitko \u001b[0m");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("");
            System.out.println("\u001b[32;1m[press 1]\u001b[0m Dog");
            System.out.println("✪ Stat : \u001b[31;1m❤\u001b[0m Hp = 120 | \u001b[33;1m⚔\u001b[0m Atk = 30 | \u001b[32;1m🍃\u001b[0m AtkSpeed = 20 | \u001b[36;1m♨\u001b[0m Stamina = 100");

            System.out.println("\u001b[32;1m[press 2]\u001b[0m Cat");
            System.out.println("✪ Stat : \u001b[31;1m❤\u001b[0m Hp = 100 | \u001b[33;1m⚔\u001b[0m Atk = 30 | \u001b[32;1m🍃\u001b[0m AtkSpeed = 24 | \u001b[36;1m♨\u001b[0m Stamina = 100");

            System.out.println("\u001b[32;1m[press 3]\u001b[0m Bird");
            System.out.println("✪ Stat : \u001b[31;1m❤\u001b[0m Hp = 90  | \u001b[33;1m⚔\u001b[0m Atk = 35 | \u001b[32;1m🍃\u001b[0m AtkSpeed = 22 | \u001b[36;1m♨\u001b[0m Stamina = 100");

            System.out.println("\u001b[32;1m[press 4]\u001b[0m Fish");
            System.out.println("✪ Stat : \u001b[31;1m❤\u001b[0m Hp = 90  | \u001b[33;1m⚔\u001b[0m Atk = 32 | \u001b[32;1m🍃\u001b[0m AtkSpeed = 21 | \u001b[36;1m♨\u001b[0m Stamina = 150");
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
                Menu(scanner); // สร้าง prakitko เสร็จ จะพาไปหน้า Menu 

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
    //============================================================================ // เเผนที่

    public static void chooseMap(Scanner scanner) { // เลือกเเผนที่
        int number = 0;
        boolean checkString;
        do {
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("\u001b[33;1m     Choose Map\u001b[0m ");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("\u001b[32;1m[press 1]\u001b[0m Forest");
            System.out.println("\u001b[32;1m[press 2]\u001b[0m HideOut ");
            System.out.println("\u001b[32;1m[press 3]\u001b[0m GraveYard ");
            System.out.println("\u001b[32;1m[press 4]\u001b[0m Back to Menu ");
            System.out.println("\u001b[32;1m[press 5]\u001b[0m Logout");
            System.out.println("");
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
                System.out.format("   %c Forest %c   \n",0x1F33F,0x1F33F);
                System.out.println("===================");
                UserChooseMap1(scanner);
            } else if (number == 2) {
                System.out.println("===================");
                System.out.format("   %c HideOut %c   \n",0x1F3E0,0x1F3E0);
                System.out.println("===================");
                UserChooseMap2(scanner);
            } else if (number == 3) {
                System.out.println("===================");
                System.out.format("   %c GraveYard %c   \n",0x1F480,0x1F480);
                System.out.println("===================");
                UserChooseMap3(scanner);
            } else if (number == 4) {
                Menu(scanner);
            } else if (number == 5) {
                logout();
                prakitko = null; // ทำให้ prakitko ในระบบหลัง logout
                try {
                    System.out.println("Logging out...");
                    Thread.sleep(3000);// ใช้ เวลา 3 วิ 
                    System.out.println("Logout Completed");
                    System.out.println("");
                } catch (Exception e) {
                }// logout เสร็จ เด้งหน้า login
                Apply(scanner);
            }

        } while (checkString || number > 5 || number < 1);

    }

    public static void UserChooseMap1(Scanner scanner) { // prepare to battle
        Map forest;
        forest = createForest();
        forest.arrayCheck(); //เช็คว่าในอยู่ใน map 
        inBattle(scanner, fightMode(forest), 1, true);
    }

    public static void UserChooseMap2(Scanner scanner) {
        Map hideout;
        hideout = createHideOut();
        hideout.arrayCheck();
        inBattle(scanner, fightMode(hideout), 1, true);
    }

    public static void UserChooseMap3(Scanner scanner) {
        Map graveyard;
        graveyard = createGraveYard();
        graveyard.arrayCheck();
        inBattle(scanner, fightMode(graveyard), 1, true);
    }

    private static Field fightMode(Map m) { // เเสดงชื่อ prakitko ใน map เเละ สร้าง field
        System.out.println("\u001b[33;1m Your Prakitko ⬇ \n" + prakitko);
        m.reRandomLevelMonster(); // สุ่ม level เเละ สุ่ม monster 
        Field newField = new Field(prakitko, m.getRandomMonster()); // สร้าง field
        return newField;
    }
    //============================================================================= // ต่อสู้

    public static void inBattle(Scanner scanner, Field field, int oldTurn, boolean oldIsFirstTurn) { // อยู่ใน Battle
        boolean checkString;
        int num = 0;
        int turn = oldTurn; // รอบเก่าที่ส่งไปที่ use item เพื่อมาเรียกใช้ต่อในตอน use item เสร็จ
        boolean isFirstTurn = oldIsFirstTurn; // เรียก turn ที่ต่อจาก turn ที่เเล้ว เพื่อมาทำต่อ
        if (isFirstTurn) { //เป็น turn เเรกมั้ย ถ้าเป็นทำต่อ ถ้าไม่เป็นก็เป็น false

            field.whoHere();

        }
        do { //คุมเงื่อนไขตัวเลขเลือก choice

            do { //คุมเงื่อนไข การตายของ prakitko เเละ monster

                System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                System.out.println("\u001b[32;1m[press 1]\u001b[0m Crash");
                System.out.println("\u001b[32;1m[press 2]\u001b[0m Use item");
                System.out.println("\u001b[32;1m[press 3]\u001b[0m Run!!");
                System.out.println("");
                System.out.print("Choose : ");
                try {
                    num = scanner.nextInt();
                    checkString = false;
                } catch (InputMismatchException ex) {
                    scanner.nextLine();
                    checkString = true;
                }
                switch (num) {
                    case 1: // เลือกสู้

                        System.out.println("============================");
                        System.out.println(" ▂▃▅▆█ BATTLE!!! █▆▅▃▂ ");
                        System.out.println("           Turn " + turn); // เลขบอกรอบในการต่อสู้
                        System.out.println("============================");
                        turn += 1; // บวกเพิ่มครั้งของ turn 
                        System.out.println("");
                        field.attack(); // ต่อสู้
                        field.whoHere();
                        break;
                    case 2: //ใช้ Item ในการต่อสู้
                        useItemInBattle(scanner, field, turn, isFirstTurn);
                        break;
                    case 3: //หนี
                        try {
                            System.out.println("--- Start Escape!!! ---");
                            for (int i = 0; i < 4; i++) {
                                Thread.sleep(1000); // ใช้เวลาหนี 1 sec ต่อ Run!!! 1 ที
                                System.out.print("\u001b[32b Run!!! \n");
                            }
                            System.out.println("--- Escape Completed ---");
                            chooseMap(scanner);
                        } catch (Exception T) {
                        }
                        break;
                }
            } while (!field.isMonsterDie() && !prakitko.isDead()); // ถ้ามอนตายหลุดออกจาก loop  เเละ ถ้ามอนไม่ตายจะทำต่อจนกว่ามอนจะตาย
            FightisEnd(scanner, field); // หลุดออกจากการต่อสู้
            isFirstTurn = false;
        } while (checkString || num > 3 || num < 1);
    }

    public static void FightisEnd(Scanner scanner, Field field) { // จบการต่อสู้
        if (field.isBattleEnd() == 1) { // ถ้าชนะ จะทำเมื่อ Monster ตาย
            System.out.println("★★★ You win!!! ★★★");
            field.battleReward(); //ให้รางวัล ผู้เล่น Exp & Item 
            try {
                Thread.sleep(2000); //รอ 2 วิ ในการหลุดออกจาก หน้าให้ reward
                Menu(scanner); // ไป Menu
            } catch (Exception e) {
            }

        } else if (field.isBattleEnd() == 2) { // ถ้าเเพ้ จะทำเมื่อ Prakitko ตาย
            System.out.println("☠☠☠ You lose!!! ☠☠☠");
            field.battleReward(); //หัก Exp ที่ผู้เล่นได้ เเละ ไม่ได้ item 
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

            try { // Prakitko Respawning
                System.out.println("--- ☠ Your Prakitko is dead ☠ ---");
                System.out.println("Wait!...Your Prakitko is respawning...");
                for (int i = 0; i < 4; i++) { //ทำ . 4 รอบ
                    Thread.sleep(1000); // ใช้เวลาหนี 1 sec ต่อ Run!!! 1 ที
                    System.out.print("\u001b[32b .  \n");
                }
                System.out.println("--- Your Prakitko has been respawned ---");
                prakitko.respawn(); //respawn prakitko เเล้ว
            } catch (Exception ex) {
            }

            int number = 0;
            boolean checkString;
            do { // คุมการเลือกตัวเลขเลือก try & Bacm to menu
                System.out.println("\u001b[32;1m[press 1]\u001b[0m Try again ");
                System.out.println("\u001b[32;1m[press 2]\u001b[0m Back to Menu ");
                System.out.println("");
                System.out.print("Choose : ");

                try {
                    number = scanner.nextInt();
                    checkString = false;
                } catch (InputMismatchException ex) {
                    scanner.nextLine();
                    checkString = true;
                }
                switch (number) {
                    case 1: // try again จะกลับไป หน้าเลือกเเมพ
                        chooseMap(scanner);
                        break;
                    case 2: // Back to menu จะกลับไป หน้า Menu
                        Menu(scanner);
                        break;
                }
            } while (checkString || number > 2 || number < 1);
        }
    }

    //====================================================================================== Item
    public static void useItemInInventory(Scanner scanner) { // Inventory ใช้ใน Menu
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println(" \u001b[33;1m     inventory\u001b[0m ");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒\n");
        ArrayList<Item> inventory = prakitko.getInventory();

        prakitko.showInventory();

        int input = 0;
        boolean checkString;

        do {
            System.out.println("");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            try {
                System.out.println("\u001b[32;1m[press 6]\u001b[0m Back to menu");
                System.out.print("Choose your item number : ");
                input = scanner.nextInt();
                checkString = false;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                checkString = true;
            }
            if (input > 0 && input <= inventory.size()) {
                prakitko.useItem(inventory.get(input - 1));
                prakitko.showInventory();
            } else if (input == 6) {
                Menu(scanner);
            }
        } while (checkString || input > 1 || input <= 6);

    }

    public static void useItemInBattle(Scanner scanner, Field field, int turn, boolean isFirstTurn) { // Inventory ใช้ใน Battle
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println(" \u001b[33;1m     inventory\u001b[0m ");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒\n");
        ArrayList<Item> inventory = prakitko.getInventory(); // เอา ของใน Inventory โยนลงไปใน ArrayList

        prakitko.showInventory(); // โชว์ item ใน inventory

        int input = 0; //เอาไว้เลือก item
        boolean checkString;

        do {
            System.out.println("");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            try {
                System.out.println("\u001b[32;1m[press 6]\u001b[0m Back to Battle");
                System.out.print("Choose your item number : ");

                input = scanner.nextInt();
                checkString = false;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                checkString = true;
            }
            if (input > 0 && input <= inventory.size()) { // สามารถกรอก input ได้ตามลำดับเลขของ item เเต่ละชิ้น 
                prakitko.useItem(inventory.get(input - 1)); //เรียกใช้ item ใน ArrayList ทำไมต้อง input-1 เพราะว่า ค่าที่กรอกเข้ามาเป็นค่าเเรกจะไปเลือก item ช่อง ที่ 0 ถ้าผู้เล่นกรอกมา input ของผู้เล่นจะ -1 เพื่อให้ตัวเลขที่ input เข้ามาตรงกับช่องใน array
                prakitko.showInventory();
            } else if (input == 6) { // จะย้อนกลับไปการต่อสู้ต่อ
                inBattle(scanner, field, turn, isFirstTurn);
            }
        } while (checkString || input > 1 || input <= 6);

    }

}
