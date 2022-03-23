package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.exceptions.CapsuleAlreadyInside;
import ee.taltech.iti0202.coffee.exceptions.EmptyWaterTankException;
import ee.taltech.iti0202.coffee.exceptions.GarbageContainerFull;
import ee.taltech.iti0202.coffee.exceptions.MachineException;
import ee.taltech.iti0202.coffee.water.WaterTank;


import java.io.IOException;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Logger;


public class CoffeeMachine {
    protected static Logger logger = Logger.getLogger(CoffeeMachine.class.getName());
    protected WaterTank waterTank;
    protected Integer needToCleanNumber;
    protected Integer coffeeBeans;
    protected int count = 0;
    FileHandler fileName = new FileHandler("logger.txt");

    /**
     * @param waterTank
     * @param needToCleanNumber
     * @param coffeeBeans
     */
    public CoffeeMachine(WaterTank waterTank, Integer needToCleanNumber, Integer coffeeBeans) throws IOException {
        this.waterTank = waterTank;
        this.needToCleanNumber = needToCleanNumber;
        this.coffeeBeans = coffeeBeans;
        if (this.needToCleanNumber == null) {
            this.needToCleanNumber = 5;
        }
        logger.addHandler(fileName);
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
            logger.info("Coffee machine was cleaned");
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

    public void addCoffeeBeans(int number) {
        coffeeBeans += number;
        logger.info("Coffee beans added to machine.");
    }

    /**
     * @param drink
     * @return DrinkType
     * @throws MachineException
     */
    public Drink.DrinkType start(Drink drink) throws MachineException, EmptyWaterTankException, GarbageContainerFull,
            CapsuleAlreadyInside {
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
            logger.info("Drink has created");
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
