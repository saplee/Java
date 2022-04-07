package ee.taltech.iti0202.kt.hotel;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private Integer roomNumber;
    private Integer roomSize;
    private RoomType.Type roomType;
    private boolean roomTaken = false;
    private List<Room> allRooms = new ArrayList<>();


    public Room(Integer roomNumber, Integer roomSize, RoomType.Type roomType) {

        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomType = roomType;
    }

    public boolean isRoomTaken() {
        if (!roomTaken) {
            return false;
        }
        return true;
    }

    public void cancelRoom() {
        if (!getRoomType().equals(RoomType.Type.SUITE) && isRoomTaken()) {
            roomTaken = false;
        } else {
            roomTaken = true;
        }
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public RoomType.Type getRoomType() {
        return roomType;
    }

    public void takeRoom() {
        if (!isRoomTaken()) {
            roomTaken = true;
        }
    }
}
