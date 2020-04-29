package Field;

import prototype.Monster;
import prototype.Prakitko;
import status.STATUS;

/**
 *
 * @author User
 */
public class Field {
    private Prakitko prakitko;
    private Monster monster;
    private int exp;
    
    public Field(Prakitko prakitko, Monster monster){
        this.prakitko = prakitko;
        this.monster = monster;
    }
    
    public void attack(){
        if(this.monster.getCurrentHp()<=0){
            Character mn = (Character)monster;
            mn.setStatus(STATUS.DEAD);
//            this.monster = (Monster)mn;
        }
        if(this.prakitko.getCurrentHp()<=0 ){
            Character pk = (Character)prakitko;
            pk.setStatus(STATUS.DEAD);
            this.prakitko = (Prakitko)pk;
            this.exp = loseExp(prakitko.getCurrentExp());
           prakitko.receiveExp(exp);
           
        }
    }
    
    public boolean isMonsterDie(){
        if(monster == null || prakitko == null) return false;
        if(monster.getStatus() == STATUS.DEAD)return true;
        return false;
    }
    private int loseExp(int currentExp){
        return currentExp*5/100;
    }
    
    public int expGiveTo(Character prakitko){
//        prakitko = this.prakitko;
        
        return 0;
    }
    
    public void whoHere(){
        System.out.println(prakitko.getName());
        System.out.println(monster);
    }
}
