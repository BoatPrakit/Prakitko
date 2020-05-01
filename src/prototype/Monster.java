package prototype;

import Field.Item;
import Field.Character;

public abstract class Monster extends Character{
    
    private int giveExp;
    private Item item[];
    private static int lvl;
    
    protected Monster(String name,int maxHp,int atk,int atkSpeed,int maxStamina,int hpPerLvl,int atkPerLvl,int staminaPerLvl,int atkSpeedPerLvl,int lvlRange,int baseExpGive){
        super(name,lvlRange,maxHp,atk,atkSpeed,maxStamina,hpPerLvl,atkPerLvl,atkSpeedPerLvl,staminaPerLvl,baseExpGive);
    }
    
    private Item itemDrop(){
        return item[0];
    }
    
    private void addItem(Item item){
        
    }
   
    
    
}
