
package prototype;
import Field.Character;
import Field.Item;
import static databaseManagement.DatabaseSystem.*;
import java.util.Arrays;
import java.util.Comparator;
/**
 *
 * @author User
 */
public abstract class Prakitko extends Character{
    private final int[] EXPTOLEVELUP = {100,120,1000,2000};
    private int currentExp ;
    private int currentMaxExp = EXPTOLEVELUP[0];
    private Item[] inventory = new Item[5];
    
    protected Prakitko(String name,int maxHp,int atk,int atkSpeed,int maxStamina,int hpPerLvl,int atkPerLvl,int atkSpeedPerLvl,int staminaPerLvl,String type){
        super(name,maxHp,atk,atkSpeed,maxStamina,hpPerLvl,atkPerLvl,atkSpeedPerLvl,staminaPerLvl,type);
    }
    public void receiveExp(int exp){
        currentExp += exp;
        if(currentExp < 0) currentExp = 0;
        while(isLevelUp()==true){
            levelUp();
            calculateStat();
        }
        insertLevel(super.getLevel(),currentExp);
    }
    private void levelUp(){
     currentExp -= currentMaxExp;
     super.plusLevel();   
     try{
     this.nextCurrentMaxExp();
        }catch(ArrayIndexOutOfBoundsException e){
           currentMaxExp= EXPTOLEVELUP[EXPTOLEVELUP.length-1];
        }
    }
    private boolean isLevelUp(){
        return currentExp>=currentMaxExp;
    }
    public int getCurrentExp() {
        return currentExp;
    }

    public int getCurrentMaxExp() {
        return currentMaxExp;
    }
    private void nextCurrentMaxExp() throws ArrayIndexOutOfBoundsException{
        int next = super.getLevel()-1;
            currentMaxExp = EXPTOLEVELUP[next];
    }
    private void calculateStat(){
        super.plusAtk();
        super.plusAtkSpeed();
        super.plusMaxHp();
        super.plusMaxStamina();
    }
    public boolean useItem(Item item){
        if(item == null)return false;
        int index = sameItemAtIndex(item);
        if(index>=0){
            if(inventory[index].amountCheck()>0){
                
                inventory[index].decreaseAmount();
                      insertItem(inventory[index]);                 //database system
                    if(inventory[index].amountCheck()<=0){
                       insertItem(inventory[index]);                //database system
                       inventory[index] = null;
                    }
                return true;
            }
        }
        System.out.println("No more Item!");
        return false;
    }
    
    
    public boolean receiveItem(Item item){
        int result = sameItemAtIndex(item);
        int nullslot = findEmptySlot();
        if(result==-2){
            inventory[nullslot] = item;
            inventory[nullslot].increaseAmount();
            insertItem(inventory[nullslot]);
            return true;
        }
        else if(result>=0){
            inventory[result].increaseAmount();
            insertItem(inventory[result]);
            return true;
        }
        return false;
    }
    public void showInventory(){
        sortInventory();
        for (Item item1 : inventory) {
            if(item1!=null)
            System.out.println(item1 + " Amount " + item1.amountCheck());
            }       
    }
    private int sameItemAtIndex(Item item){
        if(item == null) return -1;
        for (int i = 0;i < inventory.length ; i++) {
            if(inventory[i]!=null&&inventory[i].getClass().equals(item.getClass())){
                return i;
                 }       
        }
            return -2; 
    
    }
    private int findEmptySlot(){
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i]==null)return i;
        }
        return -1;
    }
    private void sortInventory(){
        Arrays.sort(inventory,new Comparator<Item>(){
            @Override
            public int compare(Item o1, Item o2) {
                if(o1==null||o2==null)return -100;
                
                return o1.getId() - o2.getId();
            }
         });
    }
    public int levelToExp(int lvl,int exp){
        int[] newarray = new int[lvl-1];
        int temp = 0;
        System.arraycopy(EXPTOLEVELUP, 0, newarray,0, lvl-1);
        for (int i = 0; i < newarray.length; i++) {
           temp += newarray[i];
        }
        temp += exp;
        return temp;
    }
}
    