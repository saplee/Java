package ee.taltech.iti0202.coffee.tests;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.exceptions.CapsuleAlreadyInside;
import ee.taltech.iti0202.coffee.exceptions.EmptyWaterTankException;
import ee.taltech.iti0202.coffee.exceptions.GarbageContainerFull;
import ee.taltech.iti0202.coffee.exceptions.MachineException;
import ee.taltech.iti0202.coffee.machine.AutomaticCoffeeMachine;
import ee.taltech.iti0202.coffee.water.WaterTank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class AutomaticCoffeeMachineTest {
    @Test
    public void testCappuccino() throws MachineException, EmptyWaterTankException, GarbageContainerFull {
        WaterTank waterTank = new WaterTank(100);
        AutomaticCoffeeMachine automaticCoffeeMachine = new AutomaticCoffeeMachine(waterTank, 10);
        Map<String, Integer> map = new HashMap<>();
        map.put("coffeebeans", 3);
        Drink drink = new Drink(Drink.DrinkType.CAPPUCCINO, map);
        Assertions.assertEquals(Drink.DrinkType.CAPPUCCINO, automaticCoffeeMachine.start(drink));
    }

    @Test
    public void testLatte() throws MachineException, EmptyWaterTankException, GarbageContainerFull {
        WaterTank waterTank = new WaterTank(100);
        AutomaticCoffeeMachine automaticCoffeeMachine = new AutomaticCoffeeMachine(waterTank, 10);
        Map<String, Integer> map = new HashMap<>();
        map.put("coffeebeans", 3);
        map.put("milk", 1);
        Drink drink = new Drink(Drink.DrinkType.LATTE, map);
        Assertions.assertEquals(Drink.DrinkType.LATTE, automaticCoffeeMachine.start(drink));
    }

    @Test
    public void testCacao() throws MachineException, EmptyWaterTankException, GarbageContainerFull {
        WaterTank waterTank = new WaterTank(100);
        AutomaticCoffeeMachine automaticCoffeeMachine = new AutomaticCoffeeMachine(waterTank, 10);
        Map<String, Integer> map = new HashMap<>();
        map.put("cacao", 2);
        map.put("milk", 1);
        Drink drink = new Drink(Drink.DrinkType.CACAO, map);
        Assertions.assertEquals(Drink.DrinkType.CACAO, automaticCoffeeMachine.start(drink));
    }

    @Test
    public void testNoWater() throws MachineException, EmptyWaterTankException, GarbageContainerFull {
        WaterTank waterTank = new WaterTank(5);
        AutomaticCoffeeMachine automaticCoffeeMachine = new AutomaticCoffeeMachine(waterTank, 10);
        Map<String, Integer> map = new HashMap<>();
        map.put("cacao", 2);
        map.put("milk", 1);
        Drink drink = new Drink(Drink.DrinkType.CAPPUCCINO, map);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        Assertions.assertTrue(waterTank.noWaterInTank());
    }

    @Test
    public void testAlwaysBeans() throws MachineException, EmptyWaterTankException, GarbageContainerFull {
        WaterTank waterTank = new WaterTank(100);
        final int number = 20;
        AutomaticCoffeeMachine automaticCoffeeMachine = new AutomaticCoffeeMachine(waterTank, number);
        Map<String, Integer> map = new HashMap<>();
        map.put("coffeebeans", 3);
        Drink drink = new Drink(Drink.DrinkType.CAPPUCCINO, map);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        automaticCoffeeMachine.start(drink);
        Assertions.assertFalse(automaticCoffeeMachine.notEnoughCoffeeBeans(drink.getBeansAmount()));
    }

    @Test
    public void testMakeCoffeeNoWater() throws MachineException, GarbageContainerFull, EmptyWaterTankException, CapsuleAlreadyInside {
        final int number = 10;
        WaterTank waterTank = new WaterTank(1);
        // Making coffee machine
        AutomaticCoffeeMachine automaticCoffeeMachine = new AutomaticCoffeeMachine(waterTank, number);
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
            automaticCoffeeMachine.start(drink);
            automaticCoffeeMachine.start(drink1);
            Assertions.assertEquals(Drink.DrinkType.COFFEE, drink.getDrinkType());
        } catch (EmptyWaterTankException emptyWaterTankException) {
            Assertions.assertEquals("No water in tank!", emptyWaterTankException.getResult());
        }
    }

    @Test
    public void testMakeCoffeeGarbageContainerFull() throws MachineException, GarbageContainerFull,
            EmptyWaterTankException {
        WaterTank waterTank = new WaterTank(100);
        final int number = 4;
        // Making coffee machine
        AutomaticCoffeeMachine automaticCoffeeMachine = new AutomaticCoffeeMachine(waterTank, number);
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
            // Trying to make 6 coffee, but garbage container gets full after 4 drinks.
            automaticCoffeeMachine.start(drink);
            automaticCoffeeMachine.start(drink);
            automaticCoffeeMachine.start(drink);
            automaticCoffeeMachine.start(drink);
            automaticCoffeeMachine.start(drink);
            automaticCoffeeMachine.start(drink);
            Assertions.assertEquals(Drink.DrinkType.COFFEE, drink.getDrinkType());
        } catch (GarbageContainerFull garbageContainerFull) {
            Assertions.assertEquals("Garbage container is full!", garbageContainerFull.getResult());
        }
    }
}
