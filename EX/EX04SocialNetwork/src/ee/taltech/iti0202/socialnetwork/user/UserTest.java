package ee.taltech.iti0202.socialnetwork.user;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class UserTest {
    final int age = 19;
    @BeforeEach
    void setUp() {
    }
    @Test
    void getUserName() {
        User user = new User("Joosep", age);
        assertEquals("Joosep", user.getName());
    }
    @Test
    void getUserAge() {
        User user = new User("Joosep", age);
        assertEquals(age, user.getAge());
    }
    @Test
    void getUserName2() {
        User user = new User("Joosep");
        assertEquals("Joosep", user.getName());
    }
}
