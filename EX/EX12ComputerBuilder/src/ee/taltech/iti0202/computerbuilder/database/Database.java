package ee.taltech.iti0202.computerbuilder.database;



import ee.taltech.iti0202.computerbuilder.components.Component;
import ee.taltech.iti0202.computerbuilder.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerbuilder.exceptions.ProductAlreadyExistsException;
import ee.taltech.iti0202.computerbuilder.exceptions.ProductNotFoundException;

import java.util.HashMap;
import java.util.Map;


public final class Database {
    private HashMap<Integer, Component> components = new HashMap<>();
    private static Database instance = null;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void saveComponent(Component component) throws ProductAlreadyExistsException {
        if (components.containsKey(component.getId())) {
            throw new ProductAlreadyExistsException();
        } else {
            components.put(component.getId(), component);
        }
    }

    public void deleteComponent(int id) throws ProductNotFoundException {
        if (!components.containsKey(id)) {
            throw new ProductNotFoundException();
        } else if (components.containsKey(id)) {
            components.remove(id);
        }
    }

    public void increaseComponentStock(int id, int amount) throws ProductNotFoundException {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        } else if (!components.containsKey(id)) {
            throw new ProductNotFoundException();
        } else if (components.containsKey(id)) {
            components.get(id).setAmount(components.get(id).getAmount() + amount);
        }
    }

    public void decreaseComponentStock(int id, int amount) throws OutOfStockException, ProductNotFoundException {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        } else if (!components.containsKey(id)) {
            throw new ProductNotFoundException();
        } else if (components.containsKey(id) && components.get(id).getAmount() < amount) {
            throw new OutOfStockException();
        } else if (components.containsKey(id) && components.get(id).getAmount() >= amount) {
            components.get(id).setAmount(components.get(id).getAmount() - amount);
        }
    }

    public Map<Integer, Component> getComponents() {
        return components;
    }

    public void resetEntireDatabase() {
        components.clear();
        Component.setAndIncrementNextId();
    }
}
