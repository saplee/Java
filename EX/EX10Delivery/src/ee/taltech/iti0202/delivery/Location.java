package ee.taltech.iti0202.delivery;

import java.util.Optional;

public class Location {

    public Location() {
    }

    public Integer getDistanceTo(String name) {
        return Integer.MAX_VALUE;
    }

    public void addPacket(Packet packet) {

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
