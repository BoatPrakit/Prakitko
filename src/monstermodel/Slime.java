package monstermodel;

import Field.Item;
import Item.Burger;
import Item.Taco;
import java.util.ArrayList;
import prototype.Monster;

public class Slime extends Monster{
    private static final String name = "Slime";
    private static final int baseHp = 50;
    private static final int baseAtk = 15;
    private static final int baseSpd = 15;
    private static final int baseSta = 60;
    private static final int hpPerlvl = 3;
    private static final int atkPerlvl = 2;
    private static final int spdPerlvl = 1;
    private static final int staPerlvl = 5;
    private static final int lvlRange = 5;
    private static final int baseExpGive = 50;
    private static final ArrayList<Item> item = new ArrayList();
    public Slime(){       
        super(name,baseHp,baseAtk,baseSpd,baseSta,hpPerlvl,atkPerlvl,spdPerlvl,staPerlvl,lvlRange,baseExpGive,itemInThisMonster());
    }
    
    private static ArrayList<Item> itemInThisMonster(){
        Burger burger = new Burger();
        Taco taco = new Taco();
        item.add(burger);
        item.add(taco);
        return item;
    }
}
