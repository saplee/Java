package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.List;

public class Action {
    private Location location;
    private List<String> deposits = new ArrayList<>();
    private List<String> packets = new ArrayList<>();

    public Action(Location location) {
        this.location = location;
    }

    public List<String> getDeposit() {
        return deposits;
    }

    public List<String> getTake() {
        return packets;
    }

    public Location getGoTo() {
        return location;
    }

    public void addDeposit(String packetName) {
        deposits.add(packetName);
    }

    public void addTake(String packetName) {
        packets.add(packetName);
    }
}
