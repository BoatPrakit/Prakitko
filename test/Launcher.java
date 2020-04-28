
import Field.Character;
import Field.Field;
import java.util.ArrayList;
import java.util.Collections;
import prakitkomodel.Cat;
import prakitkomodel.Dog;
import prakitkomodel.Fish;
import prototype.Prakitko;
import Field.Item;
import Field.Map1;
import prakitkomodel.Dog;
import prototype.Prakitko;
import Item.*;
import java.util.Scanner;
import monstermodel.Slime;
import prototype.Monster;
import status.STATUS;
import static databaseManagement.DatabaseSystem.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher {

    private static Prakitko prakitko;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        MenuSwCase();


    }

//    public static void Menu(){ // Menu เเบบ ปกติ
//        System.out.println("--- Game Name ---");
//        System.out.println("Play Game[press 1]");
//        System.out.println("Credit[press 0]");
//        Scanner select = new Scanner(System.in);
//        System.out.println("Choose ur number : ");
//        int number = select.nextInt();
//        if(number == 1){
//            CreatePrakitko();
//        }if(number == 0){
//            System.out.println("Prakit : Leader");
//            System.out.println("Sapondanai : member");
//            System.out.println("Pattarapol : member");
//            Menu();
//        }
//    }
    
    public static void MenuSwCase() { // Menu เเบบ Switch Case
        System.out.println("--- Game Name ---");
        System.out.println("Play Game[press 1]");
        System.out.println("Credit[press 0]");
        Scanner num = new Scanner(System.in);
        System.out.println("Choose ur number");
        int choose = num.nextInt();
        System.out.println("Choose : " + choose);
        switch (choose) {
            case 1:
                Apply();

            case 2:

                Credit();
                System.out.println("Back To Menu [press 0]");
                Scanner i = new Scanner(System.in);

        }
    }
    
    public static void Apply() {
//        Scanner num = new Scanner(System.in);
//        Scanner input = new Scanner(System.in);
        System.out.println("--- Login & Register ---");
        System.out.println("Register [press 1]");
        System.out.println("Login [press 2]");
        System.out.println("please choose ur number : ");
        int number = input.nextInt();

        if (number == 1) {
            createId();
            loading();
//          showPrakitkoForSelect();
        }
        if (number == 2) {
            login();
            showPrakitkoForSelect();
            prakitko = choosePrakitko();
        }
    }
    
    public static void loading(){
        System.out.println("--- Wanna create ur Prakitko?? ---");
        System.out.println("Yes[press 1]");
        System.out.println("No and back to Menu[press 2]");
        try {
            System.out.println(System.in.available());
        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num = input.nextInt();
        System.out.println("ur number : "+ num );
        switch(num){
            case 1 :
                CreatePrakitko();
            case 2 :
                MenuSwCase();
        }
    }

    public static void Credit() { // Credit
        System.out.println("--- Credit ---");
        System.out.println("Prakit : Leader");
        System.out.println("Sapondanai : member");
        System.out.println("Pattarapol : member");
    }

    public static void CreatePrakitko() { // สร้าง Prakitko
        Scanner stringInput = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Scanner choose = new Scanner(System.in);
        System.out.println("--- Choose Prakitko ---");
        System.out.println("Dog[press 1]");
        System.out.println("Cat[press 2]");
        System.out.println("Bird[press 3]");
        System.out.println("Fish[press 4]");
        System.out.println("Choose ur number : " + stringInput);
        int number = choose.nextInt();
        
//              if (number == 1) {
//            System.out.println("Prakitko name: ");
//            String name = input.nextLine();
//            System.out.println(userEntryDogName(name));
//            chooseMap();
//        }
//        if (number == 2) {
//            String name = input.nextLine();
//            System.out.println(userEntryCatName(name));
//            chooseMap();
//        }
//        if (number == 3) {
//            String name = input.nextLine();
//            System.out.println(userEntryBirdName(name));
//            chooseMap();
//        }
//        if (number == 4) {
//            String name = input.nextLine();
//            System.out.println(userEntryFishName(name));
//            chooseMap();
//        }
    

        if (number == 1) {
            System.out.println("Prakitko name: ");
            String name = input.nextLine();
            System.out.println(userEntryDogName(name));
            chooseMap();
        }
        if (number == 2) {
            String name = input.nextLine();
            System.out.println(userEntryCatName(name));
            chooseMap();
        }
        if (number == 3) {
            String name = input.nextLine();
            System.out.println(userEntryBirdName(name));
            chooseMap();
        }
        if (number == 4) {
            String name = input.nextLine();
            System.out.println(userEntryFishName(name));
            chooseMap();
        }

    }

    public static Character userEntryDogName(String name) { //กรอกชื่อ Prakitko
        prakitko = new Dog(name);
        createPrakitko(prakitko);
        return prakitko;
    }

    public static Character userEntryCatName(String name) { //กรอกชื่อ Prakitko
        prakitko = new Cat(name);
        createPrakitko(prakitko);
        return prakitko;
    }

    public static Character userEntryBirdName(String name) { //กรอกชื่อ Prakitko
        prakitko = new Cat(name);
        createPrakitko(prakitko);
        return prakitko;
    }

    public static Character userEntryFishName(String name) { //กรอกชื่อ Prakitko
        prakitko = new Cat(name);
        createPrakitko(prakitko);
        return prakitko;
    }

    public static void showProfile() {

    }

    public static void chooseMap() { // เลือก Map
        System.out.println("Choose Map");
        System.out.println("Map1 [press 1]");
        System.out.println("Map2 [press 2]");
        System.out.println("Map3 [press 3]");
        System.out.println("Back to Choose Prakitko[press 4]");
        System.out.println("Back to menu [press 5]");
        Scanner choose = new Scanner(System.in);
        int number = choose.nextInt();

        if (number == 1) {
            System.out.println("--- Map1 : Forest ---");
            UserChooseMap1();
        }
        if (number == 4) {
            CreatePrakitko();
        }
        if (number == 5) {
            MenuSwCase();
        }

    }

    public static void UserChooseMap1() { // เลือก Map1
        Map1 forest = new Map1();
        Monster slime = new Slime();
        forest.addMonsterInMap(slime);
        forest.arrayCheck();

    }

    public static void fight() {

    }

}
