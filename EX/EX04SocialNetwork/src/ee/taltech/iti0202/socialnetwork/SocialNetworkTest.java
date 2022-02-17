package ee.taltech.iti0202.socialnetwork;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SocialNetworkTest {
    final int age = 19;
    @BeforeEach
    void setUp() {
    }
    @Test
    void getGroups() {
        SocialNetwork socialNetwork = new SocialNetwork();
        User user = new User("Joosep", age);
        Group group =new Group("Proge", user);
        socialNetwork.registerGroup(group);
        Set<Group> groups = new HashSet<>(Set.of(group));
        assertEquals(groups, socialNetwork.getGroups());
    }
}
