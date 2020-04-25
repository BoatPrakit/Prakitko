package Field;

import monstermodel.*;
import prototype.Monster;

public class Map1 extends Map{
    private static Monster[] monster;  
    private static Slime Slime;
    private static Wolf Wolf;    
    private static int noOfMonsterInThisMap;
    
    public Map1(){
        super(monsterInThisMap());
    }
    
    private static Monster[] monsterInThisMap(){
        addMonsterInMap(Slime);
        addMonsterInMap(Wolf);
        return monster;
    }
    
    public static void addMonsterInMap (Monster newMonster){
        Monster[] newMonsterCollection = new Monster[noOfMonsterInThisMap+1];
        if (noOfMonsterInThisMap>0) {
          System.arraycopy(monster, 0, newMonsterCollection, 0, noOfMonsterInThisMap);  
        }        
        newMonsterCollection[noOfMonsterInThisMap] = newMonster;
        monster = newMonsterCollection;
        monster[0] = Slime;
        noOfMonsterInThisMap++;        
    }
    @Override
    public void arrayCheck(){
        for (int i = 0; i < monster.length; i++) {
            System.out.println(monster[i]);
        }
    }
    
    public void listNamearray(int x){
        monster[x] = Slime;
        System.out.println(monster[x].getClass());
    }
}
