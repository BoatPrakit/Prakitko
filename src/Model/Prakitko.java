package Model;

import Model.Item;
import Model.Character;
import static Service.ItemService.createStaminaPotion;
import static databaseManagement.DatabaseSystem.*;
import java.util.ArrayList;
import java.util.Comparator;
import status.STATUS;

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
    
    public int getCurrentMaxExp(){
        return currentMaxExp;
    }
    public ArrayList<Item> getInventory(){
        return inventory;
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
            calculateStatMonster();
            
        }
        insertLevel(super.getLevel(), currentExp);
    }

    private void levelUp() {
        if(super.getLevel()<=EXPTOLEVELUP.length){
        currentExp -= currentMaxExp;
        super.plusLevel();
        try {
            this.nextCurrentMaxExp();
        } catch (ArrayIndexOutOfBoundsException e) {
            currentMaxExp = EXPTOLEVELUP[EXPTOLEVELUP.length - 1];
        }
        }
    }

    public boolean isLevelUp() {
        return currentExp >= currentMaxExp;
    }
    
    private void nextCurrentMaxExp() throws ArrayIndexOutOfBoundsException {
        int next = super.getLevel() - 1;
        currentMaxExp = EXPTOLEVELUP[next];
    }

    public boolean useItem(Item item) {
        if (item == null) {
            return false;
        }
        int index = sameItemAtIndex(item);      //find index that equal item to use
        if (index>=0) {
            if (inventory.get(index).amountCheck() > 0) {
                    int regenHp = inventory.get(index).getRegen();
                    int regenStamina = inventory.get(index).getRegenStamina();
                if (item.isCanRegenHp()&&!item.isCanRegenStamina()) {                //if this item can only regenHp
                    super.regenHp(regenHp);
                    System.out.println(""+item.getName()+" has been used.");
                    System.out.println("Heal "+super.getName()+" for "+regenHp+" Hp");
                    
                } else if (item.isCanRegenStamina()&&!item.isCanRegenHp()) {         //if this item can only regenStamina 
                    super.regenStamina(regenStamina);
                    System.out.println(""+item.getName()+" has been used.");
                    System.out.println("Regen "+super.getName()+" for "+regenStamina+" stamina");
                    
                } else if (item.isCanRegenHp()&&item.isCanRegenStamina()){           //if this item can regenStamina & regenHp 
                    super.regenHp(regenHp);
                    super.regenStamina(regenStamina);
                    System.out.println(""+item.getName()+" has been used.");
                    System.out.println("Regen "+super.getName()+""+regenHp+" Hp"+" & stamina "+regenStamina+" stamina");
                    
                }
                inventory.get(index).decreaseAmount();
                insertItem(inventory.get(index));                 //database system
                if (inventory.get(index).amountCheck() <= 0) {
                    insertItem(inventory.get(index));                //database system
                    inventory.remove(inventory.get(index));
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

    public void showInventory() {
        if(inventory.isEmpty()){
            System.out.println("Your inventory is Empty!") ;
        }
        else{
            int i = 1;
            for (Item item1 : inventory) {
                System.out.println(i+". " +item1 + " Amount " + item1.amountCheck());
                i++;
            }
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
    public void respawn(){
        super.setFullHp();
        super.setStatus(STATUS.ALIVE);
    }
    
}
