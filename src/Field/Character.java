package Field;

import status.STATUS;

/**
 *
 * @author User
 */
public abstract class Character{
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
    private int hpPerLvl;
    private int atkPerLvl;
    private int staminaPerLvl;
    private int atkSpeedPerLvl;
    
    protected Character(String name){
        this.name = name;
        
    }
    protected Character(String name,int level,int maxHp,int atk,int atkSpeed,int maxStamina){
        this.name = name;
        this.maxHp=maxHp;
        this.currentHp=maxHp;
        this.atk = atk;
        this.atkSpeed = atkSpeed;
        this.maxStamina = maxStamina;
        this.currentStamina = maxStamina;
        this.level = level;
    }
    protected Character(String name,int maxHp,int atk,int atkSpeed,int maxStamina,int hpPerLvl,int atkPerLvl,int atkSpeedPerLvl,int staminaPerLvl){
        this.name = name;
        this.maxHp=maxHp;
        this.currentHp=maxHp;
        this.atk = atk;
        this.atkSpeed = atkSpeed;
        this.hpPerLvl = hpPerLvl;
        this.atkPerLvl = atkPerLvl;
        this.staminaPerLvl = staminaPerLvl;
        this.atkSpeedPerLvl = atkSpeedPerLvl;
        this.maxStamina = maxStamina;
        this.currentStamina = maxStamina;
    }
    protected void plusAtk(){
        this.atk += atkPerLvl;
    }
    protected void plusMaxHp(){
        this.maxHp += hpPerLvl;
    }
    protected void plusMaxStamina(){
        this.maxStamina += staminaPerLvl;
    }
    protected void plusAtkSpeed(){
        this.atkSpeed += atkSpeedPerLvl;
    }
    public String getName() {
        return name;
    }

    public int getAtkSpeed() {
        return atkSpeed;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAtk() {
        return atk;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public STATUS getStatus() {
        return status;
    }
    void setStatus(STATUS status){
        this.status = status;
    }
    private int recieveDamage(int atk){
        return currentHp - atk;
    }
    protected void plusLevel(){
        this.level++;
        if(level == MAXLEVEL) level = MAXLEVEL;
    }
    public int getLevel(){
        return level;
    }
    public void changeName(String name){
        this.name = name;
    } 

    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentStamina() {
        return currentStamina;
    }
}
