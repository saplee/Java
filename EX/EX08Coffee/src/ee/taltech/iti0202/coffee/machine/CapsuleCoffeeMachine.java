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

    public Drink.CapsuleType start(Drink.CapsuleType capsuleType) throws MachineException {
        Drink.CapsuleType result = null;
        if (capsuleType == null) {
            if (waterTank.noWaterInTank() || needToClean()) {
                throw new MachineException("Can't make drink!");
            } else if (!waterTank.noWaterInTank() && !needToClean() && (capsuleEmptyInside || !capsuleInMachine)) {
                waterTank.takeWater();
                result = Drink.CapsuleType.WATER;
            }
        }
        else if (!waterTank.noWaterInTank() && !needToClean() && !capsuleEmptyInside && !capsuleInMachine) {
            waterTank.takeWater();
            count++;
            result = capsuleType;
            capsuleEmptyInside = true;
            capsuleInMachine = true;
        } else if (waterTank.noWaterInTank() || needToClean() || capsuleInMachine) {
            throw new MachineException("Can't make drink!");
        }
        return result;
    }
}
