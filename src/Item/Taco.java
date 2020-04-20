
package Item;

public class Taco extends Food{
    
    private static int regenHp = 20;
    private static int Id = 001;

    public Taco() {
        super(regenHp, Id);
    }
    
    @Override
    public String toString() {
        return "Taco{" +"RegenHp : " + super.getRegen() +'}';
    }

}
