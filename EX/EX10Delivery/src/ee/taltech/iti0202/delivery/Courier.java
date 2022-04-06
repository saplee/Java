package ee.taltech.iti0202.delivery;

import java.util.Optional;

public class Courier {
    private Strategy strategy;
    private String name;
    private Location location;
    private int amount = 0;

    public Courier(String name) {

        this.name = name;
    }

    public Optional<Location> getLocation() {
        return Optional.of(location);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public String getName() {
        return name;
    }


    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getNextLocation() {
        amount = strategy.getAction().getGoTo().getDistanceTo(location.getName());
        return strategy.getAction().getGoTo();
    }

    public void move() {
        amount--;
    }
}
