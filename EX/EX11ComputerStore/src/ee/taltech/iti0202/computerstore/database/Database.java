package ee.taltech.iti0202.computerstore.database;

import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductAlreadyExistsException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Database {
    private final Map<Component, Integer> components = new HashMap<>();


    public static Database getInstance() {
        return null;
    }

    public void saveComponent(Component component) throws ProductAlreadyExistsException {
        if (!components.containsKey(component)) {
            components.put(component, 1);
        } else {
            throw new ProductAlreadyExistsException();
        }
    }

    public void deleteComponent(int id) throws ProductNotFoundException {
        for (Component component: components.keySet()){
            if (component.getId() == id){
                components.remove(component);
            }else {
                throw new ProductNotFoundException();
            }
        }
    }

    public void increaseComponentStock(int id, int amount) throws ProductNotFoundException {
    }

    public void decreaseComponentStock(int id, int amount) throws OutOfStockException, ProductNotFoundException {
    }

    public Map<Integer, Component> getComponents() {
        return components.entrySet().stream().collect(Collectors.toMap(HashMap.Entry::getValue, HashMap.Entry::getKey));
    }

    public void resetEntireDatabase() {
    }

    public void saveToFile(String location) {
    }

    public void loadFromFile(String location) {
    }
}
