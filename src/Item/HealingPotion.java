
package Item;

public class HealingPotion extends Potions{
    private static int regenHp = 50;
    private static int Id = 4;
    private static String name = "HealingPotion";

    public HealingPotion() {
        super(regenHp, Id, name);
    }

    @Override
    public String toString() {
        return "HealingPotion{" + "RegenHp : " + super.getRegen() +'}';
    }
    
    
}
