package ee.taltech.iti0202.coffee.kitchen;

import ee.taltech.iti0202.coffee.logger.Logging;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Kitchen {
    private List<CoffeeMachine> coffeeMachines = new ArrayList<>();
    private static Logger LOGGER = Logger.getLogger(Logging.class.getName());

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

}
