package prakitkomodel;

import prototype.Prakitko;

/**
 *
 * @author User
 */
public class Bird extends Prakitko{
    public Bird(String name){
        //(String name,int maxHp,int atk,int atkSpeed,int maxStamina,int hpPerLvl,int atkPerLvl,int staminaPerLvl,int atkSpeedPerLvl)
        super(name,90,35,22,100,5,4,8,2);
    }
    @Override
    public String toString(){
        return "Hp : " + super.getMaxHp() + " Stamina : "+super.getMaxStamina() + " Atk : "+super.getAtk() + " AtkSpeed : "+super.getAtkSpeed();
    }
}
