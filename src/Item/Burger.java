
package Item;

public class Burger extends Food{
    
     private static int regenHp = 50;
    
    public Burger() {
        super(regenHp);
    }
    
     @Override
    public String toString() {
        return "Burger{" +"RegenHp : " + super.getRegen() + '}';
    }
  
    
}
