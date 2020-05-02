package monstermodel;

import prototype.Monster;

public class Zombie extends Monster{
     private static final String name = "Zombie";
    private static final int baseHp = 100;
    private static final int baseAtk = 25;
    private static final int baseSpd = 23;
    private static final int baseSta = 80;
    private static final int hpPerlvl = 15;
    private static final int atkPerlvl = 8;
    private static final int spdPerlvl = 2;
    private static final int staPerlvl = 10;
    private static final int lvlRange = 5;
    private static final int baseExpGive = 50;
    public Zombie(){
        super(name,baseHp,baseAtk,baseSpd,baseSta,hpPerlvl,atkPerlvl,spdPerlvl,staPerlvl,lvlRange,baseExpGive);

    }
}
