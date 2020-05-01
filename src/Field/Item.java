package Field;

import Item.*;


public abstract class Item {
//    private int recieveHp;
    private String name;
    private int regen;
    private int amount;
    private int id;
    private int regenStamina;
    
    public Item (int regen, int id,String name){
        this.regen = regen;
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
        return regen;
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
    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", regen=" + regen + '}';
    }

}
