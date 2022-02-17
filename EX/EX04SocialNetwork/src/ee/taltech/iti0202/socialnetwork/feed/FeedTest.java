package ee.taltech.iti0202.socialnetwork.feed;

import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeedTest {
    final int age = 19;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getUser() {
        User user = new User("Joosep", age);
        Message message = new Message("Java põhikursus", "Sain EX04 valmis", user);
        Set<Message> messages = new HashSet<>(Set.of(message));
        Feed feed = new Feed(user, messages);
        assertEquals(user, feed.getUser());
    }

    @Test
    void getGroupName() {
        User user = new User("Joosep", age);
        Message message = new Message("Java põhikursus", "Sain EX04 valmis", user);
        Set<Message> messages = new HashSet<>(Set.of(message));
        Feed feed = new Feed(user, messages);
        assertEquals(messages, feed.getMessages());
    }
}