package Model;

import Model.Item;
import java.util.ArrayList;
import java.util.Random;
import static Service.ItemService.*;

public class Monster extends Character{
    
    private ArrayList<Item> item = new ArrayList();
    private Random randomGenerator = new Random();
    
    public Monster(){
        super();
        this.item = item;
    }
    
    public Item itemDrop(){
        int index = randomGenerator.nextInt(item.size());
        return item.get(index);
    }
    
    public void addItem(){
        item.add(createBurger());
        item.add(createCake());
        item.add(createHealingPotion());
        item.add(createStaminaPotion());
        item.add(createTaco());
    }
}
