package ee.taltech.iti0202.computerbuilder.tests;

import ee.taltech.iti0202.computerbuilder.Customer;
import ee.taltech.iti0202.computerbuilder.components.Component;
import ee.taltech.iti0202.computerbuilder.database.Database;
import ee.taltech.iti0202.computerbuilder.exceptions.NotEnoughMoneyException;
import ee.taltech.iti0202.computerbuilder.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerbuilder.exceptions.ProductAlreadyExistsException;
import ee.taltech.iti0202.computerbuilder.exceptions.ProductNotFoundException;
import ee.taltech.iti0202.computerbuilder.store.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class StoreTest {
    private Database database;
    private Customer customer;
    private Component component;
    private Component component1;
    private Component component2;
    private Component component3;
    private Component component4;
    private Component component5;
    private Component component6;
    private Component component7;
    private Component component8;
    private Component component9;
    private Component component10;
    private Component component11;
    private Component component12;
    private Component component13;
    private Component component14;
    private Component component15;
    private Component component16;
    private Component component17;
    private Component component18;

    @BeforeEach
    void setUp() throws ProductAlreadyExistsException {
        customer = new Customer("Alex", BigDecimal.valueOf(1500));
        database = Database.getInstance();
        component = new Component("i5", Component.Type.CPU, BigDecimal.valueOf(150), "Intel",
                100, 90);
        component1 = new Component("Gtx 1070", Component.Type.GPU, BigDecimal.valueOf(220),
                "MSI", 150, 220);
        component2 = new Component("B365", Component.Type.MOTHERBOARD, BigDecimal.valueOf(68),
                "MSI", 150, 20);
        component3 = new Component("1TB", Component.Type.HDD, BigDecimal.valueOf(68),
                "Toshiba", 150, 20);
        component4 = new Component("RGB CASE", Component.Type.CASE, BigDecimal.valueOf(44),
                "MSI", 100, 0);
        component5 = new Component("8GB", Component.Type.RAM, BigDecimal.valueOf(77),
                "HyperX", 99, 10);
        component6 = new Component("1TB", Component.Type.PSU, BigDecimal.valueOf(77),
                "Corsair", 100, 450);
        component7 = new Component("i3", Component.Type.CPU, BigDecimal.valueOf(120),
                "Intel", 70, 90);
        component8 = new Component("Gtx 1080", Component.Type.GPU, BigDecimal.valueOf(240),
                "MSI", 150, 220);
        component9 = new Component("B360", Component.Type.MOTHERBOARD, BigDecimal.valueOf(60),
                "MSI", 140, 20);
        component10 = new Component("1TB", Component.Type.SSD, BigDecimal.valueOf(68),
                "Samsung", 200, 15);
        component11 = new Component("RGB CASE", Component.Type.CASE, BigDecimal.valueOf(100),
                "MSI", 100, 0);
        component12 = new Component("8GB", Component.Type.RAM, BigDecimal.valueOf(68),
                "HyperX", 77, 10);
        component13 = new Component("1TB", Component.Type.PSU, BigDecimal.valueOf(105),
                "Corsair", 220, 700);
        database.saveComponent(component);
        database.saveComponent(component1);
        database.saveComponent(component2);
        database.saveComponent(component3);
        database.saveComponent(component4);
        database.saveComponent(component5);
        database.saveComponent(component6);
        database.saveComponent(component7);
        database.saveComponent(component8);
        database.saveComponent(component9);
        database.saveComponent(component10);
        database.saveComponent(component11);
        database.saveComponent(component12);
        database.saveComponent(component13);
    }


    @Test
    void getName() {
        Store store = new Store("Klick", BigDecimal.valueOf(1000), BigDecimal.valueOf(1.1));
        Assertions.assertEquals("Klick", store.getName());
        database.resetEntireDatabase();
    }

    @Test
    void getBalance() throws ProductAlreadyExistsException {
        Store store = new Store("Klick", BigDecimal.valueOf(1000), BigDecimal.valueOf(1.1));
        Assertions.assertEquals(BigDecimal.valueOf(1000), store.getBalance());
        database.resetEntireDatabase();
    }



    @Test
    void purchaseComponent() throws ProductAlreadyExistsException, OutOfStockException, NotEnoughMoneyException,
            ProductNotFoundException {
        Store store = new Store("Klick", BigDecimal.valueOf(1000), BigDecimal.valueOf(2));
        Customer customer = new Customer("Rainer", BigDecimal.valueOf(1000));
        store.purchaseComponent(0, customer);
        Assertions.assertEquals(BigDecimal.valueOf(700), customer.getBalance());
        database.resetEntireDatabase();
    }

    @Test
    void purchaseComponent3() throws ProductAlreadyExistsException, OutOfStockException, NotEnoughMoneyException,
            ProductNotFoundException {
        Store store = new Store("Klick", BigDecimal.valueOf(1000), BigDecimal.valueOf(2));
        Customer customer = new Customer("Rainer", BigDecimal.valueOf(1000));
        store.purchaseComponent(0, customer);
        List<Component> components = new ArrayList<>(List.of(component));
        Assertions.assertEquals("Rainer", customer.getName());
        Assertions.assertEquals(components, customer.getComponents());
        database.resetEntireDatabase();
    }

    @Test
    void purchaseComponent2() throws OutOfStockException, NotEnoughMoneyException,
            ProductNotFoundException {
        Store store = new Store("Klick", BigDecimal.valueOf(1000), BigDecimal.valueOf(2));
        Customer customer = new Customer("Rainer", BigDecimal.valueOf(1000));
        store.purchaseComponent(0, customer);
        Assertions.assertEquals(BigDecimal.valueOf(1300), store.getBalance());
        database.resetEntireDatabase();
    }
}
