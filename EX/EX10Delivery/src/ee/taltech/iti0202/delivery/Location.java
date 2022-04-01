package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Location {
    private List<Packet> packets = new ArrayList<>();
    public Integer getDistanceTo(String name) {
        return Integer.MAX_VALUE;
    }

    public void addPacket(Packet packet) {
        packets.add(packet);
    }

    public Optional<Packet> getPacket(String name) {
        return Optional.empty();
    }

    public void addDistance(String location, int distance) {

    }
    public String getName(){
        return null;
    }
}
