package prototype;

import Field.Item;
import Field.Character;

public abstract class Monster extends Character{
    
    private int giveExp;
    private Item item[];
    private static int lvl;
    private int baseExpGive;
    
    protected Monster(String name,int maxHp,int atk,int atkSpeed,int maxStamina,int hpPerLvl,int atkPerLvl,int staminaPerLvl,int atkSpeedPerLvl,int lvlRange,int baseExpGive){
        super(name,randomLvl(lvlRange),calculateMaxHP(maxHp,hpPerLvl),calculateAtk(atk,atkPerLvl),calculateAtkSpeed(atkSpeed,atkSpeedPerLvl),calculateMaxStamina(maxStamina,staminaPerLvl));
        this.baseExpGive = baseExpGive;
    }
   
    private static int randomLvl(int lvlRange){
        lvl = (int)Math.round(Math.random()*lvlRange);
        return lvl;
    }
    
    private static int calculateMaxHP(int maxHp,int hpPerLvl){
        int result = maxHp+(hpPerLvl*lvl);
        return result;
    }
    private static int calculateAtk(int atk,int atkPerLvl){
        int result = atk+(atkPerLvl*lvl);
        return result;
    }
    private static int calculateAtkSpeed(int atkSpeed,int atkSpeedPerLvl){
        int result = atkSpeed+(atkSpeedPerLvl*lvl);
        return result;
    }
    private static int calculateMaxStamina(int maxStamina,int staminaPerLvl){
        int result = maxStamina+(staminaPerLvl*lvl);
        return result;
    }
    
    private int dropExp(){
        int result = (int)(baseExpGive+((Math.random()+1)*lvl));
        return result;
    }
    
    private Item itemDrop(){
        return item[0];
    }
}
