
package Item;

public class Taco extends Food{
    
    private static int regenHp = 20;
    private static int Id = 001;
        private static String name = "Taco";


    public Taco() {
        super(regenHp, Id,name);
    }
    
    @Override
    public String toString() {
        return "Taco{" +"RegenHp : " + super.getRegen() +'}';
    }

}
