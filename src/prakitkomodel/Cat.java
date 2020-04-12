package prakitkomodel;

import prototype.Prakitko;

/**
 *
 * @author User
 */
public class Cat extends Prakitko{
    public Cat(String name){
        super(name,100,30,24,100,8,3,10,3);
    }
    @Override
    public String toString(){
        return "Hp : " + super.getMaxHp() + " Stamina : "+super.getMaxStamina() + " Atk : "+super.getAtk() + " AtkSpeed : "+super.getAtkSpeed();
    }
   
}
