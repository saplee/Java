package ee.taltech.iti0202.delivery;

import java.util.Optional;

public class Courier {
    private Strategy strategy;
    private String name;
    private Location location;

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
}
