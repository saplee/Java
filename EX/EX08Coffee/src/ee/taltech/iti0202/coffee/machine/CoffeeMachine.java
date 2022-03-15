package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.water.WaterTank;

public class CoffeeMachine {
    private WaterTank waterTank;
    private int needToClean;


    public CoffeeMachine(WaterTank waterTank, int needToClean) {

        this.waterTank = waterTank;
        this.needToClean = needToClean;
    }
}
