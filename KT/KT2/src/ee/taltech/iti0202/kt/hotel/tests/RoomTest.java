package ee.taltech.iti0202.kt.hotel.tests;

import ee.taltech.iti0202.kt.hotel.Room;
import ee.taltech.iti0202.kt.hotel.RoomType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoomTest {
    @Test
    void testGetRoomSize() {
        Room room = new Room(1, 5 * 5, RoomType.Type.REGULAR);
        Assertions.assertEquals(5 * 5, room.getRoomSize());
    }
    @Test
    void testIsRoomTaken() {
        Room room = new Room(1, 5 * 5, RoomType.Type.SUITE);
        room.takeRoom();
        room.cancelRoom();
        Assertions.assertTrue(room.isRoomTaken());
    }
}