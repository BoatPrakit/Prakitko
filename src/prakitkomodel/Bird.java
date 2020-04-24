package prakitkomodel;

import prototype.Prakitko;

public class Bird extends Prakitko{
    private static final String type = "Bird";
    private static final int baseHp = 120;
    private static final int baseAtk = 30;
    private static final int baseSpd = 20;
    private static final int baseSta = 100;
    private static final int hpPerlvl = 10;
    private static final int atkPerlvl = 3;
    private static final int spdPerlvl = 2;
    private static final int staPerlvl = 8;
    public Bird(String name){
        super(name,baseHp,baseAtk,baseSpd,baseSta,hpPerlvl,atkPerlvl,spdPerlvl,staPerlvl,type);
    }
    @Override
    public String toString(){
        return "Name : "+ super.getName() +"Hp : " + super.getMaxHp() + " Stamina : "+super.getMaxStamina() + " Atk : "+super.getAtk() + " AtkSpeed : "+super.getAtkSpeed();
    }
}
