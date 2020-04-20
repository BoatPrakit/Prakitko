package Field;


public abstract class Item {
//    private int recieveHp;
    private String name;
    private int regen;
    private int amount;
    private String id;
    
    public Item (int regen, String id){
        this.regen = regen;
        this.id = id;
    }

    public String getId() {
        return id;
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
    
    public void decreaseAmount(){
        amount-=1;
        if(amount<=0) amount = 0;
    }
    
    public int amountCheck(){
        return amount;
    }
    
  
    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", regen=" + regen + '}';
    }

}
