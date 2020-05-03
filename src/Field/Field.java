package Field;

import Model.Character;
import Model.Item;
import java.util.ArrayList;
import Model.Monster;
import Model.Prakitko;
import status.STATUS;

/**
 *
 * @author User
 */
public class Field {

    private Prakitko prakitko;
    private Monster monster;
    private int expHolding;
    private static ArrayList<Item> itemHolding = new ArrayList<>();

    public Field(Prakitko prakitko, Monster monster) {
        this.prakitko = prakitko;
        this.monster = monster;
        this.expHolding = 0;
        this.itemHolding.clear();
    }

    public void attack() {
        if (!isMonsterDie() && !isPrakitkoDie()) {
            if (prakitko.getAtkSpeed() >= monster.getAtkSpeed()) {
                monster.receiveDamage(prakitko.getAtk());
                System.out.println(prakitko.getName() + " Dealt " + monster.getName() + " " + prakitko.getAtk() + " Damage");
                if (!monster.isDead()) {
                    prakitko.receiveDamage(monster.getAtk());
                    System.out.println(monster.getName() + " Dealt " + prakitko.getName() + " " + monster.getAtk() + " Damage");
                }
                prakitko.isDead();
                monster.isDead();
                whoHere();
            } else if (prakitko.getAtkSpeed() < monster.getAtkSpeed()) {
                prakitko.receiveDamage(monster.getAtk());
                System.out.println(monster.getName() + " Dealt " + prakitko.getName() + " " + monster.getAtk() + " Damage");
                if (!prakitko.isDead()) {
                    monster.receiveDamage(prakitko.getAtk());
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
        int loseExp = -(currentExp * 5 / 100);
        prakitko.receiveExp(loseExp);
        return loseExp;
    }

    public int isBattleEnd() {
        if (isMonsterDie()) {
            return 1;
        } else if (isPrakitkoDie()) {
            return 2;
        }
        return -1;

    }

    public void battleReward() {
        if (isMonsterDie()) {
            this.expHolding += monster.dropExp();
        this.itemHolding.add(monster.itemDrop());
        this.prakitko.receiveExp(expHolding);
        System.out.println(prakitko.getName() + " receive : " + expHolding + " exp");
        for (Item currentItem : itemHolding) {
            this.prakitko.receiveItem(currentItem);
            System.out.println(prakitko.getName() + " receive : " + currentItem);
        }
        this.expHolding = 0;
        this.itemHolding.clear();
        }
        else if (isPrakitkoDie()) {
            System.out.println("You get no Reward");
        System.out.println("You lose "+loseExp(prakitko.getCurrentMaxExp())+" exp");
        }
        

    }

    public void whoHere() {
        System.out.println("\u001b[33m▓▓▓▓▓\u001b[0m▓▓▓▓▓  ▓▓▓▓▓▓▓▓▓▓  ▓▓▓▓▓\u001b[33m▓▓▓▓▓\u001b[0m\n");
        System.out.println(" \u001b[33;1mYour Prakitko                          \u001b[31;1mMonster\u001b[0m     \n");
        System.out.format("\u001b[33;1m%-10s\u001b[0m: %-23s \u001b[33;1m%-10s\u001b[0m: %s\n","Name",prakitko.getName(),"Name",monster.getName());
        System.out.format("\u001b[33;1m%-10s\u001b[0m: %-23s \u001b[33;1m%-10s\u001b[0m: %s\n","ʟᴇᴠᴇʟ",prakitko.getLevel(),"ʟᴇᴠᴇʟ",monster.getLevel());
        System.out.format("\u001b[31;1m%-10s\u001b[0m: %s/%-8s \u001b[31;1m%s\u001b[33;1m%-10s\u001b[31;1m%-10s\u001b[0m: %s/%s\n","ʜᴘ",prakitko.getCurrentHp(),prakitko.getMaxHp(),"V","S","ʜᴘ",monster.getCurrentHp(),monster.getMaxHp());
        System.out.format("\u001b[34;1m%-10s\u001b[0m: %-23s \u001b[34;1m%-10s\u001b[0m: %s\n","ᴀᴛᴋ",prakitko.getAtk(),"ᴀᴛᴋ",monster.getAtk());
        System.out.format("\u001b[32;1m%-10s\u001b[0m: %-23s \u001b[32;1m%-10s\u001b[0m: %s\n","ᴀᴛᴋsᴘᴅ",prakitko.getAtkSpeed(),"ᴀᴛᴋsᴘᴅ",monster.getAtkSpeed());
        System.out.format("\u001b[33;1m%-10s\u001b[0m: %-23s \u001b[33;1m%-10s\u001b[0m: %s\n","sᴛᴀᴛᴜs",prakitko.getStatus(),"sᴛᴀᴛᴜs",monster.getStatus());
        System.out.println("\n\u001b[33m▓▓▓▓▓\u001b[0m▓▓▓▓▓  ▓▓▓▓▓▓▓▓▓▓  ▓▓▓▓▓\u001b[33m▓▓▓▓▓\u001b[0m");
    }
}
