package Field;


public abstract class Item {
//    private int recieveHp;
    private String name;
    private int regen;
    private int amount;
    private String Id;
    
    public Item (int regen, String Id){
        this.regen = regen;
        this.Id = Id;
    }

    public String getId() {
        return Id;
    }
    
    public String getName() {
        return name;
    }

    public int getRegen() {
        return regen;
    }
    
    public void increaseAmount(){ //เพิ่มค่า amount
        amount+=1;
    }
    
    public void devreaseAmount(){
        amount-=1;
    }
    
    public int amountCheck(){
        return amount;
    }
    
  
    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", regen=" + regen + '}';
    }

}
