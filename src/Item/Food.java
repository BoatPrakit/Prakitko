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
        return REGENSTAMINA;
    }
    
    @Override
    public int regenHp(){
        return 1;
    }
    

    @Override
    public String toString() {
        return "Food{" + "REGENSTAMINA=" + REGENSTAMINA + ", Food=" + super.getName() + ", REGENHP=" + regenHp()+ '}';
    }
    
    
    
}
