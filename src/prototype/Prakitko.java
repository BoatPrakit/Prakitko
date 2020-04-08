
package prototype;
import Field.Character;
/**
 *
 * @author User
 */
public abstract class Prakitko extends Character{
      private double hpPerLvl;
    private double atkPerLvl;
    private double staminaPerLvl;
    private double speedPerLvl;
    
    protected Prakitko(String name) {
        super(name);
    }
}
