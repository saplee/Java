package ee.taltech.iti0202.computerstore.database;

import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductAlreadyExistsException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Database {
    private Map<Integer, Component> components = new HashMap<>();
    private Map<Component, Integer> components2 = new HashMap<>();
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
        if (components2.containsKey(component)) {
            throw new ProductAlreadyExistsException();
        } else {
            components2.put(component, 1);
            components.put(1, component);
        }
    }

    public void deleteComponent(int id) throws ProductNotFoundException {
        int startSize = components.size();
        for (Component component : components2.keySet()) {
            if (component.getId() == id) {
                components2.remove(component);
                for (Integer component2 : components.keySet()) {
                    if (components.get(component2).getId() == id) {
                        components.remove(component2);
                    }
                }
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
        for (Component component : components2.keySet()) {
            if (component.getId() == id) {
                components2.put(component, components2.get(component) + amount);
                component.setAmount(components2.get(component));
                componentIncreased = true;
                for (Integer component2 : components.keySet()) {
                    if (components.get(component2).getId() == id) {
                        components.put(component2 + amount, components.get(component2));
                        components.remove(component2);
                    }
                }
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
        for (Component component : components2.keySet()) {
            if (component.getId() == id && components2.get(component) >= amount) {
                components2.put(component, components2.get(component) + amount);
                componentDecreased = true;
            } else if (component.getId() == id && components2.get(component) < amount) {
                throw new OutOfStockException();
            }
        }
        if (!componentDecreased) {
            throw new ProductNotFoundException();
        }
    }

    public Map<Integer, Component> getComponents() {
        return components;
    }

    public void resetEntireDatabase() {
        components.clear();
        components2.clear();
        Component.setAndIncrementNextId();
    }

    public void saveToFile(String location) {
    }

    public void loadFromFile(String location) {
    }
}
