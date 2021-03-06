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
        this.expHolding = 0;
        this.itemHolding.clear();
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

    public int loseExp(int currentExp) {
        int loseExp = -(currentExp*5/100);
        prakitko.receiveExp(loseExp(prakitko.getCurrentExp()));
        return loseExp;
    }
    
    private int expGiveTo(Character prakitko) {
//        prakitko = this.prakitko;
        
        return 0;
    }
    public int isBattleEnd(){
        if (isMonsterDie()) {
            return 1;
        }else if (isPrakitkoDie()) {
           return 2;
        }
        return -1;
        
    }
    public void battleReward(){
        this.expHolding += monster.dropExp();
        this.itemHolding.add(monster.itemDrop());
        this.prakitko.receiveExp(expHolding);
        System.out.println(prakitko.getName()+" receive : "+expHolding+" exp");
        for (Item currentItem : itemHolding) {
            this.prakitko.receiveItem(currentItem);
            System.out.println(prakitko.getName()+" receive : "+currentItem);
        }
        this.expHolding = 0;
        this.itemHolding.clear();
        
    }
    
    public void whoHere() {
        System.out.println(prakitko);
        System.out.println(monster);
    }
}
