package prakitkomodel;

import prototype.Prakitko;

public class Fish extends Prakitko{
    private static final String type = "Fish";
    private static final int baseHp = 90;
    private static final int baseAtk = 32;
    private static final int baseSpd = 21;
    private static final int baseSta = 150;
    private static final int hpPerlvl = 5;
    private static final int atkPerlvl = 3;
    private static final int spdPerlvl = 2;
    private static final int staPerlvl = 20;
    public Fish(String name){
        super(name,baseHp,baseAtk,baseSpd,baseSta,hpPerlvl,atkPerlvl,spdPerlvl,staPerlvl,type);
    }
    @Override
    public String toString(){
        return "Name : "+ super.getName() +" Hp : " + super.getMaxHp() + " Stamina : "+super.getMaxStamina() + " Atk : "+super.getAtk() + " AtkSpeed : "+super.getAtkSpeed();
    }
}
