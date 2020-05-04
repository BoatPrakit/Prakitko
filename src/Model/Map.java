package Model;

import java.util.ArrayList;
import java.util.Random;
import Field.Field;

/**
 *
 * @author Sapondanai
 */

public class Map {

    private static ArrayList<Monster> listOfMonster = new ArrayList<Monster>();
    private Random randomGenerator = new Random();

    public Map(){}
    
    public void clearMonster(){
        listOfMonster.clear();
    }

    public void addMonsterInMap(Monster newMonster) {
        listOfMonster.add(newMonster);
    }

    public void removeMonster(Monster monster) {
        listOfMonster.remove(monster);
    }

    public void arrayCheck() {
        System.out.println("Start printing");
        for (Monster currentMonster : listOfMonster) {
            System.out.println(currentMonster);
        }
    }

    public void reRandomLevelMonster() {
        for (Monster currentMonster : listOfMonster) {
            currentMonster.randomLvl(currentMonster.getLevelRange());
            currentMonster.calculateStatMonster();
        }
    }
    
    public Monster getRandomMonster() {
        int index = randomGenerator.nextInt(listOfMonster.size());
        return listOfMonster.get(index);
    }

;
}
