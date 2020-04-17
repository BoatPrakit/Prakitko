
package Item;


public class HealingPotion extends Potions{
    private static int regenHp = 50;
    
    public HealingPotion() {
        super(regenHp);
    }

    @Override
    public String toString() {
        return "HealingPotion{" + "RegenHp : " + super.getRegen() +'}';
    }
    
    
}
