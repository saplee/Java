package ee.taltech.iti0202.computerbuilder.tests;

import ee.taltech.iti0202.computerbuilder.Customer;
import ee.taltech.iti0202.computerbuilder.components.Component;
import ee.taltech.iti0202.computerbuilder.computer.Computer;
import ee.taltech.iti0202.computerbuilder.computer.ComputerFactory;
import ee.taltech.iti0202.computerbuilder.computer.ComputerType;
import ee.taltech.iti0202.computerbuilder.computer.Desktop;
import ee.taltech.iti0202.computerbuilder.computer.UseCase;
import ee.taltech.iti0202.computerbuilder.database.Database;
import ee.taltech.iti0202.computerbuilder.exceptions.CannotBuildComputer;
import ee.taltech.iti0202.computerbuilder.exceptions.ProductAlreadyExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class ComputerTest {
    private int numberA = 1500;
    private int numberB = 100;
    private int numberC = 99;
    private int numberD = 77;
    private int numberE = 400;
    private int numberF = 150;
    private int numberG = 220;
    private int numberH = 1500;
    private int numberI = 1500;
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
        customer = new Customer("Alex", BigDecimal.valueOf(numberA));
        database = Database.getInstance();
        component = new Component("i5", Component.Type.CPU, BigDecimal.valueOf(200),
                "Intel", numberB, 90);
        component1 = new Component("Gtx 1070", Component.Type.GPU, BigDecimal.valueOf(220),
                "MSI", numberF, 220);
        component2 = new Component("B365", Component.Type.MOTHERBOARD, BigDecimal.valueOf(68),
                "MSI", numberF, 5 * 4);
        component3 = new Component("1TB", Component.Type.HDD, BigDecimal.valueOf(68),
                "Toshiba", numberF, 5 * 4);
        component4 = new Component("CASE", Component.Type.CASE, BigDecimal.valueOf(44),
                "MSI", numberB, 0);
        component5 = new Component("16GB", Component.Type.RAM, BigDecimal.valueOf(numberD),
                "HyperX", numberC, 5 * 2);
        component6 = new Component("PSU", Component.Type.PSU, BigDecimal.valueOf(numberD),
                "Corsair", numberB, 450);
        component7 = new Component("i3", Component.Type.CPU, BigDecimal.valueOf(120),
                "Intel", 70, 90);
        component8 = new Component("Gtx 1080", Component.Type.GPU, BigDecimal.valueOf(numberE),
                "MSI", 151, 220);
        component9 = new Component("B360",
                Component.Type.MOTHERBOARD, BigDecimal.valueOf(5 * 5 + 5 * 5 + 5 * 2),
                "MSI", 140, 5 * 4);
        component10 = new Component("500GB", Component.Type.SSD, BigDecimal.valueOf(68),
                "Samsung", 200, 5 * 3);
        component11 = new Component("RGB CASE", Component.Type.CASE, BigDecimal.valueOf(numberB),
                "MSI", numberC, 0);
        component12 = new Component("8GB", Component.Type.RAM, BigDecimal.valueOf(68),
                "HyperX", numberD, 5 * 2);
        component13 = new Component("PSU", Component.Type.PSU, BigDecimal.valueOf(105),
                "Corsair", numberG, 700);
        component14 = new Component("i9", Component.Type.CPU, BigDecimal.valueOf(numberE),
                "Intel", numberE, 90);
        component15 = new Component("Screen", Component.Type.SCREEN, BigDecimal.valueOf(95),
                "Intel", numberB, 5 * 4);
        component16 = new Component("Steel-series", Component.Type.KEYBOARD, BigDecimal.valueOf(80),
                "Steel-series", 99, 5 * 3);
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
        database.saveComponent(component14);
        database.saveComponent(component15);
        database.saveComponent(component16);

    }

    @Test
    void orderGamingDesktop() throws CannotBuildComputer {
        Desktop computer = (Desktop) ComputerFactory.order(ComputerType.DESKTOP, UseCase.GAMING, customer);
        List<Component> components = new ArrayList<>(List.of(component, component8, component2, component4,
                component10, component5, component13));
        Assertions.assertTrue(computer.getComponents().containsAll(components));
        database.resetEntireDatabase();
    }

    @Test
    void orderWorkDesktop() throws CannotBuildComputer {
        Computer computer = ComputerFactory.order(ComputerType.DESKTOP, UseCase.WORK, customer);
        List<Component> components = new ArrayList<>(List.of(component14, component1, component2, component4,
                component10, component5, component13));
        Assertions.assertTrue(computer.getComponents().containsAll(components));
        database.resetEntireDatabase();
    }

    @Test
    void orderGamingLaptop() throws CannotBuildComputer {
        Computer computer = ComputerFactory.order(ComputerType.LAPTOP, UseCase.GAMING, customer);
        List<Component> components = new ArrayList<>(List.of(component, component8, component2, component4,
                component10, component5, component6, component15, component16));
        Assertions.assertTrue(computer.getComponents().containsAll(components));
        database.resetEntireDatabase();
    }

    @Test
    void orderWorkLaptop() throws CannotBuildComputer {
        Computer computer = ComputerFactory.order(ComputerType.LAPTOP, UseCase.WORK, customer);
        List<Component> components = new ArrayList<>(List.of(component14, component1, component2, component4,
                component10, component5, component6, component15, component16));
        Assertions.assertTrue(computer.getComponents().containsAll(components));
        database.resetEntireDatabase();
    }
}
