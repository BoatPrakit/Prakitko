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
        MenuSwCase(input);
        input.close();
        
        
          

    }

//    public static void Menu(Scanner scanner){ // Menu เเบบ ปกติ
//        System.out.println("--- Game Name ---");
//        System.out.println("Play Game[press 1]");
//        System.out.println("Credit[press 0]");
//        System.out.println("Choose ur number : ");
//        int number = scanner.nextInt();
//        if(number == 1){
//            Apply(scanner);
//        }if(number == 0){
//            System.out.println("Prakit : Leader");
//            System.out.println("Sapondanai : member");
//            System.out.println("Pattarapol : member");
//        }
//    }
    
       public static void MenuSwCase(Scanner scanner){
         System.out.println("--- Game Name ---");
        System.out.println("Play Game[press 1]");
        System.out.println("Credit[press 0]");
        Scanner num = new Scanner(System.in);
        System.out.println("Choose ur number");
        int choose = num.nextInt();
        System.out.println("Choose : " + choose);
        switch (choose) {
            case 1:
                Apply(scanner);
                break;
            case 2:

                Credit();
                System.out.println("Back To Menu [press 0]");
                

        }
    }
       
       public static void Credit(){
           System.out.println("Boat : leader");
           System.out.println("Beng : member");
           System.out.println("Diz : member");
       }
   
    
    public static void Apply(Scanner scanner) {
        System.out.println("--- Login & Register ---");
        System.out.println("Register [press 1]");
        System.out.println("Login [press 2]");
        System.out.println("please choose ur number : ");
        int number = scanner.nextInt();

        if (number == 1) {
            register();
            System.out.println("--- Your Prakitko ---");
            showPrakitkoForSelect();
            loading(scanner);
            
        }
        if (number == 2) {
            login();
            showPrakitkoForSelect();
            prakitko = choosePrakitko();
        }
    }
    
    public static void loading(Scanner scanner){
        System.out.println("--- Do u want create ur Prakitko?? ---");
        System.out.println("Create Prakitko[press 1]");
        System.out.println("Back to menu[press 2]");
        int input = scanner.nextInt();
        if(input == 1){
            CreatePrakitko(scanner);
        }if(input == 2){
            MenuSwCase(scanner);
        }
    }

    public static void CreatePrakitko(Scanner scanner) { // สร้าง Prakitko
        Scanner input = new Scanner(System.in);
        System.out.println("--- Choose Prakitko ---");
        System.out.println("Dog[press 1]");
        System.out.println("Cat[press 2]");
        System.out.println("Bird[press 3]");
        System.out.println("Fish[press 4]");
        
        int number = scanner.nextInt();
        System.out.println("Choose ur number : " + number);
        
        if(number == 1){
            System.out.println("Prakitko name : ");
            String name = input.nextLine();
            System.out.println(userEntryDogName(name));
            chooseMap(scanner);
            
        }if(number == 2){
            System.out.println("Prakitko name : ");
            String name = input.nextLine();
            System.out.println(userEntryCatName(name));
            chooseMap(scanner);
            
        }if(number == 3){
            System.out.println("Prakitko name : ");
            String name = input.nextLine();
            System.out.println(userEntryBirdName(name));
            chooseMap(scanner);
            
        }if(number == 4){
            System.out.println("Prakitko name : ");
            String name = input.nextLine();
            System.out.println(userEntryFishName(name));
            chooseMap(scanner);
        }

    }
        
    public static Character userEntryDogName(String name){
        prakitko = new Dog(name);
        return prakitko;
    }
    
    public static Character userEntryCatName(String name){
        prakitko = new Cat(name);
        return prakitko;
    }
    
    public static Character userEntryBirdName(String name){
        prakitko = new Cat(name);
        return prakitko;
    }
    
    public static Character userEntryFishName(String name){
        prakitko = new Cat(name);
        return prakitko;
    }
    
    public static void chooseMap(Scanner scanner){
        System.out.println("Choose Map");
        System.out.println("Map1 [press 1]");
        System.out.println("Map2 [press 2]");
        System.out.println("Map3 [press 3]");
        System.out.println("Back to Choose Prakitko[press 4]");
        System.out.println("Back to menu [press 5]");
        
        int number = scanner.nextInt();
        
        
        if(number == 1){
            System.out.println("--- Map1 : Forest ---");
            UserChooseMap1(scanner);
        }if(number == 4){
            
        }if(number == 5){
            
        }
        if (number == 4) {
//            CreatePrakitko();
        }
  
    }
    
    public static void UserChooseMap1(Scanner scanner){
        Map1 forest = new Map1();
        Field x = fightMode(forest);
        
        x.whoHere();
        inBattle(scanner);
    }
    
    public static Field fightMode(Map m){
        Field x = m.fight(prakitko);
        return x ;
    }
    
    public static void inBattle(Scanner scanner){
        System.out.println("----------------");
        System.out.println("Crash[press 1]");
        System.out.println("Use item[press 2]");
        System.out.println("Run!![press 3]");
        int num = scanner.nextInt();
        if(num == 1){
            
        }if(num == 2){
            useItem();
            
        }if(num == 3){
            
        }
    }
    
    public static Item useTaco(){
        item = new Taco();
        return item;
    }
    
    public static Item useCake(){
        item = new Cake();
        return item;
    }
    
    public static Item useBurger(){
        item = new Burger();
        return item;
    }
    
    public static Item useHelingPotion(){
        item = new HealingPotion();
        return item;
    }
    
    public static Item useStaminaPotion(){
        item = new StaminaPotion();
        return item;
    }
    
    public static void useItem(){
        System.out.println("--- Inventory ---");
       
        
    }
    
    
            
}
