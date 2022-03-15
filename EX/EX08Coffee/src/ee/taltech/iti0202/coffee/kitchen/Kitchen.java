package ee.taltech.iti0202.coffee.kitchen;

import ee.taltech.iti0202.coffee.drinks.Drinks;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {
    private List<CoffeeMachine> coffeeMachines = new ArrayList<>();

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

    public boolean canMakeCoffee(CoffeeMachine coffeeMachine, Drinks drink) {
        return true;
    }
}
