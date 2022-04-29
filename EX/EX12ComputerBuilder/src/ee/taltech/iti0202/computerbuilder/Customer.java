package ee.taltech.iti0202.computerbuilder;

import ee.taltech.iti0202.computerbuilder.components.Component;
import ee.taltech.iti0202.computerbuilder.computer.Computer;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private BigDecimal balance;
    private List<Computer> computers = new ArrayList<>();
    private List<Component> components = new ArrayList<>();

    public Customer(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
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

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public List<Component> getComponents() {
        return components;
    }
}
