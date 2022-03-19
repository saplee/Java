package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drinks.Drink;
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

    public Drink.DrinkType start(Drink.DrinkType capsuleType) throws MachineException {
        Drink.DrinkType result = null;
        if (capsuleType == null) {
            if (waterTank.noWaterInTank() || needToClean()) {
                throw new MachineException("Can't make this drink!");
            } else if (!waterTank.noWaterInTank() && !needToClean() && (capsuleEmptyInside || !capsuleInMachine)) {
                waterTank.takeWater();
                result = Drink.DrinkType.WATER;
                LOGGER.info("Hot water came.");
            }
        } else if (!waterTank.noWaterInTank() && !needToClean() && !capsuleEmptyInside && !capsuleInMachine) {
            waterTank.takeWater();
            count++;
            result = capsuleType;
            capsuleEmptyInside = true;
            capsuleInMachine = true;
            LOGGER.info("Capsule drink has created");
        } else if (waterTank.noWaterInTank() || needToClean() || capsuleInMachine) {
            throw new MachineException("Can't make drink!");
        }
        return result;
    }
}
