package Field;

import status.STATUS;

/**
 *
 * @author User
 */
public abstract class Character {
    private final int MAXLEVEL = 30;
    private String name;
    private int maxHp;
    private int currentHp;
    private int atk;
    private int speed;
    private int currentStamina;
    private int level = 1;
    private STATUS status = STATUS.ALIVE;
  
    
    protected Character(String name){
        this.name = name;
        
    }
    protected Character(String name,int maxHp,int atk,int speed){
        this.name = name;
        this.maxHp=maxHp;
        this.currentHp=maxHp;
        this.atk = atk;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public STATUS getStatus() {
        return status;
    }
    void setStatus(STATUS status){
        this.status = status;
    }
    int recieveDamage(int atk){
        return currentHp - atk;
    }
    void recieveItem(Item item){
        
    }
}
