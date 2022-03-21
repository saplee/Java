package ee.taltech.iti0202.coffee.kitchen;

import ee.taltech.iti0202.coffee.drinks.Drink;
import ee.taltech.iti0202.coffee.exceptions.CapsuleAlreadyInside;
import ee.taltech.iti0202.coffee.exceptions.EmptyWaterTankException;
import ee.taltech.iti0202.coffee.exceptions.GarbageContainerFull;
import ee.taltech.iti0202.coffee.exceptions.MachineException;

import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Kitchen {
    private List<CoffeeMachine> coffeeMachines = new ArrayList<>();
    private static Logger LOGGER = Logger.getLogger(Kitchen.class.getName());

    /**
     *
     */
    public Kitchen() {
    }

    public void addCoffeeMachine(CoffeeMachine coffeeMachine) {
        if (!coffeeMachines.contains(coffeeMachine)) {
            coffeeMachines.add(coffeeMachine);
        }
    }

    public List<CoffeeMachine> getCoffeeMachines() {
        return coffeeMachines;
    }




    public Drink.DrinkType makeDrink(Drink drink, CoffeeMachine coffeeMachine) throws MachineException, EmptyWaterTankException, GarbageContainerFull, CapsuleAlreadyInside {
        return coffeeMachine.start(drink);
    }
}
