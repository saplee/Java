package ee.taltech.iti0202.socialnetwork;

import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.Set;

public class SocialNetwork {
    /**
     *
     * @param group
     */
    public void registerGroup(Group group) {

    }

    public Set<Group> getGroups() {
        return null;
    }

    /**
     *
     * @param user
     * @return
     */
    public Feed getFeedForUser(User user) {
        return new Feed(null, null);
    }
}
