package ee.taltech.iti0202.computerstore.database;

import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductAlreadyExistsException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;


import java.math.BigDecimal;

import java.util.HashMap;

import java.util.Map;


public class Database {
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

    public void saveToFile(String location) {
    }

    public void loadFromFile(String location) {
    }


    public static void main(String[] args) throws ProductAlreadyExistsException {
        Database database = Database.getInstance();
        BigDecimal bigDecimal = new BigDecimal(100);
        Component component = new Component("b", Component.Type.CPU, bigDecimal, "f", 100, 100);
        Component component2 = new Component("a", Component.Type.CPU, bigDecimal, "f", 100, 100);
        database.saveComponent(component);
        database.saveComponent(component2);
    }

}