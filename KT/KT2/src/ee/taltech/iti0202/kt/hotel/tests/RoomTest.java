package ee.taltech.iti0202.kt.hotel.tests;

import static org.junit.jupiter.api.Assertions.*;

import ee.taltech.iti0202.kt.hotel.Room;
import ee.taltech.iti0202.kt.hotel.RoomType;
import org.testng.annotations.Test;

class RoomTest {
    @Test
    void testGetRoomSize(){
        Room room = new Room(1, 5*5, RoomType.Type.REGULAR);
        assertEquals(5*5, room.getRoomSize());
    }
}