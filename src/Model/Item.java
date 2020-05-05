package Model;

import Type.ITEMTYPE;
import java.util.ArrayList;

/**
 *
 * @author Pattarapol
 */
public class Item {
    private String name;
    private int amount;
    private int id;
    private int regenHp;
    private int regenStamina;
    private ITEMTYPE itemtype;
    private boolean canRegenHp;
    private boolean canRegenStamina;

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public int getRegenHp() { // 
        return regenHp;
    }
    
    public int getRegenStamina(){
        return regenStamina;
    }
    
    public ITEMTYPE getType(){
        return itemtype;
    }
    
    public void increaseAmount(){ //เพิ่มค่า amount ของ item 
        amount+=1;
    }
    
    public void decreaseAmount(){
        amount-=1;
        if(amount<=0) amount = 0;
    }
    
    public int amountCheck(){
        return amount;
    }
    
    public void setAmount(int amount){
        this.amount = amount;
    }
    
    public void setType(ITEMTYPE itemtype){
        this.itemtype = itemtype;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setRegenHp(int regenHp){
        this.regenHp = regenHp;
    }
    
    public void setRegenStamina(int regenstamina){
        this.regenStamina = regenstamina;
    }

    public boolean isCanRegenHp() {
        return canRegenHp;
    }

    public boolean isCanRegenStamina() {
        return canRegenStamina;
    }

    public void setCanRegenHp(boolean canRegenHp) {
        this.canRegenHp = canRegenHp;
    }

    public void setCanRegenStamina(boolean canRegenStamina) {
        this.canRegenStamina = canRegenStamina;
    }
    
    
    @Override
    public String toString() {
        return String.format("%-15s regen\u001b[31;1m ❤\u001b[0m : %-5s regenStamina\u001b[36;1m ♨\u001b[0m : %-5s", name,regenHp,regenStamina);
//        return "Item{" + "name=" + name +", regenHp=" + regenHp + ", regenStamina="+ regenStamina +'}';
    }

}
