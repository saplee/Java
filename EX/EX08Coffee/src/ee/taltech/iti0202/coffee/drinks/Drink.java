package ee.taltech.iti0202.coffee.drinks;

import java.util.Map;

public class Drink {
    private DrinkType drinkType;
    private Map<String, Integer> map;

    public Drink(DrinkType drinkType, Map<String, Integer> map) {
        this.drinkType = drinkType;
        this.map = map;
    }

    public enum DrinkType {
        COFFEE, CACAO, CAPPUCCINO, WATER
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }
}
