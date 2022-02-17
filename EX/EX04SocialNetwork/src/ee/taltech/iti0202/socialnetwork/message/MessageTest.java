package ee.taltech.iti0202.socialnetwork.message;

import ee.taltech.iti0202.socialnetwork.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    final int age = 19;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getMessageTitle() {
        User user = new User("Joosep", age);
        Message message = new Message("Java põhikursus", "Sain EX04 valmis", user);
        assertEquals("Java põhikursus", message.getTitle());
    }

    @Test
    void getMessage() {
        User user = new User("Joosep", age);
        Message message = new Message("Java põhikursus", "Sain EX04 valmis", user);
        assertEquals("Sain EX04 valmis", message.getMessage());
    }

    @Test
    void getMessageAuthorName() {
        User user = new User("Joosep", age);
        Message message = new Message("Java põhikursus", "Sain EX04 valmis", user);
        assertEquals("Joosep", message.getAuthor().getName());
    }

    @Test
    void getMessageAuthorAge() {
        User user = new User("Joosep", age);
        Message message = new Message("Java põhikursus", "Sain EX04 valmis", user);
        assertEquals(age, message.getAuthor().getAge());
    }
}
