package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.water.WaterTank;

import java.io.IOException;

public class CapsuleCoffeeMachineBuilder {
    private WaterTank waterTank;

    public CapsuleCoffeeMachineBuilder setWaterTank(WaterTank waterTank) {
        this.waterTank = waterTank;
        return this;
    }

    public CapsuleCoffeeMachine createCapsuleCoffeeMachine() throws IOException {
        return new CapsuleCoffeeMachine(waterTank);
    }
}
