package ee.taltech.iti0202.delivery;

import java.util.Optional;

public class Courier {
    private Strategy strategy;

    public Optional<Location> getLocation(){
        return Optional.empty();
    }
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }
    public String getName(){
        return null;
    }
}
