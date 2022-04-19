package ee.taltech.iti0202.computerbuilder.store;

import ee.taltech.iti0202.computerbuilder.Customer;
import ee.taltech.iti0202.computerbuilder.components.Component;
import ee.taltech.iti0202.computerbuilder.computer.Computer;
import ee.taltech.iti0202.computerbuilder.computer.ComputerType;
import ee.taltech.iti0202.computerbuilder.computer.UseCase;
import ee.taltech.iti0202.computerbuilder.database.Database;
import ee.taltech.iti0202.computerbuilder.exceptions.CannotBuildComputer;
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

    public void purchaseComponent(int id, Customer customer) throws OutOfStockException, ProductNotFoundException {
        database.decreaseComponentStock(id, 1);
        customer.setBalance(customer.getBalance().subtract(database.getComponents().get(id).getPrice()));
        this.setBalance(balance.add(database.getComponents().get(id).getPrice()));
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

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(BigDecimal profitMargin) {
        if (1 > profitMargin.intValue()) {
            throw new IllegalArgumentException();
        } else {
            this.profitMargin = profitMargin;
        }
    }

    public Component getBestGpu(Customer customer, float maxPrice) {
        return getAvailableComponents().stream().filter(component -> component.getType().
                        equals(Component.Type.GPU)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList().get(0);
    }

    public Component getBestCpu(Customer customer, float maxPrice) {
        return getAvailableComponents().stream().filter(component -> component.getType().
                        equals(Component.Type.CPU)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList().get(0);
    }

    public Component getBestPsu(Customer customer, float maxPrice) {
        return getAvailableComponents().stream().filter(component -> component.getType().
                        equals(Component.Type.PSU)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList().get(0);
    }

    public Component getBestRam(Customer customer, float maxPrice) {
        return getAvailableComponents().stream().filter(component -> component.getType().
                        equals(Component.Type.RAM)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList().get(0);
    }

    public Component getBestMotherboard(Customer customer, float maxPrice) {
        return getAvailableComponents().stream().filter(component -> component.getType().
                        equals(Component.Type.MOTHERBOARD)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList().get(0);
    }

    public Component getBestCase(Customer customer, float maxPrice) {
        return getAvailableComponents().stream().filter(component -> component.getType().
                        equals(Component.Type.CASE)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList().get(0);
    }

    public Component getBestStorage(Customer customer, float maxPrice) {
        return getAvailableComponents().stream().filter(component -> component.getType().
                        equals(Component.Type.HDD)).filter(component -> component.getPrice().
                        floatValue() <= maxPrice).toList().stream()
                .sorted(Comparator.comparing(Component::getPerformancePoints).reversed()).toList().get(0);
    }

    public Computer order(ComputerType computerType, UseCase useCase, Customer customer) throws CannotBuildComputer {
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
        if (computerType.equals(ComputerType.DESKTOP) && useCase.equals(UseCase.GAMING)) {
            gpuMaxPrice = (float) (1. / 3. * budget);
            cpuMaxPrice = (float) (0.25 * budget);
            psuMaxPrice = (float) (1. / 12. * budget);
            ramMaxPrice = (float) (1.0 / 12.0 * budget);
            motherboardMaxPrice = (float) (1.0 / 12.0 * budget);
            caseMaxPrice = (float) (1.0 / 12.0 * budget);
            storageMaxPrice = (float) (1.0 / 12.0 * budget);
            result.add(getBestGpu(customer, gpuMaxPrice));
            result.add(getBestCpu(customer, cpuMaxPrice));
            result.add(getBestMotherboard(customer, motherboardMaxPrice));
            result.add(getBestRam(customer, ramMaxPrice));
            result.add(getBestPsu(customer, psuMaxPrice));
            result.add(getBestCase(customer, caseMaxPrice));
            result.add(getBestStorage(customer, storageMaxPrice));
        } else if (computerType.equals(ComputerType.DESKTOP) && useCase.equals(UseCase.WORK)) {
            gpuMaxPrice = (float) (1.0 / 4.0 * budget);
            cpuMaxPrice = (float) (1.0 / 3.0 * budget);
            psuMaxPrice = (float) (1. / 12. * budget);
            ramMaxPrice = (float) (1.0 / 12.0 * budget);
            motherboardMaxPrice = (float) (1.0 / 12.0 * budget);
            caseMaxPrice = (float) (1.0 / 12.0 * budget);
            storageMaxPrice = (float) (1.0 / 12.0 * budget);
            result.add(getBestGpu(customer, gpuMaxPrice));
            result.add(getBestCpu(customer, cpuMaxPrice));
            result.add(getBestMotherboard(customer, motherboardMaxPrice));
            result.add(getBestRam(customer, ramMaxPrice));
            result.add(getBestPsu(customer, psuMaxPrice));
            result.add(getBestCase(customer, caseMaxPrice));
            result.add(getBestStorage(customer, storageMaxPrice));
        }
        Computer computer = new Computer(result);
        customer.addComputer(computer);
        return computer;
    }
}
