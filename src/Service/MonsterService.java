/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Monster;

/**
 *
 * @author Klitb
 */

public class MonsterService {
    
    public static Monster createSlime(){
        Monster monster = new Monster();
        monster.setName("Slime");
        monster.setMaxHp(50);
        monster.setAtk(15);
        monster.setAtkSpeed(15);
        monster.setMaxStamina(60);
        monster.setHpPerLvl(3);
        monster.setAtkPerLvl(2);
        monster.setAtkSpeedPerLvl(1);
        monster.setStaminaPerLvl(5);
        monster.setBaseExpGive(50);
        monster.setLevelRange(5);
        monster.setFullHp();
        return monster;
    }
    public static Monster createWolf(){
        Monster monster = new Monster();
        monster.setName("Wolf");
        monster.setMaxHp(40);
        monster.setAtk(20);
        monster.setAtkSpeed(21);
        monster.setMaxStamina(60);
        monster.setHpPerLvl(3);
        monster.setAtkPerLvl(3);
        monster.setAtkSpeedPerLvl(2);
        monster.setStaminaPerLvl(5);
        monster.setBaseExpGive(50);
        monster.setLevelRange(5);
        monster.setFullHp();
        return monster;
    }
    public static Monster createOrc(){
        Monster monster = new Monster();
        monster.setName("Orc");
        monster.setMaxHp(60);
        monster.setAtk(20);
        monster.setAtkSpeed(25);
        monster.setMaxStamina(80);
        monster.setHpPerLvl(3);
        monster.setAtkPerLvl(3);
        monster.setAtkSpeedPerLvl(2);
        monster.setStaminaPerLvl(5);
        monster.setBaseExpGive(500);
        monster.setLevelRange(15);
        monster.setFullHp();
        return monster;
    }
    public static Monster createOrge(){
        Monster monster = new Monster();
        monster.setName("Orge");
        monster.setMaxHp(80);
        monster.setAtk(23);
        monster.setAtkSpeed(18);
        monster.setMaxStamina(80);
        monster.setHpPerLvl(3);
        monster.setAtkPerLvl(3);
        monster.setAtkSpeedPerLvl(2);
        monster.setStaminaPerLvl(5);
        monster.setBaseExpGive(500);
        monster.setLevelRange(15);
        monster.setFullHp();
        return monster;
    }
    public static Monster createZombie(){
        Monster monster = new Monster();
        monster.setName("Zombie");
        monster.setMaxHp(100);
        monster.setAtk(25);
        monster.setAtkSpeed(23);
        monster.setMaxStamina(80);
        monster.setHpPerLvl(15);
        monster.setAtkPerLvl(5);
        monster.setAtkSpeedPerLvl(2);
        monster.setStaminaPerLvl(10);
        monster.setBaseExpGive(1000);
        monster.setLevelRange(50);
        monster.setFullHp();
        return monster;
    }
    public static Monster createSkeletion(){
        Monster monster = new Monster();
        monster.setName("Skeletion");
        monster.setMaxHp(90);
        monster.setAtk(35);
        monster.setAtkSpeed(26);
        monster.setMaxStamina(100);
        monster.setHpPerLvl(10);
        monster.setAtkPerLvl(8);
        monster.setAtkSpeedPerLvl(2);
        monster.setStaminaPerLvl(10);
        monster.setBaseExpGive(1000);
        monster.setLevelRange(50);
        monster.setFullHp();
        return monster;
    }
}
