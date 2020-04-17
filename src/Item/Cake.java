
package Item;


public class Cake extends Food{
    
    private static int regenHp = 10;
    private static String Id = "Id :Item002";
    
    public Cake() {
        super(regenHp, Id);
    }


    @Override
    public String toString() {
        return "Cake{" + "RegenHp : " + super.getRegen() + '}';
    }

}
