/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monstermodel;

import Model.Monster;

/**
 *
 * @author BoatN
 */
public class Skeleton extends Monster{
    private static final String name = "Skeleton";
    private static final int baseHp = 90;
    private static final int baseAtk = 35;
    private static final int baseSpd = 26;
    private static final int baseSta = 100;
    private static final int hpPerlvl = 10;
    private static final int atkPerlvl = 8;
    private static final int spdPerlvl = 2;
    private static final int staPerlvl = 10;
    private static final int lvlRange = 5;
    private static final int baseExpGive = 50;
    
    public Skeleton(){
        super(name,baseHp,baseAtk,baseSpd,baseSta,hpPerlvl,atkPerlvl,spdPerlvl,staPerlvl,lvlRange,baseExpGive);

    }
}
