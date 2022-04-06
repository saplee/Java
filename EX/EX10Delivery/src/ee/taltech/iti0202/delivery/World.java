package ee.taltech.iti0202.delivery;

import java.util.*;

public class World {
    private HashMap<String, Location> locationMap = new HashMap<>();
    private HashMap<String, Courier> courierMap = new HashMap<>();
    private List<String> locations = new ArrayList<>();

    public World() {
    }

    public Optional<Location> addLocation(String name, List<String> otherLocations, List<Integer> distances) {
        HashSet<String> otherLocation = new HashSet<>(otherLocations);
        HashSet<String> locations2 = new HashSet<>(locations);
        if (locationMap.containsKey(name) || otherLocations.size() != distances.size()
                || locations.size() > otherLocations.size() || !otherLocation.containsAll(locations2)) {
            return Optional.empty();
        } else {
            Location location = new Location(name);
            for (int i = 0; i < otherLocations.size(); i++) {
                if (locations2.contains(otherLocations.get(i))) {
                    location.addDistance(otherLocations.get(i), distances.get(i));
                    locationMap.get(otherLocations.get(i)).addDistance(name, distances.get(i));
                }
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
        Location location = null;
        for (Courier courier : courierMap.values()) {
            courier.move();
            if (courier.getAmount() == 0) {
                courier.setLocation(courier.getNextLocation());
                if (courier.getLocation().isPresent()) {
                    location = courier.getLocation().get();
                }
                for (String packet : courier.getStrategy().getAction().getDeposit()) {
                    if (location != null && location.getPacket(packet).isPresent()){
                    }
                }
            }
        }
    }
}
