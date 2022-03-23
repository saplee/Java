package ee.taltech.iti0202.coffee.tests;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.exceptions.CapsuleAlreadyInside;
import ee.taltech.iti0202.coffee.exceptions.EmptyWaterTankException;
import ee.taltech.iti0202.coffee.exceptions.GarbageContainerFull;
import ee.taltech.iti0202.coffee.exceptions.MachineException;
import ee.taltech.iti0202.coffee.kitchen.Kitchen;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;
import ee.taltech.iti0202.coffee.machine.CoffeeMachineBuilder;
import ee.taltech.iti0202.coffee.water.WaterTank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class KitchenTest {
    @Test
    public void testMakeCoffee() throws MachineException, EmptyWaterTankException, GarbageContainerFull,
            CapsuleAlreadyInside, IOException {
        Kitchen kitchen = new Kitchen();
        final int number = 10;
        WaterTank waterTank = new WaterTank(100);
        // Making coffee machine
        CoffeeMachine coffeeMachine = new CoffeeMachineBuilder().setWaterTank(waterTank).setNeedToCleanNumber(number)
                .setCoffeeBeans(1000).createCoffeeMachine();
        Map<String, Integer> map = new HashMap<>();
        // Making drink recipe, Coffee machine can only make drinks with coffee beans.
        map.put("coffee beans", 1);
        // Making drink with drink Type and recipe
        kitchen.addCoffeeMachine(coffeeMachine);
        Drink drink = new Drink(Drink.DrinkType.COFFEE, map);
        Assertions.assertEquals(Drink.DrinkType.COFFEE, kitchen.makeDrink(drink, coffeeMachine));
    }
}
