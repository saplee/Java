package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.logger.Logging;
import ee.taltech.iti0202.coffee.water.WaterTank;

import java.util.logging.Logger;

public class AutomaticCoffeeMachine extends CoffeeMachine {
    private final static Logger LOGGER = Logger.getLogger(Logging.class.getName());
    public AutomaticCoffeeMachine(WaterTank waterTank, Integer needToCleanNumber) {
        super(waterTank, needToCleanNumber, 0);
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
            LOGGER.info("Drink has created");
        } else if (waterTank.noWaterInTank() || needToClean()) {
            throw new MachineException("Can't make this drink!");
        }
        return result;
    }
}
