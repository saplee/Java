package ee.taltech.iti0202.delivery;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Location {
    private HashMap<String, Packet> packets = new HashMap<>();
    private String name;
    private HashMap<String, Integer> distanceMap = new HashMap<>();

    public Location(String name) {
        this.name = name;
    }

    public Integer getDistanceTo(String name) {
        if (distanceMap.containsKey(name)) {
            return distanceMap.get(name);
        }
        return Integer.MAX_VALUE;
    }

    public void addPacket(Packet packet) {
        if (!packets.containsKey(packet.getName())) {
            packets.put(packet.getName(), packet);
        }
    }

    public Optional<Packet> getPacket(String name) {
        if (packets.containsKey(name)) {
            Packet packet = packets.get(name);
            packets.remove(name);
            return Optional.of(packet);

        }
        return Optional.empty();
    }

    public void addDistance(String location, int distance) {
        distanceMap.put(location, distance);
    }

    public String getName() {
        return name;
    }
}
