
package prototype;
import Field.Character;
import Field.Item;
/**
 *
 * @author User
 */
public abstract class Prakitko extends Character{
    private final int[] EXPTOLEVELUP = {100,120,1000,2000};
    private int currentExp ;
    private int currentMaxExp = EXPTOLEVELUP[0];
    private Item[] inventory;
    private double hpPerLvl;
    private double atkPerLvl;
    private double staminaPerLvl;
    private double atkSpeedPerLvl;
    
    protected Prakitko(String name,int maxHp,int atk,int speed){
        super(name,maxHp,atk,speed);
    }
    public void receiveExp(int exp){
        currentExp += exp;
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
        super.plusAtk(atkPerLvl);
        super.plusAtkSpeed(atkSpeedPerLvl);
        super.plusMaxHp(hpPerLvl);
        super.plusMaxStamina(staminaPerLvl);
    }
    protected boolean useItem(Item item){
        if(item == null)return false;
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i]==item){
                inventory[i]=null;
                return true;
            }
        }
        return false;
    }

    
}
    