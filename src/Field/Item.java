package Field;


public abstract class Item {
    private int recieveHp;
    private String name;
    
    public Item (String name){
        this.name = name;
    }
    
    public abstract int regenHp();

    public String getName() {
        return name;
    }
    
    
}
