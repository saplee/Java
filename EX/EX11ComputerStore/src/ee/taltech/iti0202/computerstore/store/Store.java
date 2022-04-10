package ee.taltech.iti0202.computerstore.store;

import ee.taltech.iti0202.computerstore.Customer;
import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.database.Database;
import ee.taltech.iti0202.computerstore.exceptions.NotEnoughMoneyException;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.math.BigDecimal;
import java.util.stream.Collectors;


public class Store {
    private String name;
    private BigDecimal balance;
    private BigDecimal profitMargin;
    private Database database = Database.getInstance();
    private List<Component> componentList = database.getComponents().values().stream().toList();

    public Store(String name, BigDecimal balance, BigDecimal profitMargin) {
        this.name = name;
        this.balance = balance;
        this.profitMargin = profitMargin;
    }

    public Component purchaseComponent(int id, Customer customer) throws OutOfStockException,
            ProductNotFoundException,
            NotEnoughMoneyException {
        if (database.getComponents().containsKey(id) && ((database.getComponents().get(id).getPrice().intValue() * profitMargin.intValue()) > customer.getBalance().intValue()))
        {
            throw new NotEnoughMoneyException();
        }
        database.decreaseComponentStock(id, 1);
        return database.getComponents().get(id);
    }

    public List<Component> getAvailableComponents() {
        List<Component> result = new ArrayList<>();
        for (Component component:componentList){
            if (component.getAmount()>0){
                result.add(component);
            }
        }
        return result;
    }

    public List<Component> getComponentsSortedByAmount() {
        return null;
    }

    public List<Component> getComponentsSortedByName() {
        List<Component> sortedByName = getAvailableComponents().stream()
                .sorted(Comparator.comparing(Component::getName))
                .collect(Collectors.toList());
        return sortedByName;
    }

    public List<Component> getComponentsSortedByPrice() {
        return null;
    }

    public List<Component> filterByType(Component.Type type) {
        return null;
    }

    public BigDecimal getInventoryValue() {
        return BigDecimal.ZERO;
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
}