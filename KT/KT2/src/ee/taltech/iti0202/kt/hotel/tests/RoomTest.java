package ee.taltech.iti0202.kt.hotel.tests;

import ee.taltech.iti0202.kt.hotel.rooms.Room;
import ee.taltech.iti0202.kt.hotel.rooms.RoomType;
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
    @Test
    void testIsRoomTaken2() {
        Room room = new Room(1, 5 * 5, RoomType.Type.REGULAR);
        room.takeRoom();
        room.cancelRoom();
        Assertions.assertFalse(room.isRoomTaken());
    }
    @Test
    void testGetRoomNumber() {
        Room room = new Room(1, 5 * 5, RoomType.Type.REGULAR);
        room.takeRoom();
        room.cancelRoom();
        Assertions.assertEquals(1, room.getRoomNumber());
    }
}
