package Model;

import Field.Item;
import Field.Character;
import java.util.ArrayList;
import java.util.Random;

public class Monster extends Character{
    
    private ArrayList<Item> item = new ArrayList();
    private static int lvl;
    private Random randomGenerator = new Random();
    
    public Monster(){
        super();
        this.item = item;
    }
    
    public Item itemDrop(){
        int index = randomGenerator.nextInt(item.size());
        return item.get(index);
    } 
}
