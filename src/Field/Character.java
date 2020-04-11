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
    private int atkSpeed;
    private int currentStamina;
    private int maxStamina;
    private int level = 1;
    private STATUS status = STATUS.ALIVE;
    protected Item item;
    
    protected Character(String name){
        this.name = name;
        
    }
    protected Character(String name,int maxHp,int atk,int atkSpeed){
        this.name = name;
        this.maxHp=maxHp;
        this.currentHp=maxHp;
        this.atk = atk;
        this.atkSpeed = atkSpeed;
    }
    protected void plusAtk(double atkPerLvl){
        this.atk += atkPerLvl;
    }
    protected void plusMaxHp(double hpPerLvl){
        this.maxHp += hpPerLvl;
    }
    protected void plusMaxStamina(double staminaPerLvl){
        this.maxStamina += staminaPerLvl;
    }
    protected void plusAtkSpeed(double atkSpeedPerLvl){
        this.atkSpeed += atkSpeedPerLvl;
    }
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return atkSpeed;
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
    protected void plusLevel(){
        this.level++;
    }
    public int getLevel(){
        return level;
    }
    public void changeName(String name){
        this.name = name;
    } 
}
