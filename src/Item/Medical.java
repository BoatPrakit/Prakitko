/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

import Field.Item;

public class Medical extends Item{
    
    private Medical[] Medical;
    
    public Medical(String name) {
        super(name);
    }
    
    @Override
    public int regenHp(){
        return 1;
    }

    @Override
    public String toString() {
        return "Medical{" + "Medical=" + Medical + '}';
    }
    
    
    
}
