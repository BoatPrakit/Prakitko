package prakitkomodel;

import prototype.Prakitko;

/**
 *
 * @author User
 */
public class Dog extends Prakitko{
    public int x;
    public Dog(String name){
        super(name,120,30,20,10,3,8,2);  
    }
    public int getX(){
        return x;
    }
}
