package ee.taltech.iti0202.socialnetwork.group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
class GroupTest {
    final int age = 19;
    @BeforeEach
    void setUp() {
    }
    @Test
    void getGroupName() {
        User user = new User("Joosep", age);
        Group group =new Group("Proge", user);
        assertEquals("Proge", group.getName());
    }
    @Test
    void getGroupOwner() {
        User user = new User("Joosep", age);
        Group group =new Group("Proge", user);
        assertEquals(user, group.getOwner());
    }
    @Test
    void getGroupName2() {
        User user = new User("Joosep", age);
        Group group =new Group("Proge", user);
        group.setName("Java");
        assertEquals("Java", group.getName());
    }
    @Test
    void getGroupMembers() {
        User user = new User("Joosep", age);
        User user2 = new User("Ago", age);
        Group group =new Group("Proge", user);
        group.addUser(user2);
        Message message = new Message("Java põhikursus", "Sain EX04 valmis", user);
        group.publishMessage(message);
        Set<User> groupMembers = new HashSet<>(Set.of(user,user2));
        assertEquals(groupMembers, group.getParticipants());
    }
}
