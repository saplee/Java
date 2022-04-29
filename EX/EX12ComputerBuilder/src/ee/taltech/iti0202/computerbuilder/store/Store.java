package ee.taltech.iti0202.computerbuilder.store;

import ee.taltech.iti0202.computerbuilder.Customer;
import ee.taltech.iti0202.computerbuilder.components.Component;
import ee.taltech.iti0202.computerbuilder.computer.*;
import ee.taltech.iti0202.computerbuilder.database.Database;
import ee.taltech.iti0202.computerbuilder.exceptions.CannotBuildComputer;
import ee.taltech.iti0202.computerbuilder.exceptions.NotEnoughMoneyException;
import ee.taltech.iti0202.computerbuilder.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerbuilder.exceptions.ProductNotFoundException;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Store {
    private String name;
    private BigDecimal balance;
    private BigDecimal profitMargin;
    private Database database = Database.getInstance();

    public Store(String name, BigDecimal balance, BigDecimal profitMargin) {
        this.name = name;
        this.balance = balance;
        this.profitMargin = profitMargin;
        if (profitMargin.intValue() < 1) {
            throw new IllegalArgumentException();
        }
    }
    public Component purchaseComponent(int id, Customer customer) throws OutOfStockException,
            ProductNotFoundException,
            NotEnoughMoneyException {
        if (database.getComponents().containsKey(id) && ((database.getComponents().get(id).getPrice().intValue()
                * profitMargin.intValue()) > customer.getBalance().intValue())) {
            throw new NotEnoughMoneyException();
        } else {
            database.decreaseComponentStock(id, 1);
            customer.addComponent(database.getComponents().get(id));
            customer.setBalance(customer.getBalance().subtract(database.getComponents().get(id).getPrice()
                    .multiply(profitMargin)));
            this.setBalance(balance.add(database.getComponents().get(id).getPrice().multiply(profitMargin)));
            return database.getComponents().get(id);
        }
    }


    public List<Component> getAvailableComponents() {
        List<Component> componentList = database.getComponents().values().stream().toList();
        List<Component> result = new ArrayList<>();
        for (Component component : componentList) {
            if (component.getAmount() > 0) {
                result.add(component);
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Component getBestComponent(float maxPrice, Component.Type type) throws CannotBuildComputer {
        List<Component> bestComponents = getAvailableComponents().stream().filter(component -> component.getType().
                        equals(type)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList();
        if (bestComponents.size() == 0) {
            throw new CannotBuildComputer();
        } else {
            return bestComponents.get(0);
        }
    }

    public Component getPsu(float maxPrice, List<Component> components) throws CannotBuildComputer {
        List<Integer> integers = components.stream().map(Component::getPowerConsumption).toList();
        Integer sum = integers.stream().reduce(0, Integer::sum);
        List<Component> bestPsu = getAvailableComponents().stream().filter(component -> component.getType().
                        equals(Component.Type.PSU)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).filter(component -> component.getPowerConsumption() >= sum).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList();
        if (bestPsu.size() == 0) {
            throw new CannotBuildComputer();
        } else {
            return bestPsu.get(0);
        }
    }


    public Computer orderPc(ComputerType computerType, UseCase useCase, Customer customer) throws CannotBuildComputer {
        List<Component> result = new ArrayList<>();
        int budget = customer.getBalance().intValue();
        float gpuMaxPrice = 0;
        float cpuMaxPrice = 0;
        float psuMaxPrice = 0;
        float ramMaxPrice = 0;
        float caseMaxPrice = 0;
        float storageMaxPrice = 0;
        float motherboardMaxPrice = 0;
        float keyboardMaxPrice = 0;
        float screenMaxPrice = 0;
        if (computerType.equals(ComputerType.DESKTOP)) {
            if (useCase.equals(UseCase.GAMING)) {
                gpuMaxPrice = (float) (1. / 3. * budget);
                cpuMaxPrice = (float) (0.25 * budget);
                psuMaxPrice = (float) (1. / 12. * budget);
                ramMaxPrice = (float) (1.0 / 12.0 * budget);
                motherboardMaxPrice = (float) (1.0 / 12.0 * budget);
                caseMaxPrice = (float) (1.0 / 12.0 * budget);
                storageMaxPrice = (float) (1.0 / 12.0 * budget);
            } else if (useCase.equals(UseCase.WORK)) {
                gpuMaxPrice = (float) (1.0 / 4.0 * budget);
                cpuMaxPrice = (float) (1.0 / 3.0 * budget);
                psuMaxPrice = (float) (1.0 / 12.0 * budget);
                ramMaxPrice = (float) (1.0 / 12.0 * budget);
                motherboardMaxPrice = (float) (1.0 / 12.0 * budget);
                caseMaxPrice = (float) (1.0 / 12.0 * budget);
                storageMaxPrice = (float) (1.0 / 12.0 * budget);
            }
            result.add(getBestComponent(gpuMaxPrice, Component.Type.GPU));
            result.add(getBestComponent(cpuMaxPrice, Component.Type.CPU));
            result.add(getBestComponent(motherboardMaxPrice, Component.Type.MOTHERBOARD));
            result.add(getBestComponent(ramMaxPrice, Component.Type.RAM));
            result.add(getBestComponent(caseMaxPrice, Component.Type.CASE));
            result.add(getBestComponent(storageMaxPrice, Component.Type.HDD));
            result.add(getPsu(psuMaxPrice, result));
            return new Desktop(result);

        } else {
            if (useCase.equals(UseCase.WORK)) {
                gpuMaxPrice = (float) (1.0 / 4.0 * budget);
                cpuMaxPrice = (float) (1.0 / 3.0 * budget);
                psuMaxPrice = (float) (9.0 / 140.0 * budget);
                ramMaxPrice = (float) (9.0 / 140.0 * budget);
                motherboardMaxPrice = (float) (9.0 / 140.0 * budget);
                caseMaxPrice = (float) (9.0 / 140.0 * budget);
                storageMaxPrice = (float) (9.0 / 140.0 * budget);
            } else if (useCase.equals(UseCase.GAMING)) {
                gpuMaxPrice = (float) (1.0 / 3.0 * budget);
                cpuMaxPrice = (float) (1.0 / 4.0 * budget);
                psuMaxPrice = (float) (9.0 / 140.0 * budget);
                ramMaxPrice = (float) (9.0 / 140.0 * budget);
                motherboardMaxPrice = (float) (9.0 / 140.0 * budget);
                caseMaxPrice = (float) (9.0 / 140.0 * budget);
                storageMaxPrice = (float) (9.0 / 140.0 * budget);
                keyboardMaxPrice = (float) (9.0 / 140.0 * budget);
                screenMaxPrice = (float) (9.0 / 140.0 * budget);
            }
            result.add(getBestComponent(gpuMaxPrice, Component.Type.GPU));
            result.add(getBestComponent(cpuMaxPrice, Component.Type.CPU));
            result.add(getBestComponent(motherboardMaxPrice, Component.Type.MOTHERBOARD));
            result.add(getBestComponent(ramMaxPrice, Component.Type.RAM));
            result.add(getBestComponent(caseMaxPrice, Component.Type.CASE));
            result.add(getBestComponent(storageMaxPrice, Component.Type.HDD));
            result.add(getBestComponent(keyboardMaxPrice, Component.Type.KEYBOARD));
            result.add(getBestComponent(screenMaxPrice, Component.Type.SCREEN));
            result.add(getPsu(psuMaxPrice, result));
            return new Laptop(result);
        }
    }
}
