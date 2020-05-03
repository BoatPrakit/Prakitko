/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Field;

import Model.Map;
import Model.Prakitko;
import static Service.PrakitkoService.*;
import static Service.MonsterService.*;
import static Service.MapService.*;

/**
 *
 * @author Klitb
 */
public class Test {
    static Prakitko x = createDog("kb");
    public static void main(String[] args) {  
       
        Map z = createGraveYard();
        
        
        
        Field y = z.fight(x);
        
        y.whoHere();
        
   
    }
}
