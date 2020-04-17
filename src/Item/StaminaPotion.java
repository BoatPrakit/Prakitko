
package Item;

public class StaminaPotion extends Potions{
    private static int regenStamina = 70;
    
    public StaminaPotion(){
        super(regenStamina);
    }

    @Override
    public String toString() {
        return "StaminaPotion{" + "RegenStamina : " + super.getRegen() +'}';
    }
    
    
}
