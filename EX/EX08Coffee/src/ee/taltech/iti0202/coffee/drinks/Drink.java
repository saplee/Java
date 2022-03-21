package ee.taltech.iti0202.coffee.drinks;

import java.util.Map;
import java.util.Set;

public class Drink {
    private DrinkType drinkType;
    private Map<String, Integer> map;

    public Drink(DrinkType drinkType, Map<String, Integer> map) {
        this.drinkType = drinkType;
        this.map = map;
    }
    public Drink(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public enum DrinkType {
        COFFEE, CACAO, CAPPUCCINO, WATER, LATTE
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public int getBeansAmount() {
        Set<String> keys = map.keySet();
        Integer amount = 0;
        for (String key : keys) {
            if (key.toLowerCase().replaceAll(" ", "").equals("coffeebeans")) {
                amount = map.get(key);
            }
        }return amount;
    }
}
