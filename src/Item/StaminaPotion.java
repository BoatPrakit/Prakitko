
package Item;

public class StaminaPotion extends Potions{
    
    private static int regenStamina = 70;
    private static String Id = "005";

    public StaminaPotion() {
        super(regenStamina, Id);
    }

    @Override
    public String toString() {
        return "StaminaPotion{" + "RegenStamina : " + super.getRegen() +'}';
    }
    
    
}
