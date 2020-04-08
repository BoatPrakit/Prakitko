import Field.Character;
import prakitkomodel.Dog;
public class Launcher {
    public static void main(String[] args) {
       Character c = new Dog("Test");
        System.out.println(c.getStatus());
}
}
