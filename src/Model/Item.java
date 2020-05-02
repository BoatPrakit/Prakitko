package Model;

import Type.ITEMTYPE;
import java.util.ArrayList;


public class Item {
//    private int recieveHp;
    private String name;
    private int regenHp;
    private int amount;
    private int id;
    private int regenStamina;
    private ITEMTYPE itemtype;
    private ArrayList<Item> item = new ArrayList<Item>();
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public int getRegen() { // 
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
    
    @Override
    public String toString() {
        return "Item{" + "name=" + name +", regenHp=" + regenHp + '}';
    }

}
