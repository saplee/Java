
package ee.taltech.iti0202.socialnetwork.group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {

    private String name;
    private User owner;
    private Set<User> groupMembers = new HashSet<>(Set.of(owner));

    /**
     * Name and owner.
     * @param name
     * @param owner
     */
    public Group(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public User getOwner() {
        return owner;
    }

    /**
     *
     * @param user
     */
    public void addUser(User user) {
        groupMembers.add(user);
    }

    public Set<User> getParticipants() {
        return groupMembers;
    }

    /**
     *
     * @param message
     */
    public void publishMessage(Message message) {

    }

    public List<Message> getMessages() {
        return null;
    }
}
