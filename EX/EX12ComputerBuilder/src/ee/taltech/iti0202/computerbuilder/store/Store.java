package ee.taltech.iti0202.computerbuilder.store;

import ee.taltech.iti0202.computerbuilder.Customer;
import ee.taltech.iti0202.computerbuilder.components.Component;

import ee.taltech.iti0202.computerbuilder.database.Database;

import ee.taltech.iti0202.computerbuilder.exceptions.NotEnoughMoneyException;
import ee.taltech.iti0202.computerbuilder.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerbuilder.exceptions.ProductNotFoundException;


import java.math.BigDecimal;
import java.util.ArrayList;

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
}
