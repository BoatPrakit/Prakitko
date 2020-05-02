package prototype;

import Field.Item;
import Field.Character;
import java.util.ArrayList;
import java.util.Random;

public abstract class Monster extends Character{
    
    private ArrayList<Item> item = new ArrayList();
    private static int lvl;
    private Random randomGenerator = new Random();
    
    protected Monster(String name,int maxHp,int atk,int atkSpeed,int maxStamina,int hpPerLvl,int atkPerLvl,int staminaPerLvl,int atkSpeedPerLvl,int lvlRange,int baseExpGive,ArrayList<Item> item){
        super(name,lvlRange,maxHp,atk,atkSpeed,maxStamina,hpPerLvl,atkPerLvl,atkSpeedPerLvl,staminaPerLvl,baseExpGive);
        this.item = item;
    }
    
    public Item itemDrop(){
        int index = randomGenerator.nextInt(item.size());
        return item.get(index);
    } 
}
