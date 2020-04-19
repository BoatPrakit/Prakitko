
package prototype;
import Field.Character;
import Field.Item;
import Item.Burger;
import Item.Taco;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public abstract class Prakitko extends Character{
    private final int[] EXPTOLEVELUP = {100,120,1000,2000};
    private int currentExp ;
    private int currentMaxExp = EXPTOLEVELUP[0];
    private Item[] inventory = new Item[5];
    private int count;
    
    
    protected Prakitko(String name,int maxHp,int atk,int atkSpeed,int maxStamina,int hpPerLvl,int atkPerLvl,int atkSpeedPerLvl,int staminaPerLvl){
        super(name,maxHp,atk,atkSpeed,maxStamina,hpPerLvl,atkPerLvl,atkSpeedPerLvl,staminaPerLvl);
    }
    public void receiveExp(int exp){
        currentExp += exp;
        if(currentExp < 0) currentExp = 0;
        while(isLevelUp()==true){
            levelUp();
            calculateStat();
        }
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
        return (currentExp>=currentMaxExp)?true:false;
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
                    if(inventory[index].amountCheck()<=0){
                        inventory[index] = null;
                    }
                return true;
            }
        }
        return false;
    }
    public boolean receiveItem(Item item){
        int result = sameItemAtIndex(item);
        if(result==-2){
            inventory[count++] = item;
            inventory[count-1].increaseAmount();
            if(count>5) count = 4;
            return true;
        }
        else if(result>=0){
            inventory[result].increaseAmount();
            return true;
        } 
        return false;
    }
    public void showInventory(){
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
    public int getCount(){
        return count;
    }
}
    