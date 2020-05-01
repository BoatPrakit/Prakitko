
package Item;

public class StaminaPotion extends Potions{
    
    private static int regenStamina = 70;
    private static int Id = 5;
    private static String name = "StaminaPotion";


    public StaminaPotion() {
        super(Id, name);
        super.setRegenStamina(regenStamina);
    }

    @Override
    public String toString() {
        return "StaminaPotion{" + "RegenStamina : " + super.getRegenStamina() +'}';
    }
    
    
}
