
package monstermodel;

import prototype.Monster;

public class Wolf extends Monster{
    private static final String name = "Slime";
    private static final int baseHp = 40;
    private static final int baseAtk = 20;
    private static final int baseSpd = 21;
    private static final int baseSta = 60;
    private static final int hpPerlvl = 3;
    private static final int atkPerlvl = 3;
    private static final int spdPerlvl = 2;
    private static final int staPerlvl = 5;
    private static final int lvlRange = 5;
    private static final int baseExpGive = 50;
    public Wolf(){
        super(name,baseHp,baseAtk,baseSpd,baseSta,hpPerlvl,atkPerlvl,spdPerlvl,staPerlvl,lvlRange,baseExpGive);

    }
}
