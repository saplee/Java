package ee.taltech.iti0202.kt.hotel.hotel;

import ee.taltech.iti0202.kt.hotel.rooms.Room;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> allRooms = new ArrayList<>();

    public Hotel() {

    }

    public void addRoom(Room room) {
        if (!allRooms.contains(room)
                && !allRooms.stream().map(Room::getRoomNumber).toList().contains(room.getRoomNumber())) {
            allRooms.add(room);
        }
    }

    public boolean searchFreeRooms(Integer roomSize) {
        for (Room room : getFreeRooms()) {
            if (room.getRoomSize() >= roomSize) {
                return true;
            }
        }
        return false;
    }

    public List<Room> getTakenRooms() {
        List<Room> takenRooms = new ArrayList<>();
        for (Room room : allRooms) {
            if (room.isRoomTaken()) {
                takenRooms.add(room);
            }
        }
        return takenRooms;
    }

    public List<Room> getFreeRooms() {
        List<Room> freeRooms = new ArrayList<>();
        for (Room room : allRooms) {
            if (!room.isRoomTaken()) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    public List<Room> getAllRooms() {
        return allRooms;
    }
}
