package ee.taltech.iti0202.computerstore.database;

import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductAlreadyExistsException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
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

    public void saveToFile(String location) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        Path path = Paths.get(location);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            gson.toJson(this, writer);
        } catch (IOException i) {
        }
    }

    public void loadFromFile(String location) {
        Gson gson = new Gson();
        Path path = Paths.get(location);
        instance.resetEntireDatabase();
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            instance = gson.fromJson(reader.readLine(), Database.class);
        } catch (IOException i) {
        }
    }
}
