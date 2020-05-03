package Service;

import Model.Item;
import Type.ITEMTYPE;

/**
 *
 * @author Pattarapol
 */

public class ItemService {

    public static Item createTaco() {
        Item item = new Item();
        item.setName("Taco");
        item.setId(1);
        item.setType(ITEMTYPE.FOOD);
        item.setRegenHp(20);
        item.setCanRegenHp(true);
        return item;
    }

    public static Item createCake() {
        Item item = new Item();
        item.setName("Cake");
        item.setId(2);
        item.setType(ITEMTYPE.FOOD);
        item.setRegenHp(10);
        item.setCanRegenHp(true);
        return item;
    }

    public static Item createBurger() {
        Item item = new Item();
        item.setName("Burger");
        item.setId(3);
        item.setType(ITEMTYPE.FOOD);
        item.setRegenHp(50);
        item.setCanRegenHp(true);
        return item;
    }

    public static Item createHealingPotion() {
        Item item = new Item();
        item.setName("HealingPotion");
        item.setId(4);
        item.setType(ITEMTYPE.POTIONS);
        item.setRegenHp(50);
        item.setCanRegenHp(true);
        return item;
    }

    public static Item createStaminaPotion() {
        Item item = new Item();
        item.setName("StaminaPotion");
        item.setId(5);
        item.setType(ITEMTYPE.POTIONS);
        item.setRegenStamina(70);
        item.setCanRegenStamina(true);
        return item;
    }
}
