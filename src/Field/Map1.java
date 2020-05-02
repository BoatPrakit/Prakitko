package Field;

import java.util.ArrayList;
import java.util.Arrays;
import monstermodel.*;
import Model.Monster;

public class Map1 extends Map{
    private static Monster[] monster;  
    private static ArrayList<Monster> listOfMonster = new ArrayList<>();
    private static Slime slime;
    private static Wolf wolf;    
    
    public Map1(){
        super(monsterInThisMap());
    }
    
    private static ArrayList<Monster> monsterInThisMap(){
        slime = new Slime();
        addMonsterInMap(slime);
        wolf = new Wolf();
        addMonsterInMap(wolf);
        return listOfMonster;
    }
    public static void addMonsterInMap (Monster newMonster){
        listOfMonster.add(newMonster);
    }     
}
