package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.water.WaterTank;

public class CoffeeMachineBuilder {
    private WaterTank waterTank;
    private Integer needToCleanNumber;
    private Integer coffeeBeans;

    public CoffeeMachineBuilder setWaterTank(WaterTank waterTank) {
        this.waterTank = waterTank;
        return this;
    }

    public CoffeeMachineBuilder setNeedToCleanNumber(Integer needToCleanNumber) {
        this.needToCleanNumber = needToCleanNumber;
        return this;
    }

    public CoffeeMachineBuilder setCoffeeBeans(Integer coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
        return this;
    }

    public CoffeeMachine createCoffeeMachine() {
        return new CoffeeMachine(waterTank, needToCleanNumber, coffeeBeans);
    }
}