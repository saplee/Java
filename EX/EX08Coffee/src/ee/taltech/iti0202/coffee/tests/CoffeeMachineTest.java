package ee.taltech.iti0202.coffee.tests;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.exceptions.CapsuleAlreadyInside;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;
import ee.taltech.iti0202.coffee.exceptions.EmptyWaterTankException;
import ee.taltech.iti0202.coffee.exceptions.GarbageContainerFull;
import ee.taltech.iti0202.coffee.exceptions.MachineException;
import ee.taltech.iti0202.coffee.machine.CoffeeMachineBuilder;
import ee.taltech.iti0202.coffee.water.WaterTank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class CoffeeMachineTest {
    @Test
    public void testMakeCappuccino() throws MachineException, EmptyWaterTankException, GarbageContainerFull,
            CapsuleAlreadyInside, IOException {
        final int number = 10;
        WaterTank waterTank = new WaterTank(100);
        CoffeeMachine coffeeMachine = new CoffeeMachineBuilder().setWaterTank(waterTank).setNeedToCleanNumber(number)
                .setCoffeeBeans(1000).createCoffeeMachine();
        Map<String, Integer> map = new HashMap<>();
        map.put("coffeebeans", 3);
        Drink drink = new Drink(Drink.DrinkType.CAPPUCCINO, map);
        Assertions.assertEquals(Drink.DrinkType.CAPPUCCINO, coffeeMachine.start(drink));
    }

    @Test
    public void testMakeCoffee() throws MachineException, EmptyWaterTankException, GarbageContainerFull,
            CapsuleAlreadyInside, IOException {
        final int number = 10;
        WaterTank waterTank = new WaterTank(100);
        // Making coffee machine
        CoffeeMachine coffeeMachine = new CoffeeMachineBuilder().setWaterTank(waterTank).setNeedToCleanNumber(number)
                .setCoffeeBeans(1000).createCoffeeMachine();
        Map<String, Integer> map = new HashMap<>();
        // Making drink recipe, Coffee machine can only make drinks with coffee beans.
        map.put("coffee beans", 1);
        // Making drink with drink Type and recipe
        Drink drink = new Drink(Drink.DrinkType.COFFEE, map);
        Assertions.assertEquals(Drink.DrinkType.COFFEE, coffeeMachine.start(drink));

    }

    @Test
    public void testMakeCoffeeNoWater() throws MachineException, GarbageContainerFull, EmptyWaterTankException,
            CapsuleAlreadyInside, IOException {
        final int number = 10;
        WaterTank waterTank = new WaterTank(1);
        // Making coffee machine
        CoffeeMachine coffeeMachine = new CoffeeMachineBuilder().setWaterTank(waterTank).setNeedToCleanNumber(number)
                .setCoffeeBeans(100).createCoffeeMachine();
        Map<String, Integer> map = new HashMap<>();
        // Making drink recipe, Coffee machine can only make drinks with coffee beans.
        map.put("coffee beans", 1);
        Map<String, Integer> map2 = new HashMap<>();
        // Making drink recipe, Coffee machine can only make drinks with coffee beans.
        map2.put("coffee beans", 3);
        // Making drink with drink Type and recipe
        Drink drink1 = new Drink(Drink.DrinkType.CAPPUCCINO, map2);
        // Making drink with drink Type and recipe
        Drink drink = new Drink(Drink.DrinkType.COFFEE, map);
        try {
            // Trying to make coffee, but no water in tank.
            coffeeMachine.start(drink);
            coffeeMachine.start(drink1);
            Assertions.assertEquals(Drink.DrinkType.COFFEE, drink.getDrinkType());
        } catch (EmptyWaterTankException emptyWaterTankException) {
            Assertions.assertEquals("No water in tank!", emptyWaterTankException.getResult());
        }
    }

    @Test
    public void testMakeCoffeeGarbageContainerFull() throws MachineException, GarbageContainerFull,
            EmptyWaterTankException, CapsuleAlreadyInside, IOException {
        WaterTank waterTank = new WaterTank(100);
        // Making coffee machine
        CoffeeMachine coffeeMachine = new CoffeeMachineBuilder().setWaterTank(waterTank).setCoffeeBeans(100)
                .createCoffeeMachine();
        Map<String, Integer> map = new HashMap<>();
        // Making drink recipe, Coffee machine can only make drinks with coffee beans.
        map.put("coffee beans", 1);
        // Making drink with drink Type and recipe
        Drink drink = new Drink(Drink.DrinkType.COFFEE, map);
        try {
            // Trying to make 6 coffee, but garbage container gets full after 5 drinks.
            coffeeMachine.start(drink);
            coffeeMachine.start(drink);
            coffeeMachine.start(drink);
            coffeeMachine.start(drink);
            coffeeMachine.start(drink);
            coffeeMachine.start(drink);
            Assertions.assertEquals(Drink.DrinkType.COFFEE, drink.getDrinkType());
        } catch (GarbageContainerFull garbageContainerFull) {
            Assertions.assertEquals("Garbage container is full!", garbageContainerFull.getResult());
        }
    }

    @Test
    public void testMakeCoffeeGarbageContainerCleaning() throws MachineException, GarbageContainerFull,
            EmptyWaterTankException, CapsuleAlreadyInside, IOException {
        WaterTank waterTank = new WaterTank(100);
        // Making coffee machine
        CoffeeMachine coffeeMachine = new CoffeeMachineBuilder().setWaterTank(waterTank).setCoffeeBeans(100)
                .createCoffeeMachine();
        Map<String, Integer> map = new HashMap<>();
        // Making drink recipe, Coffee machine can only make drinks with coffee beans.
        map.put("coffee beans", 1);
        Map<String, Integer> map2 = new HashMap<>();
        // Making drink recipe, Coffee machine can only make drinks with coffee beans.
        map2.put("coffee beans", 3);
        // Making drink with drink Type and recipe
        Drink drink = new Drink(Drink.DrinkType.COFFEE, map);
        Drink drink1 = new Drink(Drink.DrinkType.CAPPUCCINO, map2);
        // Trying to make many drinks and cleaning machine after 5 drink.
        // Returns CAPPUCCINO
        coffeeMachine.start(drink);
        coffeeMachine.start(drink);
        coffeeMachine.start(drink);
        coffeeMachine.start(drink);
        coffeeMachine.start(drink);
        coffeeMachine.cleanCoffeeMachine();
        coffeeMachine.start(drink1);
        Assertions.assertEquals(Drink.DrinkType.CAPPUCCINO, drink1.getDrinkType());

    }

    @Test
    public void testMakeCoffeeAddingWater() throws MachineException, GarbageContainerFull,
            EmptyWaterTankException, CapsuleAlreadyInside, IOException {
        final int number = 6;
        WaterTank waterTank = new WaterTank(3);
        // Making coffee machine
        CoffeeMachine coffeeMachine = new CoffeeMachineBuilder().setWaterTank(waterTank).setNeedToCleanNumber(number)
                .setCoffeeBeans(100).createCoffeeMachine();
        Map<String, Integer> map = new HashMap<>();
        // Making drink recipe, Coffee machine can only make drinks with coffee beans.
        map.put("coffee beans", 1);
        Map<String, Integer> map2 = new HashMap<>();
        // Making drink recipe, Coffee machine can only make drinks with coffee beans.
        map2.put("coffee beans", 4);
        // Making drink with drink Type and recipe
        Drink drink = new Drink(Drink.DrinkType.COFFEE, map);
        Drink drink1 = new Drink(Drink.DrinkType.CAPPUCCINO, map2);
        // Trying to make many drinks and adding water to water tank
        coffeeMachine.start(drink);
        coffeeMachine.start(drink);
        coffeeMachine.start(drink);
        waterTank.addWaterToTank();
        coffeeMachine.start(drink);
        coffeeMachine.start(drink);
        coffeeMachine.start(drink1);
        Assertions.assertEquals(Drink.DrinkType.CAPPUCCINO, drink1.getDrinkType());

    }

    @Test
    public void testMakeCoffeeButNotEnoughBeans() throws MachineException, GarbageContainerFull,
            EmptyWaterTankException, CapsuleAlreadyInside, IOException {
        WaterTank waterTank = new WaterTank(3);
        // Making coffee machine
        CoffeeMachine coffeeMachine = new CoffeeMachineBuilder().setWaterTank(waterTank).setCoffeeBeans(0)
                .createCoffeeMachine();
        Map<String, Integer> map = new HashMap<>();
        // Making drink recipe, Coffee machine can only make drinks with coffee beans.
        map.put("coffee beans", 1);
        // Making drink with drink Type and recipe
        Drink drink = new Drink(Drink.DrinkType.COFFEE, map);
        try {
            // Trying to make drink but not enough beans.
            coffeeMachine.start(drink);
            Assertions.assertEquals(Drink.DrinkType.COFFEE, drink.getDrinkType());
        } catch (MachineException machineException) {
            Assertions.assertEquals("Can't make this drink!", machineException.getResult());
        }
    }

    @Test
    public void testMakeCoffeeButNotEnoughBeansButAdding() throws MachineException, GarbageContainerFull,
            EmptyWaterTankException, CapsuleAlreadyInside, IOException {
        WaterTank waterTank = new WaterTank(3);
        // Making coffee machine
        CoffeeMachine coffeeMachine = new CoffeeMachineBuilder().setWaterTank(waterTank).setCoffeeBeans(0)
                .createCoffeeMachine();
        Map<String, Integer> map = new HashMap<>();
        // Making drink recipe, Coffee machine can only make drinks with coffee beans.
        map.put("coffee beans", 1);
        // Making drink with drink Type and recipe
        Drink drink = new Drink(Drink.DrinkType.COFFEE, map);
        // Trying to make drink and adding beans.
        coffeeMachine.addCoffeeBeans(10);
        coffeeMachine.start(drink);
        Assertions.assertEquals(Drink.DrinkType.COFFEE, drink.getDrinkType());
        }
}
