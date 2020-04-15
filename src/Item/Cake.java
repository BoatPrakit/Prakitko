
package Item;


public class Cake extends Food{
    
    private static int regenHp = 10;
    
    public Cake() {
        super(regenHp);
    }

    @Override
    public String toString() {
        return "Cake{" + "RegenHp : " + super.getRegen() + '}';
    }

}
