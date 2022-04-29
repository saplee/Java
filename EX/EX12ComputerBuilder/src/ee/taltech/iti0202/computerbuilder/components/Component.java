package ee.taltech.iti0202.computerbuilder.components;

import java.math.BigDecimal;

public class Component {
    private int id;
    private String name;
    private Type type;
    private BigDecimal price;
    private int amount = 1;
    private String manufacturer;
    private int performancePoints;
    private int powerConsumption;
    private static int number = -1;

    public enum Type {
        CPU, GPU, RAM, MOTHERBOARD, HDD, SSD, PSU, KEYBOARD, TOUCHPAD, SCREEN, BATTERY, FAN, CASE
    }

    public static int getAndIncrementNextId() {
        return ++number;
    }

    public static void setAndIncrementNextId() {
        number = -1;
    }

    public Component(String name, Type type, BigDecimal price, String manufacturer, Integer performancePoints,
                     Integer powerConsumption) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.manufacturer = manufacturer;
        this.performancePoints = performancePoints;
        this.powerConsumption = powerConsumption;
        this.id = getAndIncrementNextId();
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public Type getType() {
        return type;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public int getAmount() {
        return amount;
    }


    public String getManufacturer() {
        return manufacturer;
    }


    public int getPerformancePoints() {
        return performancePoints;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

}
