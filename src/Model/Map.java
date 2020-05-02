package Model;

import java.util.ArrayList;
import java.util.Random;
import Model.Monster;
import Model.Prakitko;
import Field.Field;
import Field.Field;
import Field.Field;

public class Map {

    private static ArrayList<Monster> listOfMonster = new ArrayList<>();
    private Random randomGenerator = new Random();

    public Map(){}

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

    public Field fight(Prakitko User) {
        reRandomLevelMonster();
        Field newField = new Field(User, getRandomMonster());
        return newField;

    }

;
}
