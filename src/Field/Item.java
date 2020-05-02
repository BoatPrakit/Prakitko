package Field;

import Item.*;
import Type.ITEMTYPE;


public class Item {
//    private int recieveHp;
    private String name;
    private int regenHp;
    private int amount;
    private int id;
    private int regenStamina;
    private ITEMTYPE itemtype;
    
    public Item (){
        this.regenHp = regenHp;
        this.id = id;
        this.name = name;
    }
    public Item(int id,String name){
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public int getRegen() { // 
        return regenHp;
    }
    protected void setRegenStamina(int regenstamina){
        this.regenStamina = regenstamina;
    }
    
    public void increaseAmount(){ //เพิ่มค่า amount ของ item 
        amount+=1;
    }
    
    public void setAmount(int amount){
        this.amount = amount;
    }

    public void decreaseAmount(){
        amount-=1;
        if(amount<=0) amount = 0;
    }
    
    public int amountCheck(){
        return amount;
    }
    public int getRegenStamina(){
        return regenStamina;
    }
    
    public ITEMTYPE getType(){
        return itemtype;
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
    
    public void setRegenHp(int rengenHp){
        this.regenHp = regenHp;
    }
    
    public void setRegenSta(int regenStamina){
        this.regenStamina = regenStamina;
    }
    
    @Override
    public String toString() {
        return "Item{" + "name=" + name +", regenHp=" + regenHp + '}';
    }

}
