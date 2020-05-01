package Field;

import java.util.ArrayList;
import java.util.Random;
import prototype.Monster;
import prototype.Prakitko;
import Field.Field;

public abstract class Map {
    
    private static ArrayList<Monster> listOfMonster = new ArrayList<>();
    private Random randomGenerator = new Random();
    
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
        
    public  void reRandomLevelMonster(){
        for (Monster currentMonster : listOfMonster){
            currentMonster.randomLvl(currentMonster.getLevelRange());
            currentMonster.calculateStatMonster();
        }
    }
        
    public Field fight(Prakitko User){
        reRandomLevelMonster();
        Field newField = new Field(User,getRandomMonster());
        return newField;
        
    }
    
    public Monster getRandomMonster(){
        int index = randomGenerator.nextInt(listOfMonster.size());
        return listOfMonster.get(index);
};
}
