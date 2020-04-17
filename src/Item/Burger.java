
package Item;

public class Burger extends Food{
    
     private static int regenHp = 50;
     private static String Id = "Id :Item003";
    
   public Burger() {
        super(regenHp, Id);
    }
    
     @Override
    public String toString() {
        return "Burger{" +"RegenHp : " + super.getRegen() + '}';
    }
  
    
}
