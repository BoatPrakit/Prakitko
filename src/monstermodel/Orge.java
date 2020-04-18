package monstermodel;

import prototype.Monster;

public class Orge extends Monster{
     private static final String name = "Orge";
    private static final int baseHp = 80;
    private static final int baseAtk = 23;
    private static final int baseSpd = 18;
    private static final int baseSta = 80;
    private static final int hpPerlvl = 3;
    private static final int atkPerlvl = 3;
    private static final int spdPerlvl = 2;
    private static final int staPerlvl = 5;
    private static final int lvlRange = 5;
    private static final int baseExpGive = 50;
    public Orge(){
        super(name,baseHp,baseAtk,baseSpd,baseSta,hpPerlvl,atkPerlvl,spdPerlvl,staPerlvl,lvlRange,baseExpGive);

    }
}
