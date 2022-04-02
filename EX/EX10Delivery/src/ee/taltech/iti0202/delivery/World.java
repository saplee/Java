package ee.taltech.iti0202.delivery;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class World {
    private HashMap<String, Location> locationMap = new HashMap<>();
    private HashMap<String, Courier> courierMap = new HashMap<>();

    public World() {

    }

    public Optional<Location> addLocation(String name, List<String> otherLocations, List<Integer> distances) {
        if (locationMap.containsKey(name) || otherLocations.size() == 0 || distances.size() == 0) {
            return Optional.empty();
        } else {
            Location location = new Location(name);
            locationMap.put(name, location);
            return Optional.of(location);
        }
    }

    public Optional<Courier> addCourier(String name, String to) {
        if (courierMap.containsKey(name) || locationMap.containsKey(to)) {
            return Optional.empty();
        } else {
            Courier courier = new Courier(name);
            courier.setLocation(locationMap.get(to));
            courierMap.put(name, courier);
            return Optional.of(courier);
        }

    }

    public boolean giveStrategy(String name, Strategy strategy) {
        return false;
    }

    public void tick() {
    }
}
