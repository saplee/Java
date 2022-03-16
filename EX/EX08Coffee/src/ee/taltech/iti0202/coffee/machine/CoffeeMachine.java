package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.water.WaterTank;


import java.util.Set;

public class CoffeeMachine {
    private final Integer coffeeBeansTank;
    protected WaterTank waterTank;
    protected Integer needToCleanNumber;
    protected Integer coffeeBeans;
    protected int count = 0;


    public CoffeeMachine(WaterTank waterTank, Integer needToCleanNumber, Integer coffeeBeans) {
        this.waterTank = waterTank;
        this.needToCleanNumber = needToCleanNumber;
        this.coffeeBeans = coffeeBeans;
        this.coffeeBeansTank = coffeeBeans;
    }

    public CoffeeMachine(WaterTank waterTank, Integer coffeeBeans) {
        this.waterTank = waterTank;
        this.needToCleanNumber = 5;
        this.coffeeBeans = coffeeBeans;
        this.coffeeBeansTank = coffeeBeans;
    }


    public boolean needToClean() {
        if (count == needToCleanNumber) {
            return true;
        }
        return false;
    }


    public void cleanCoffeeMachine() {
        if (count > 0) {
            count = 0;
        }
    }

    public boolean notEnoughCoffeeBeans(int number) {
        if (coffeeBeans < number) {
            return true;
        }
        return false;
    }

    public void takeCoffeeBeans(int amount) {
        if (!notEnoughCoffeeBeans(amount)) {
            coffeeBeans -= amount;
        }
    }

    public void addCoffeeBeans() {
        if (coffeeBeansTank > coffeeBeans) {
            coffeeBeans = coffeeBeansTank;
        }
    }


    public Drink.DrinkType start(Drink drink) throws MachineException {
        Set<String> keys = drink.getMap().keySet();
        Integer amount = 0;
        for (String key : keys) {
            if (key.toLowerCase().replaceAll(" ", "").equals("coffeebeans")) {
                amount = drink.getMap().get(key);
            } else {
                throw new MachineException("Can't make drink!");
            }
        }
        Drink.DrinkType result = null;
        if (!waterTank.noWaterInTank() && !needToClean() && !notEnoughCoffeeBeans(amount)) {
            waterTank.takeWater();
            count++;
            takeCoffeeBeans(amount);
            result = drink.getDrinkType();
        } else if (waterTank.noWaterInTank() || needToClean() || notEnoughCoffeeBeans(amount)) {
            throw new MachineException("Can't make drink!");
        }
        return result;
    }
}
