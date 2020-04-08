package Field;

import status.STATUS;

/**
 *
 * @author User
 */
public abstract class Character {
    private final int MAXLEVEL = 30;
    private String name;
    private int currentHp;
    private int maxHp;
    private int atk;
    private int speed;
    private int currentStamina;
    private int level = 1;
    private STATUS status = STATUS.ALIVE;
    private double hpPerLvl;
    private double atkPerLvl;
    private double staminaPerLvl;
    private double speedPerLvl;
    
    protected Character(String name){
        this.name = name;
        
    }
    protected Character(String name,int maxHp,int atk,int speed){
    
    }
    }
}
