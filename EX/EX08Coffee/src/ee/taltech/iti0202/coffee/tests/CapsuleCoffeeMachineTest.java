package ee.taltech.iti0202.coffee.tests;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.exceptions.CapsuleAlreadyInside;
import ee.taltech.iti0202.coffee.exceptions.EmptyWaterTankException;
import ee.taltech.iti0202.coffee.exceptions.GarbageContainerFull;
import ee.taltech.iti0202.coffee.exceptions.MachineException;
import ee.taltech.iti0202.coffee.machine.CapsuleCoffeeMachine;
import ee.taltech.iti0202.coffee.machine.CapsuleCoffeeMachineBuilder;
import ee.taltech.iti0202.coffee.water.WaterTank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CapsuleCoffeeMachineTest {
    @Test
    public void testMakeCapsuleCappuccino() throws MachineException, EmptyWaterTankException,
            GarbageContainerFull, CapsuleAlreadyInside, IOException {
        WaterTank waterTank = new WaterTank(100);
        CapsuleCoffeeMachine capsuleCoffeeMachine = new CapsuleCoffeeMachineBuilder().setWaterTank(waterTank)
                .createCapsuleCoffeeMachine();
        Drink drink = new Drink(Drink.DrinkType.CAPPUCCINO);
        Assertions.assertEquals(Drink.DrinkType.CAPPUCCINO, capsuleCoffeeMachine.start(drink));
    }

    @Test
    public void testMakeCapsuleMachineMakesHotWater() throws MachineException, EmptyWaterTankException,
            GarbageContainerFull, CapsuleAlreadyInside, IOException {
        WaterTank waterTank = new WaterTank(100);
        CapsuleCoffeeMachine capsuleCoffeeMachine = new CapsuleCoffeeMachineBuilder().setWaterTank(waterTank)
                .createCapsuleCoffeeMachine();
        Drink drink = new Drink(null);
        Assertions.assertEquals(Drink.DrinkType.WATER, capsuleCoffeeMachine.start(drink));
    }

    @Test
    public void testMakeCapsuleMachineNoWater() throws MachineException, EmptyWaterTankException,
            GarbageContainerFull, CapsuleAlreadyInside, IOException {
        WaterTank waterTank = new WaterTank(5);
        CapsuleCoffeeMachine capsuleCoffeeMachine = new CapsuleCoffeeMachineBuilder().setWaterTank(waterTank)
                .createCapsuleCoffeeMachine();
        Drink drink = new Drink(Drink.DrinkType.CAPPUCCINO);
        Drink drink1 = new Drink(Drink.DrinkType.LATTE);
        capsuleCoffeeMachine.start(drink);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink);
        capsuleCoffeeMachine.takeCapsuleOut();
        try {
            //Trying to make drink, but not enough water.
            capsuleCoffeeMachine.start(drink1);
        } catch (EmptyWaterTankException emptyWaterTankException) {
            Assertions.assertEquals("No water in tank!", emptyWaterTankException.getResult());
        }
    }

    @Test
    public void testCapsuleAlreadyInside() throws MachineException, EmptyWaterTankException, GarbageContainerFull,
            CapsuleAlreadyInside, IOException {
        WaterTank waterTank = new WaterTank(5);
        CapsuleCoffeeMachine capsuleCoffeeMachine = new CapsuleCoffeeMachineBuilder().setWaterTank(waterTank)
                .createCapsuleCoffeeMachine();
        Drink drink = new Drink(Drink.DrinkType.CAPPUCCINO);
        Drink drink1 = new Drink(Drink.DrinkType.LATTE);
        capsuleCoffeeMachine.start(drink);
        try {
            //Trying to make new drink, but capsule is already inside and can't put new in.
            capsuleCoffeeMachine.start(drink1);
        } catch (CapsuleAlreadyInside capsuleAlreadyInside) {
            Assertions.assertEquals("Capsule is already inside!", capsuleAlreadyInside.getResult());
        }
    }

    @Test
    public void testCapsuleMachineGarbageContainerFull() throws MachineException, EmptyWaterTankException,
            GarbageContainerFull,
            CapsuleAlreadyInside, IOException {
        final int number = 20;
        WaterTank waterTank = new WaterTank(number);
        CapsuleCoffeeMachine capsuleCoffeeMachine = new CapsuleCoffeeMachineBuilder().setWaterTank(waterTank)
                .createCapsuleCoffeeMachine();
        Drink drink = new Drink(Drink.DrinkType.CAPPUCCINO);
        Drink drink1 = new Drink(Drink.DrinkType.LATTE);
        Drink drink2 = new Drink(Drink.DrinkType.CACAO);
        capsuleCoffeeMachine.start(drink);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink1);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink1);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink1);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink1);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink);
        capsuleCoffeeMachine.takeCapsuleOut();
        capsuleCoffeeMachine.start(drink1);
        capsuleCoffeeMachine.takeCapsuleOut();
        try {
            // Trying to make many drinks, but no garbage container is full after 10 drinks.
            capsuleCoffeeMachine.start(drink2);
        } catch (GarbageContainerFull garbageContainerFull) {
            Assertions.assertEquals("Garbage container is full!", garbageContainerFull.getResult());
        }
    }
}
