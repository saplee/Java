package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class World {
    private HashMap<String, Location> locationMap = new HashMap<>();
    private HashMap<String, Courier> courierMap = new HashMap<>();
    private List<String> locations = new ArrayList<>();

    public World() {
    }

    public Optional<Location> addLocation(String name, List<String> otherLocations, List<Integer> distances) {
        for (String city : otherLocations) {
            if (!locationMap.containsKey(city)) {
                return Optional.empty();
            }
        }
        if (locationMap.containsKey(name) || otherLocations.size() != distances.size() || locations.size() != otherLocations.size()) {
            return Optional.empty();
        } else {
            Location location = new Location(name);
            for (int i = 0; i < otherLocations.size(); i++) {
                location.addDistance(otherLocations.get(i), distances.get(i));
                locationMap.get(otherLocations.get(i)).addDistance(location.getName(), distances.get(i));
            }
            locationMap.put(name, location);
            locations.add(name);
            return Optional.of(location);
        }
    }

    public Optional<Courier> addCourier(String name, String to) {
        if (courierMap.containsKey(name) || !locationMap.containsKey(to)) {
            return Optional.empty();
        } else {
            Courier courier = new Courier(name);
            courier.setLocation(locationMap.get(to));
            courierMap.put(name, courier);
            return Optional.of(courier);
        }

    }

    public boolean giveStrategy(String name, Strategy strategy) {
        if (!courierMap.containsKey(name)) {
            return false;
        }
        courierMap.get(name).setStrategy(strategy);
        return true;
    }

    public HashMap<String, Courier> getCourierMap() {
        return courierMap;
    }

    public HashMap<String, Location> getLocationMap() {
        return locationMap;
    }

    public void tick() {
    }

    public static void main(String[] args) {
        World world = new World();
        Location tallinn = world.addLocation("Tallinn", new ArrayList<>(), new ArrayList<>()).get();
        System.out.println(world.addLocation("Tartu", List.of(), List.of()));
    }
}
