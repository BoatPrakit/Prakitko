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
    private int levelRange;
    private int baseExpGive;
    private String type;
    
    protected Character(String name){
        this.name = name;
        
    }
    protected Character(String name,int lvlRange,int maxHp,int atk,int atkSpeed,int maxStamina,int hpPerLvl,int atkPerLvl,int atkSpeedPerLvl,int staminaPerLvl,int baseExpGive){
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
        this.levelRange = lvlRange;
        this.baseExpGive = baseExpGive;
        this.level = 1;
        calculateStatMonster();
    }
    protected Character(String name,int maxHp,int atk,int atkSpeed,int maxStamina,int hpPerLvl,int atkPerLvl,int atkSpeedPerLvl,int staminaPerLvl,String type){
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
        this.type = type;
    }
    
    protected int randomLvl(int lvlRange){
        this.level = (int)Math.ceil(Math.random()*lvlRange);
        return level;
    }
    protected void calculateStatMonster(){
        calculateAtk(atk, atkPerLvl);
        calculateAtkSpeed(atkSpeed, atkSpeedPerLvl);
        calculateMaxHP(maxHp, hpPerLvl);
        calculateMaxStamina(maxStamina, staminaPerLvl);
    }
    private int calculateMaxHP(int maxHp,int hpPerLvl){
        int result = maxHp+(hpPerLvl*(level-1));
        this.maxHp = result;
        return result;
    }
    private int calculateAtk(int atk,int atkPerLvl){
        int result = atk+(atkPerLvl*(level-1));
        this.atk = result;
        return result;
    }
    private int calculateAtkSpeed(int atkSpeed,int atkSpeedPerLvl){
        int result = atkSpeed+(atkSpeedPerLvl*(level-1));
        this.atkSpeed = result;
        return result;
    }
    private int calculateMaxStamina(int maxStamina,int staminaPerLvl){
        int result = maxStamina+(staminaPerLvl*(level-1));
        this.maxStamina = result;
        return result;
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
    public int getLevelRange(){
        return levelRange;
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
    public int recieveDamage(int atk){
        if(atk >= currentHp){
            setStatus(STATUS.DEAD);
            currentHp = 0;
        }
        this.currentHp -= atk;
        if (currentHp <= 0) {
            this.currentHp = 0;
        }
        return atk;
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
    public String getType(){
        return type;
    }
    
        private int dropExp(){
        int result = (int)(baseExpGive+((Math.random()+1)*level));
        return result;
    }
    public boolean isDead(){
        if (this.currentHp<=0) {
            this.status = STATUS.DEAD;
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return "▓▓▓▓▓▓▓▓▓▓\n\u001b[0mName : "+"\u001B[31;1m"+getName()+"\n👑 ʟᴇᴠᴇʟ : "+getLevel()+"\n❤ ʜᴘ    : "+getCurrentHp()+
                "/"+getMaxHp()+ "\n⚔ ᴀᴛᴋ   : "+getAtk()+"\n🍃 ᴀᴛᴋsᴘᴅ : "+getAtkSpeed()+"\nsᴛᴀᴛᴜs : "+getStatus()+"\n▓▓▓▓▓▓▓▓▓▓"
                ;
    }
}
