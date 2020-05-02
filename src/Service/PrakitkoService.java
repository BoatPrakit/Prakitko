package Service;

import Model.Prakitko;
import Type.CHARACTERTYPE;

/**
 *
 * @author BoatPrakit
 */
public class PrakitkoService {
    public static Prakitko createDog(String name){
        Prakitko dog = new Prakitko(name);
        //base stat
        dog.setMaxHp(120);
        dog.setAtk(30);
        dog.setAtkSpeed(20);
        dog.setMaxStamina(100);
        //stat per lvl
        dog.setHpPerLvl(10);
        dog.setAtkPerLvl(3);
        dog.setAtkSpeedPerLvl(2);
        dog.setStaminaPerLvl(8);
        //full hp
        dog.setFullHp();
        //set Type
        dog.setType(CHARACTERTYPE.DOG);
        return dog;
    }
    public static Prakitko createCat(String name){
        Prakitko cat = new Prakitko(name);
        //base stat
        cat.setMaxHp(100);
        cat.setAtk(30);
        cat.setAtkSpeed(24);
        cat.setMaxStamina(100);
        //stat per lvl
        cat.setHpPerLvl(8);
        cat.setAtkPerLvl(3);
        cat.setAtkSpeedPerLvl(3);
        cat.setStaminaPerLvl(10);
        //full hp
        cat.setFullHp();
        //set Type
        cat.setType(CHARACTERTYPE.CAT);
        return cat;
    }
    public static Prakitko createBird(String name){
        Prakitko bird = new Prakitko(name);
        //base stat
        bird.setMaxHp(90);
        bird.setAtk(35);
        bird.setAtkSpeed(22);
        bird.setMaxStamina(100);
        //stat per lvl
        bird.setHpPerLvl(5);
        bird.setAtkPerLvl(4);
        bird.setAtkSpeedPerLvl(2);
        bird.setStaminaPerLvl(8);
        //full hp
        bird.setFullHp();
        //set Type
        bird.setType(CHARACTERTYPE.BIRD);
        return bird;
    }
    public static Prakitko createFish(String name){
        Prakitko fish = new Prakitko(name);
        //base stat
        fish.setMaxHp(90);
        fish.setAtk(32);
        fish.setAtkSpeed(21);
        fish.setMaxStamina(150);
        //stat per lvl
        fish.setHpPerLvl(5);
        fish.setAtkPerLvl(3);
        fish.setAtkSpeedPerLvl(2);
        fish.setStaminaPerLvl(20);
        //full hp
        fish.setFullHp();
        //set Type
        fish.setType(CHARACTERTYPE.FISH);
        return fish;
    }
}
