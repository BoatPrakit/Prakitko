package Model;

import Model.Item;
import Model.Character;
import static Service.ItemService.createStaminaPotion;
import static databaseManagement.DatabaseSystem.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Prakit
 */

public class Prakitko extends Character {

    private final int[] EXPTOLEVELUP = {100, 120, 1000, 2000,5000};
    private int currentExp;
    private int currentMaxExp = EXPTOLEVELUP[0];
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public Prakitko(String name) {
        super(name);
    }

    public int getCurrentExp() {
        return currentExp;
    }
    
    public void receiveExp(int exp) {
        currentExp += exp;
        if (currentExp < 0) {
            currentExp = 0;
        }
        int countLvlup = 0;
        while (isLevelUp()) {
            countLvlup+=1;
            if(countLvlup > EXPTOLEVELUP.length) break;
            levelUp();
            calculateStat();
            
        }
        insertLevel(super.getLevel(), currentExp);
    }

    private void levelUp() {
        currentExp -= currentMaxExp;
        super.plusLevel();
        try {
            this.nextCurrentMaxExp();
        } catch (ArrayIndexOutOfBoundsException e) {
            currentMaxExp = EXPTOLEVELUP[EXPTOLEVELUP.length - 1];
        }
    }

    private boolean isLevelUp() {
        return currentExp >= currentMaxExp;
    }
    
    private void nextCurrentMaxExp() throws ArrayIndexOutOfBoundsException {
        int next = super.getLevel() - 1;
        currentMaxExp = EXPTOLEVELUP[next];
    }

    private void calculateStat() {
        super.plusAtk();
        super.plusAtkSpeed();
        super.plusMaxHp();
        super.plusMaxStamina();
        super.setFullHp(); //When player level up hp will full
    }

    public boolean useItem(Item item) {
        if (item == null) {
            return false;
        }
        int index = sameItemAtIndex(item);      //find index that equal item to use
        if (inventory.contains(item)) {
            if (inventory.get(index).amountCheck() > 0) {
                if (!item.getName().equals(createStaminaPotion().getName())) {              //if this item isn't stamina potion
                    int regenHp = inventory.get(index).getRegen();
                    super.regenHp(regenHp);
                } else if (item.getName().equals(createStaminaPotion().getName())) {         //if this item is stamina potion
                    int regenStamina = inventory.get(index).getRegenStamina();
                    super.regenStamina(regenStamina);
                }
                inventory.get(index).decreaseAmount();
                insertItem(inventory.get(index));                 //database system
                if (inventory.get(index).amountCheck() <= 0) {
                    insertItem(inventory.get(index));                //database system
                    inventory.remove(item);
                }
                sortInventory();
                return true;
            }
        }
        System.out.println("No more Item!");
        return false;
    }

    public boolean receiveItem(Item item) {
        int index = sameItemAtIndex(item);

        if (index == -2) {
            inventory.add(item);
            index = sameItemAtIndex(item);
            inventory.get(index).increaseAmount();
            sortInventory();
            insertItem(inventory.get(index));                           //datebase system
            return true;
        } else if (index >= 0) {
            inventory.get(index).increaseAmount();
            insertItem(inventory.get(index));                           //datebase system
            sortInventory();
            return true;
        }
        sortInventory();
        return false;
    }

    public int showInventory() {
        if(inventory.isEmpty()){
            System.out.println("Your inventory is Empty!") ;
            return 0;
        }
        else{
            int i = 1;
            for (Item item1 : inventory) {
                System.out.println(i+"" +item1 + " Amount " + item1.amountCheck());
                i++;
            }
            return i;
        }
    }

    private int sameItemAtIndex(Item item) {
        if (item == null) {
            return -1;
        }
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(item.getName())) {
                return i;
            }
        }
        return -2;
    }
    
    private void sortInventory() {
        inventory.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1 == null || o2 == null) {
                    return -100;
                }

                return o1.getId() - o2.getId();
            }
        });
    }

    public int levelToExp(int lvl, int exp) {
        int[] newarray = new int[lvl - 1];
        int temp = 0;
        System.arraycopy(EXPTOLEVELUP, 0, newarray, 0, lvl - 1);
        for (int i = 0; i < newarray.length; i++) {
            temp += newarray[i];
        }
        temp += exp;
        return temp;
    }

}
