package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.water.WaterTank;

import java.io.IOException;

public class AutomaticCoffeeMachineBuilder {
    private WaterTank waterTank;
    private Integer needToCleanNumber;

    public AutomaticCoffeeMachineBuilder setWaterTank(WaterTank waterTank) {
        this.waterTank = waterTank;
        return this;
    }

    public AutomaticCoffeeMachineBuilder setNeedToCleanNumber(Integer needToCleanNumber) {
        this.needToCleanNumber = needToCleanNumber;
        return this;
    }

    public AutomaticCoffeeMachine createAutomaticCoffeeMachine() throws IOException {
        return new AutomaticCoffeeMachine(waterTank, needToCleanNumber);
    }
}
