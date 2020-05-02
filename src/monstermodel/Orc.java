
package monstermodel;

import prototype.Monster;

public class Orc extends Monster{
    private static final String name = "Orc";
    private static final int baseHp = 60;
    private static final int baseAtk = 20;
    private static final int baseSpd = 25;
    private static final int baseSta = 80;
    private static final int hpPerlvl = 3;
    private static final int atkPerlvl = 3;
    private static final int spdPerlvl = 2;
    private static final int staPerlvl = 5;
    private static final int lvlRange = 5;
    private static final int baseExpGive = 50;
    public Orc(){
        super(name,baseHp,baseAtk,baseSpd,baseSta,hpPerlvl,atkPerlvl,spdPerlvl,staPerlvl,lvlRange,baseExpGive);

    }
}
