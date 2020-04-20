package Field;

import monstermodel.*;
import prototype.Monster;

public class Map1 extends Map{
    private static Monster[] monster;
    private static Slime Slime;
    private static Wolf Wolf;
    private static int noOfMonsterInThisMap;
    
    public Map1(){
        super(monster);
    }
    
    private static void monsterInThisMap(){
        addMonsterInMap(Slime);
        addMonsterInMap(Wolf);
    }
    
    public static void addMonsterInMap (Monster monster){
        Monster[] newMonsterCollection = new Monster[noOfMonsterInThisMap+1];
        System.arraycopy(monster, 0, newMonsterCollection, 0, noOfMonsterInThisMap);
        newMonsterCollection[noOfMonsterInThisMap] = monster;
        noOfMonsterInThisMap++;        
    }
}
