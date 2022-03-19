package ee.taltech.iti0202.coffee.tests;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;
import ee.taltech.iti0202.coffee.machine.MachineException;
import ee.taltech.iti0202.coffee.water.WaterTank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest {
    @Test
    public void testMakeCappuccino() throws MachineException {
        WaterTank waterTank = new WaterTank(100);
        CoffeeMachine coffeeMachine = new CoffeeMachine(waterTank, 50, 1000);
        Map<String, Integer> map = new HashMap<>();
        map.put("coffeebeans", 50);
        Drink drink = new Drink(Drink.DrinkType.CAPPUCCINO, map);
        assertEquals(Drink.DrinkType.CAPPUCCINO, coffeeMachine.start(drink));
    }

    @Test
    public void testMakeCoffee() throws MachineException {
        WaterTank waterTank = new WaterTank(100);
        CoffeeMachine coffeeMachine = new CoffeeMachine(waterTank, 50, 1000);
        Map<String, Integer> map = new HashMap<>();
        map.put("coffee beans", 50);
        Drink drink = new Drink(Drink.DrinkType.COFFEE, map);
        assertEquals(Drink.DrinkType.COFFEE, coffeeMachine.start(drink));

    }

    @Test
    public void testMakeCoffee2() throws MachineException {
        WaterTank waterTank = new WaterTank(100);
        CoffeeMachine coffeeMachine = new CoffeeMachine(waterTank, 50, 0);
        Map<String, Integer> map = new HashMap<>();
        map.put("coffee beans", 50);
        Drink drink = new Drink(Drink.DrinkType.COFFEE, map);
        try {
            // Trying to add garbage to full garbage container.
            coffeeMachine.start(drink);
            assertEquals(Drink.DrinkType.COFFEE, drink.getDrinkType());
        } catch (MachineException machineException) {
            assertEquals("Can't make this drink!", machineException.getResult());
        }
    }
}