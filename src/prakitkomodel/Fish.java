package prakitkomodel;

import prototype.Prakitko;

/**
 *
 * @author User
 */
public class Fish extends Prakitko{
    public Fish(String name){
        super(name,90,32,21,150,5,3,20,2);
    }
    @Override
    public String toString(){
        return "Hp : " + super.getMaxHp() + " Stamina : "+super.getMaxStamina() + " Atk : "+super.getAtk() + " AtkSpeed : "+super.getAtkSpeed();
    }
}
