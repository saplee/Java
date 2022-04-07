package ee.taltech.iti0202.kt.hotel.tests;

import ee.taltech.iti0202.kt.hotel.hotel.Hotel;
import ee.taltech.iti0202.kt.hotel.rooms.Room;
import ee.taltech.iti0202.kt.hotel.rooms.RoomType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HotelTest {
    @Test
    void getAllRooms(){
        Hotel hotel = new Hotel();
        Room room = new Room(1, 5 * 5, RoomType.Type.REGULAR);
        Room room2= new Room(2, 5 * 4, RoomType.Type.REGULAR);
        Room room3 = new Room(3, 6 * 5, RoomType.Type.SUITE);
        hotel.addRoom(room);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        List<Room> result = new ArrayList<>(List.of(room, room2, room3));
        Assertions.assertEquals(result, hotel.getAllRooms());
    }
    @Test
    void getAllRooms2(){
        //Get all rooms when on have same room number
        Hotel hotel = new Hotel();
        Room room = new Room(1, 5 * 5, RoomType.Type.REGULAR);
        Room room2= new Room(2, 5 * 4, RoomType.Type.REGULAR);
        Room room3 = new Room(2, 6 * 5, RoomType.Type.SUITE);
        hotel.addRoom(room);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        List<Room> result = new ArrayList<>(List.of(room, room2));
        Assertions.assertEquals(result, hotel.getAllRooms());
    }
    @Test
    void getTakenRooms(){
        //Get all rooms when on have same room number
        Hotel hotel = new Hotel();
        Room room = new Room(1, 5 * 5, RoomType.Type.REGULAR);
        Room room2= new Room(2, 5 * 4, RoomType.Type.REGULAR);
        Room room3 = new Room(3, 6 * 5, RoomType.Type.SUITE);
        hotel.addRoom(room);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        room.takeRoom();
        room2.takeRoom();
        List<Room> result = new ArrayList<>(List.of(room, room2));
        Assertions.assertEquals(result, hotel.getTakenRooms());
    }
    @Test
    void getFreeRooms(){
        //Get all rooms when on have same room number
        Hotel hotel = new Hotel();
        Room room = new Room(1, 5 * 5, RoomType.Type.REGULAR);
        Room room2= new Room(2, 5 * 4, RoomType.Type.REGULAR);
        Room room3 = new Room(3, 6 * 5, RoomType.Type.SUITE);
        hotel.addRoom(room);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        room.takeRoom();
        room2.takeRoom();
        room3.takeRoom();
        room.cancelRoom();
        room2.cancelRoom();
        room3.cancelRoom();
        List<Room> result = new ArrayList<>(List.of(room, room2));
        Assertions.assertEquals(result, hotel.getFreeRooms());
    }
    @Test
    void GotSearchedRoom(){
        //Get all rooms when on have same room number
        Hotel hotel = new Hotel();
        Room room = new Room(1, 5 * 5, RoomType.Type.REGULAR);
        Room room2= new Room(2, 5 * 4, RoomType.Type.REGULAR);
        Room room3 = new Room(3, 6 * 5, RoomType.Type.SUITE);
        hotel.addRoom(room);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        room.takeRoom();
        room2.takeRoom();
        room3.takeRoom();
        room.cancelRoom();
        room2.cancelRoom();
        room3.cancelRoom();
        Assertions.assertTrue(hotel.searchFreeRooms(4*5));
    }

    @Test
    void GotSearchedRoomButNotFree(){
        //Get all rooms when on have same room number
        Hotel hotel = new Hotel();
        Room room = new Room(1, 5 * 5, RoomType.Type.REGULAR);
        Room room2= new Room(2, 5 * 4, RoomType.Type.REGULAR);
        Room room3 = new Room(3, 6 * 5, RoomType.Type.SUITE);
        hotel.addRoom(room);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        room.takeRoom();
        room2.takeRoom();
        room3.takeRoom();
        Assertions.assertFalse(hotel.searchFreeRooms(4*5));
    }
}