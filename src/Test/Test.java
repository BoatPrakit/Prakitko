package Test;

import prakitkomodel.Dog;
import Field.*;
import Item.*;

public class Test {
    public static void main(String[] args) {
        Dog kb = new Dog("kb");
        Burger Burger = new Burger();
        Cake Cake = new Cake();
        Taco Taco = new Taco();
        Map1 Map1 = new Map1();
        Map1.arrayCheck();
        Map1.reRandomLevelMonster();
        Map1.arrayCheck();
        System.out.println(Map1.spawnRate());
    }
}
