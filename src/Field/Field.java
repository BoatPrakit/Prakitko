package Field;

import java.util.ArrayList;
import prototype.Monster;
import prototype.Prakitko;
import status.STATUS;

/**
 *
 * @author User
 */
public class Field {

    private Prakitko prakitko;
    private Monster monster;
    private int expHolding;
    private static ArrayList<Item> itemHolding  = new ArrayList<>();
    
    public Field(Prakitko prakitko, Monster monster) {
        this.prakitko = prakitko;
        this.monster = monster;
    }
    
    public void attack() {
        if (!isMonsterDie() && !isPrakitkoDie()) {
            if (prakitko.getAtkSpeed() >= monster.getAtkSpeed()) {
                monster.recieveDamage(prakitko.getAtk());
                System.out.println(prakitko.getName() + " Dealt " + monster.getName() + " " + prakitko.getAtk() + " Damage");
                if (!monster.isDead()) {
                    prakitko.recieveDamage(monster.getAtk());
                    System.out.println(monster.getName() + " Dealt " + prakitko.getName() + " " + monster.getAtk() + " Damage");
                }
                prakitko.isDead();
                monster.isDead();
                whoHere();
                isBattleEnd();
            } else if (prakitko.getAtkSpeed() < monster.getAtkSpeed()) {
                prakitko.recieveDamage(monster.getAtk());
                System.out.println(monster.getName() + " Dealt " + prakitko.getName() + " " + monster.getAtk() + " Damage");
                if (!prakitko.isDead()) {
                    monster.recieveDamage(prakitko.getAtk());
                    System.out.println(prakitko.getName() + " Dealt " + monster.getName() + " " + prakitko.getAtk() + " Damage");
                }
                prakitko.isDead();
                monster.isDead();
                whoHere();
                isBattleEnd();
            }
            
        } else {
            System.out.println("Fight already end");
        }

    }
    
    public boolean isMonsterDie() {
        if (monster == null || prakitko == null) {
            return false;
        }
        if (monster.getStatus() == STATUS.DEAD) {
            return true;
        }
        return false;
    }
    
    public boolean isPrakitkoDie() {
        if (prakitko == null) {
            return false;
        }
        if (prakitko.getStatus() == STATUS.DEAD) {
            return true;
        }
        return false;
    }

    private int loseExp(int currentExp) {
        return currentExp * 5 / 100;
    }
    
    private int expGiveTo(Character prakitko) {
//        prakitko = this.prakitko;
        
        return 0;
    }
    public boolean isBattleEnd(){
        if (isMonsterDie()) {
            this.expHolding += monster.dropExp();
//            this.itemHolding.add(monster.itemDrop());
            battleReward();
            return true;
        }else if (isPrakitkoDie()) {
           prakitko.receiveExp(loseExp(prakitko.getCurrentExp()));
           return true;
        }
        return false;
        
    }
    private void battleReward(){
        this.prakitko.receiveExp(expHolding);
//        for (Item currentItem : itemHolding) {
//            this.prakitko.receiveItem(currentItem);
//        }
        System.out.println(prakitko.getName()+" receive : "+expHolding+" exp");
        
    }
    
    public void whoHere() {
        System.out.println(prakitko);
        System.out.println(monster);
    }
}
