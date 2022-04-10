package ee.taltech.iti0202.computerstore.components;

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
    private static int number = 0;

    public enum Type {
        CPU, GPU, RAM, MOTHERBOARD, HDD, SSD, PSU, KEYBOARD, TOUCHPAD, SCREEN, BATTERY, FAN
    }
    public static int getAndIncrementNextId() {
        return number++;
    }
    public static void setAndIncrementNextId() {
        number = 0;
    }

    public Component(String name, Type type, BigDecimal price, String manufacturer, int performancePoints, int powerConsumption) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPerformancePoints() {
        return performancePoints;
    }

    public void setPerformancePoints(int performancePoints) {
        this.performancePoints = performancePoints;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}
