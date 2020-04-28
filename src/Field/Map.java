package Field;

import java.util.ArrayList;
import prototype.Monster;

public abstract class Map {
    
    private static ArrayList<Monster> listOfMonster = new ArrayList<>();
    
    public Map(){
    
    }
    
    public Map(ArrayList<Monster> monsterCollection){
        this.listOfMonster = monsterCollection;
    }
    
    public static void addMonsterInMap (Monster newMonster){
        listOfMonster.add(newMonster);
    }     
    
    public void removeMonster(Monster monster){
        listOfMonster.remove(monster);
    }
    
        public void arrayCheck(){
        System.out.println("Start printing");
        for (Monster currentMonster: listOfMonster){
             System.out.println(currentMonster);
        }
    }
        
    public void reRandomLevelMonster(){
        for (Monster currentMonster : listOfMonster){
            currentMonster.randomLvl(currentMonster.getLevelRange());
            currentMonster.calculateStatMonster();
        }
    }
        
    public void fight(){
    
    }
    
//    public abstract int spawnrate();
}
