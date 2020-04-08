package Item;

import Field.Item;

/**
 *
 * @author User
 */
public class Food extends Item{
    
    private final int REGENSTAMINA = 50;
    private Food[] Food;
    
    public Food(String name) {
        super(name);
    }
    
    public int regenStamina(){
        return 0;
    }
    
    public int regenHP(){
        return 0;
    }

    @Override
    public String toString() {
        return "Food{" + "REGENSTAMINA=" + REGENSTAMINA + ", Food=" + Food + '}';
    }
    
    
    
}
