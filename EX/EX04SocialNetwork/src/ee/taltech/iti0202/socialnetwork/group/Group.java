
package ee.taltech.iti0202.socialnetwork.group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.List;
import java.util.Set;

public class Group {

    private String name;
    private User owner;

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

    }

    public Set<User> getParticipants() {
        return null;
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
