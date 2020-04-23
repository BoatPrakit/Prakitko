
package Item;

public class Cake extends Food{
    
    private static int regenHp = 10;
    private static int Id = 002;
        private static String name = "Cake";
    
    public Cake() {
        super(regenHp, Id, name);
    }


    @Override
    public String toString() {
        return "Cake{" + "RegenHp : " + super.getRegen() + '}';
    }

}
