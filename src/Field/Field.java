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
        if (!isMonsterDie() && !isPrakitkoDie()) {
        if (prakitko.getAtkSpeed() >= monster.getAtkSpeed()) {
            monster.recieveDamage(prakitko.getAtk());
            System.out.println(prakitko.getName()+" Dealt "+monster.getName()+" "+prakitko.getAtk()+" Damage");
            if (!monster.isDead()) {
                prakitko.recieveDamage(monster.getAtk());
                System.out.println(monster.getName()+" Dealt "+prakitko.getName()+" "+monster.getAtk()+" Damage");
            }
            prakitko.isDead();
            monster.isDead();
            whoHere();
        }
        else  prakitko.recieveDamage(monster.getAtk());
            System.out.println(monster.getName()+" Dealt "+prakitko.getName()+" "+monster.getAtk()+" Damage");
            if (!prakitko.isDead()) {
                monster.recieveDamage(prakitko.getAtk());
                System.out.println(prakitko.getName()+" Dealt "+monster.getName()+" "+prakitko.getAtk()+" Damage");
            }
            prakitko.isDead();
            monster.isDead();
            whoHere();
            }else System.out.println("Fight already end");
         if (isMonsterDie()) {
            monster.
        }
    }
    
    public boolean isMonsterDie(){
        if(monster == null || prakitko == null) return false;
        if(monster.getStatus() == STATUS.DEAD)return true;
        return false;
    }
    
    public boolean isPrakitkoDie(){
        if(prakitko == null) return false;
        if(prakitko.getStatus() == STATUS.DEAD) return true;
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
        System.out.println(prakitko);
        System.out.println(monster);
    }
}
