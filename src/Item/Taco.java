
package Item;


public class Taco extends Food{
    
    private static int regenHp = 20;
    
    public Taco() {
        super(regenHp);
    }

    @Override
    public String toString() {
        return "Taco{" +"RegenHp : " + super.getRegen() + '}';
    }

}
