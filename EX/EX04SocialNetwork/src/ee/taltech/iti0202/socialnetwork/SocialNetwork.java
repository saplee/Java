package ee.taltech.iti0202.socialnetwork;

import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SocialNetwork {
    /**
     * @param group
     */
    private Set<Group> groups = new HashSet<>();
    private Group group;

    /**
     * @param group
     */
    public void registerGroup(Group group) {
        this.group = group;
        groups.add(group);
    }

    public Set<Group> getGroups() {
        return groups;
    }

    /**
     * @param user
     * @return
     */
    public Feed getFeedForUser(User user) {
        List<List<Message>> messageList = new ArrayList<>();
        for (Group group : groups) {
            if (group.getParticipants().contains(user)) {
                messageList.add(group.getMessages());
            }
        }
        List<Message> allMessages = messageList.stream().flatMap(List::stream).toList();
        Set<Message> result = new HashSet<>(allMessages);
        return new Feed(user, result);
    }
}
