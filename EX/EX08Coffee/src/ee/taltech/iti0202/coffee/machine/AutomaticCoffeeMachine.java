package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.water.WaterTank;

public class AutomaticCoffeeMachine extends CoffeeMachine {


    public AutomaticCoffeeMachine(WaterTank waterTank, Integer needToCleanNumber) {
        super(waterTank, needToCleanNumber, 1000000000);
    }
    @Override
    public boolean notEnoughCoffeeBeans(int number) {
        return false;
    }

    @Override
    public Drink.DrinkType start(Drink drink) throws MachineException {
        Drink.DrinkType result = null;
        if (!waterTank.noWaterInTank() && !needToClean()) {
            waterTank.takeWater();
            count++;
            result = drink.getDrinkType();
        } else if (waterTank.noWaterInTank() || needToClean()) {
            throw new MachineException("Can't make drink!");
        }
        return result;
    }
}
