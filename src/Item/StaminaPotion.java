
package Item;

public class StaminaPotion extends Potions{
    
    private static int regenStamina = 70;
    private static int Id = 005;
    private static String name = "StaminaPotion";


    public StaminaPotion() {
        super(regenStamina, Id, name);
    }

    @Override
    public String toString() {
        return "StaminaPotion{" + "RegenStamina : " + super.getRegen() +'}';
    }
    
    
}
