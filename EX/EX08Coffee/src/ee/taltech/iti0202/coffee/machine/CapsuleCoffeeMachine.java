package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.exceptions.EmptyWaterTankException;
import ee.taltech.iti0202.coffee.exceptions.GarbageContainerFull;
import ee.taltech.iti0202.coffee.exceptions.MachineException;
import ee.taltech.iti0202.coffee.water.WaterTank;


public class CapsuleCoffeeMachine extends CoffeeMachine {
    private boolean capsuleEmptyInside = false;
    private boolean capsuleInMachine = false;

    public CapsuleCoffeeMachine(WaterTank waterTank) {
        super(waterTank, 10, 0);
    }

    public void takeCapsuleOut() {
        if (capsuleInMachine) {
            capsuleInMachine = false;
            capsuleEmptyInside = false;
        }
    }

    public Drink.DrinkType start(Drink.DrinkType capsule) throws MachineException, EmptyWaterTankException, GarbageContainerFull {
        Drink.DrinkType result = null;
        if (capsule == null) {
            if (waterTank.noWaterInTank()) {
                throw new EmptyWaterTankException("No water in tank!");
            } else if (needToClean()) {
                throw new GarbageContainerFull("Garbage container is full!");
            } else if (!waterTank.noWaterInTank() && !needToClean() && (capsuleEmptyInside || !capsuleInMachine)) {
                waterTank.takeWater();
                result = Drink.DrinkType.WATER;
                LOGGER.info("Hot water came.");
            }
        } else if (!waterTank.noWaterInTank() && !needToClean() && !capsuleEmptyInside && !capsuleInMachine) {
            waterTank.takeWater();
            count++;
            result = capsule;
            capsuleEmptyInside = true;
            capsuleInMachine = true;
            LOGGER.info("Capsule drink has created");
        } else if (waterTank.noWaterInTank() || capsuleInMachine) {
            throw new MachineException("Can't make drink!");
        } else if (needToClean()) {
            throw new GarbageContainerFull("Garbage container is full!");
        }
        return result;
    }
}
