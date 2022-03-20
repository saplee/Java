package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.exceptions.EmptyWaterTankException;
import ee.taltech.iti0202.coffee.exceptions.GarbageContainerFull;
import ee.taltech.iti0202.coffee.exceptions.MachineException;
import ee.taltech.iti0202.coffee.logger.Logging;
import ee.taltech.iti0202.coffee.water.WaterTank;


import java.util.Set;
import java.util.logging.Logger;


public class CoffeeMachine {
    protected static Logger LOGGER = Logger.getLogger(Logging.class.getName());
    private final Integer coffeeBeansTank;
    protected WaterTank waterTank;
    protected Integer needToCleanNumber;
    protected Integer coffeeBeans;
    protected int count = 0;

    /**
     * @param waterTank
     * @param needToCleanNumber
     * @param coffeeBeans
     */
    public CoffeeMachine(WaterTank waterTank, Integer needToCleanNumber, Integer coffeeBeans) {
        this.waterTank = waterTank;
        this.needToCleanNumber = needToCleanNumber;
        this.coffeeBeans = coffeeBeans;
        this.coffeeBeansTank = coffeeBeans;
    }

    /**
     * @param waterTank
     * @param coffeeBeans
     */
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
            LOGGER.info("Coffee machine was cleaned");
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
            LOGGER.info("Coffee beans added to machine.");
        }
    }

    /**
     * @param drink
     * @return
     * @throws MachineException
     */
    public Drink.DrinkType start(Drink drink) throws MachineException, EmptyWaterTankException, GarbageContainerFull {
        Set<String> keys = drink.getMap().keySet();
        Integer amount = 0;
        for (String key : keys) {
            if (key.toLowerCase().replaceAll(" ", "").equals("coffeebeans")) {
                amount = drink.getMap().get(key);
            } else {
                throw new MachineException("Can't make this drink!");
            }
        }
        Drink.DrinkType result = null;
        if (!waterTank.noWaterInTank() && !needToClean() && !notEnoughCoffeeBeans(amount)) {
            waterTank.takeWater();
            count++;
            takeCoffeeBeans(amount);
            result = drink.getDrinkType();
            LOGGER.info("Drink has created");
        } else if (notEnoughCoffeeBeans(amount)) {
            throw new MachineException("Can't make this drink!");
        } else if (waterTank.noWaterInTank()) {
            throw new EmptyWaterTankException("No water in tank!");
        } else if (needToClean()) {
            throw new GarbageContainerFull("Garbage container is full!");
        }
        return result;
    }
}
