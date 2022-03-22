package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.water.WaterTank;

public class CapsuleCoffeeMachineBuilder {
    private WaterTank waterTank;

    public CapsuleCoffeeMachineBuilder setWaterTank(WaterTank waterTank) {
        this.waterTank = waterTank;
        return this;
    }

    public CapsuleCoffeeMachine createCapsuleCoffeeMachine() {
        return new CapsuleCoffeeMachine(waterTank);
    }
}
