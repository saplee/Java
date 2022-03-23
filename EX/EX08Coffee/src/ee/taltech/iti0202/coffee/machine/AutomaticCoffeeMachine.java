package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.exceptions.EmptyWaterTankException;
import ee.taltech.iti0202.coffee.exceptions.GarbageContainerFull;
import ee.taltech.iti0202.coffee.exceptions.MachineException;
import ee.taltech.iti0202.coffee.water.WaterTank;

import java.io.IOException;


public class AutomaticCoffeeMachine extends CoffeeMachine {
    public AutomaticCoffeeMachine(WaterTank waterTank, Integer needToCleanNumber) throws IOException {
        super(waterTank, needToCleanNumber, 0);
    }

    @Override
    public boolean notEnoughCoffeeBeans(int number) {
        return false;
    }

    @Override
    public Drink.DrinkType start(Drink drink) throws MachineException, EmptyWaterTankException, GarbageContainerFull {
        Drink.DrinkType result = null;
        if (!waterTank.noWaterInTank() && !needToClean()) {
            waterTank.takeWater();
            count++; //add garbage
            result = drink.getDrinkType();
            logger.info("Drink has created");
        } else if (waterTank.noWaterInTank()) {
            throw new EmptyWaterTankException("No water in tank!");
        } else if (needToClean()) {
            throw new GarbageContainerFull("Garbage container is full!");
        }
        return result;
    }
}
