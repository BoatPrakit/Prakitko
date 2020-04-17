package Field;


public abstract class Item {
//    private int recieveHp;
    private String name;
    private int regen;
    private int amount;
    
    public Item (int regen){
        this.regen = regen;
    }

    public String getName() {
        return name;
    }

    public int getRegen() {
        return regen;
    }
    
    public void increseAmount(){ //เพิ่มค่า amount
        amount++;
    }
    
    public int amountCheck(){
        return amount;
    }
    
  
    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", regen=" + regen + '}';
    }

}
