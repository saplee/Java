package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Location {
    private List<Packet> packets = new ArrayList<>();
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
        packets.add(packet);
    }

    public Optional<Packet> getPacket(String name) {
        if (packets.stream().map(Packet::getName).toList().contains(name)) {
            Packet packet = packets.get(packets.stream().map(Packet::getName).toList().indexOf(name));
            packets.remove(packets.stream().map(Packet::getName).toList().indexOf(name));
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

    public List<Packet> getPackets() {
        return packets;
    }
}
