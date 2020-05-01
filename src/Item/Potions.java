package Item;

import Field.Item;

public abstract class Potions extends Item{
    
    public Potions(int regen,int Id, String name) {
        super(regen, Id, name);
    }
    public Potions(int id,String name){
        super(id,name);
    }

}
