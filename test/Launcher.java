import Field.Character;
import java.util.ArrayList;
import prakitkomodel.Cat;
import prakitkomodel.Dog;
import prototype.Prakitko;

public class Launcher {
    public static void main(String[] args) {
       Prakitko c = new Dog("Test");
       c.receiveExp(4000);
        System.out.println(c.getLevel());
        System.out.println(c.getCurrentExp());
        System.out.println(c.getCurrentMaxExp());

        
}
}
