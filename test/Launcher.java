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
import static databaseManagement.DatabaseSystem.*;
import java.util.Scanner;
import monstermodel.Slime;
import prototype.Monster;
import status.STATUS;
public class Launcher {
    private static Prakitko prakitko;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu(input);
        input.close();

    }

    public static void Menu(Scanner scanner){ // Menu เเบบ ปกติ
        System.out.println("--- Game Name ---");
        System.out.println("Play Game[press 1]");
        System.out.println("Credit[press 0]");
        System.out.println("Choose ur number : ");
        int number = scanner.nextInt();
        if(number == 1){
            Apply(scanner);
        }if(number == 0){
            System.out.println("Prakit : Leader");
            System.out.println("Sapondanai : member");
            System.out.println("Pattarapol : member");
        }
    }
   
    
    public static void Apply(Scanner scanner) {
        System.out.println("--- Login & Register ---");
        System.out.println("Register [press 1]");
        System.out.println("Login [press 2]");
        System.out.println("please choose ur number : ");
        int number = scanner.nextInt();

        if (number == 1) {
            register();
            CreatePrakitko(scanner);
//          showPrakitkoForSelect();
        }
        if (number == 2) {
            login();
            showPrakitkoForSelect();
            prakitko = choosePrakitko();
        }
        
        
    }

    public static void CreatePrakitko(Scanner scanner) { // สร้าง Prakitko

        System.out.println("--- Choose Prakitko ---");
        System.out.println("Dog[press 1]");
        System.out.println("Cat[press 2]");
        System.out.println("Bird[press 3]");
        System.out.println("Fish[press 4]");
        System.out.println("Choose ur number : ");
        int number = scanner.nextInt();
//            String name = scanner.nextLine();
        
        
    }
    public static Character userEntryDogName(String name){
        Prakitko dog = new Dog(name);
        return dog;
    }
    
    public static Character userEntryCatName(String name){
        Prakitko cat = new Cat(name);
        return cat;
    }
    
    public static Character userEntryBirdName(String name){
        Prakitko bird = new Cat(name);
        return bird;
    }
    
    public static Character userEntryFishName(String name){
        Prakitko fish = new Cat(name);
        return fish;
    }
    
    public static void chooseMap(){
        System.out.println("Choose Map");
        System.out.println("Map1 [press 1]");
        System.out.println("Map2 [press 2]");
        System.out.println("Map3 [press 3]");
        System.out.println("Back to Choose Prakitko[press 4]");
        System.out.println("Back to menu [press 5]");
        Scanner choose = new Scanner(System.in);
        int number = choose.nextInt();
        
        
        if(number == 1){
            System.out.println("--- Map1 : Forest ---");
            UserChooseMap1();
        }if(number == 4){
            
        }if(number == 5){
            
        }
        if (number == 4) {
//            CreatePrakitko();
        }
  
    }
    
    public static void UserChooseMap1(){
        Map1 forest = new Map1();
        Monster slime = new Slime();
        forest.addMonster(slime);
        forest.addMonsterInMap(slime);
        forest.arrayCheck();
        
    }
    
}
