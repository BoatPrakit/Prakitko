package Model;

import Model.Item;
import Type.CHARACTERTYPE;
import status.STATUS;

/**
 *
 * @author Prakit & Sapondanai
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
    private CHARACTERTYPE type;
    
    protected Character(String name){
        this.name = name;
        
    }
    protected Character(){
        this.level = 1;
    }
    //=====================================================
    protected int randomLvl(int lvlRange){
        this.level = (int)Math.ceil(Math.random()*lvlRange);
        return level;
    }
    protected void calculateStatMonster(){
        calculateAtk(atk, atkPerLvl);
        calculateAtkSpeed(atkSpeed, atkSpeedPerLvl);
        calculateMaxHP(maxHp, hpPerLvl);
        calculateMaxStamina(maxStamina, staminaPerLvl);
        setFullHp();
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
    //========================================================
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
    protected void plusLevel(){
        this.level++;
        if(level >= MAXLEVEL) level = MAXLEVEL;
    }
    //=======================================================
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
    public int getLevel(){
        return level;
    }
    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentStamina() {
        return currentStamina;
    }
    //=============================================
    public int receiveDamage(int atk){
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
    public void changeName(String name){
        this.name = name;
    } 
    public int dropExp(){
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
    protected void regenHp(int regenHp){
        this.currentHp += regenHp;
        if(currentHp > maxHp){
            currentHp = maxHp;
        }
    }
    protected void regenStamina(int regenStamina){
        this.currentStamina += regenStamina;
        if(currentStamina > maxStamina){
            currentStamina = maxStamina;
        }
    }
    public CHARACTERTYPE getType(){
        return type;
    }
    //==============================================
    void setStatus(STATUS status){
        this.status = status;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setFullHp(){
        this.currentHp = maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setAtkSpeed(int atkSpeed) {
        this.atkSpeed = atkSpeed;
    }

    public void setCurrentStamina(int currentStamina) {
        this.currentStamina = currentStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public void setHpPerLvl(int hpPerLvl) {
        this.hpPerLvl = hpPerLvl;
    }

    public void setAtkPerLvl(int atkPerLvl) {
        this.atkPerLvl = atkPerLvl;
    }

    public void setStaminaPerLvl(int staminaPerLvl) {
        this.staminaPerLvl = staminaPerLvl;
    }

    public void setAtkSpeedPerLvl(int atkSpeedPerLvl) {
        this.atkSpeedPerLvl = atkSpeedPerLvl;
    }

    public void setType(CHARACTERTYPE type) {
        this.type = type;
    }
    
    public void setBaseExpGive(int exp){
        this.baseExpGive = exp;
    }
    public void setLevelRange(int levelRange){
        this.levelRange = levelRange;
    }
    //==================================================
    @Override
    public String toString(){
        return "▓▓▓▓▓▓▓▓▓▓\n\u001b[0mName : "+"\u001B[31;1m"+getName()+"\n👑 ʟᴇᴠᴇʟ : "+getLevel()+"\n❤ ʜᴘ    : "+getCurrentHp()+
                "/"+getMaxHp()+ "\n⚔ ᴀᴛᴋ   : "+getAtk()+"\n🍃 ᴀᴛᴋsᴘᴅ : "+getAtkSpeed()+"\nsᴛᴀᴛᴜs : "+getStatus()+"\n▓▓▓▓▓▓▓▓▓▓"
                ;
    }
}
