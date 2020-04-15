package Field;


public abstract class Item {
    private int recieveHp;
    private String name;
    private int regen;
    
    public Item (int regen){
        this.regen = regen;
    }
    

    public String getName() {
        return name;
    }

    public int getRegen() {
        return regen;
    }
  
    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", regen=" + regen + '}';
    }

}
