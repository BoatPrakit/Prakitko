
package Item;


public class HealingPotion extends Potions{
    private static int regenHp = 50;
    private static String Id = "Id :Item004";

    public HealingPotion() {
        super(regenHp, Id);
    }
    
   

    @Override
    public String toString() {
        return "HealingPotion{" + "RegenHp : " + super.getRegen() +'}';
    }
    
    
}
