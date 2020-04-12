package prakitkomodel;

import prototype.Prakitko;

/**
 *
 * @author User
 */
public class Dog extends Prakitko{
    public Dog(String name){
        super(name,120,30,20,100,10,3,8,2);  
    }
   @Override
    public String toString(){
        return "Hp : " + super.getMaxHp() + " Stamina : "+super.getMaxStamina() + " Atk : "+super.getAtk() + " AtkSpeed : "+super.getAtkSpeed();
    }
}
