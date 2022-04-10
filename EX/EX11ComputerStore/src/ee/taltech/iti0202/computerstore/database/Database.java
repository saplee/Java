package ee.taltech.iti0202.computerstore.database;

import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductAlreadyExistsException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Database {
    private HashMap<Component, Integer> components = new HashMap<>();
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
        if (components.containsKey(component)) {
            throw new ProductAlreadyExistsException();
        } else {
            components.put(component, 1);
        }
    }

    public void deleteComponent(int id) throws ProductNotFoundException {
        int startSize = components.size();
        for (Component component : components.keySet()) {
            if (component.getId() == id) {
                components.remove(component);
            }

        }
        if (components.size() == startSize) {
            throw new ProductNotFoundException();
        }
    }

    public void increaseComponentStock(int id, int amount) throws ProductNotFoundException {
        boolean componentIncreased = false;
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        for (Component component : components.keySet()) {
            if (component.getId() == id) {
                components.put(component, components.get(component) + amount);
                component.setAmount(components.get(component));
                componentIncreased = true;
            }
        }
        if (!componentIncreased) {
            throw new ProductNotFoundException();
        }
    }

    public void decreaseComponentStock(int id, int amount) throws OutOfStockException, ProductNotFoundException {
        boolean componentDecreased = false;
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        for (Component component : components.keySet()) {
            if (component.getId() == id && components.get(component) >= amount) {
                components.put(component, components.get(component) + amount);
                componentDecreased = true;
            } else if (component.getId() == id && components.get(component) < amount) {
                throw new OutOfStockException();
            }
        }
        if (!componentDecreased) {
            throw new ProductNotFoundException();
        }
    }

    public Map<Integer, Component> getComponents() {
        return components.entrySet().stream().collect(Collectors.toMap(HashMap.Entry::getValue, HashMap.Entry::getKey));
    }

    public void resetEntireDatabase() {
        components.clear();
        Component.setAndIncrementNextId();
    }

    public void saveToFile(String location) {
    }

    public void loadFromFile(String location) {
    }
}
