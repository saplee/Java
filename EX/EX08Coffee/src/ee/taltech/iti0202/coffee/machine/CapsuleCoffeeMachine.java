package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.water.WaterTank;

public class CapsuleCoffeeMachine extends CoffeeMachine{
    public CapsuleCoffeeMachine(WaterTank waterTank, int needToClean){
        super(waterTank, needToClean);
    }
}
