package prakitkomodel;

import prototype.Prakitko;

public class Cat extends Prakitko{
    private static final String type = "Cat";
    private static final int baseHp = 100;
    private static final int baseAtk = 30;
    private static final int baseSpd = 24;
    private static final int baseSta = 100;
    private static final int hpPerlvl = 8;
    private static final int atkPerlvl = 3;
    private static final int spdPerlvl = 3;
    private static final int staPerlvl = 10;
    public Cat(String name){
        super(name,baseHp,baseAtk,baseSpd,baseSta,hpPerlvl,atkPerlvl,spdPerlvl,staPerlvl,type);
    }
    @Override
    public String toString(){
        return "Name : "+ super.getName() +"Hp : " + super.getMaxHp() + " Stamina : "+super.getMaxStamina() + " Atk : "+super.getAtk() + " AtkSpeed : "+super.getAtkSpeed();
    }   
}
