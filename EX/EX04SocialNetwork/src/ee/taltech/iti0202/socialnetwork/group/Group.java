
package ee.taltech.iti0202.socialnetwork.group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.List;
import java.util.Set;

public class Group {

    private String name;
    private User owner;

    public Group(String name, User owner) {

        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return null;
    }

    public void setName(String name) {

    }

    public User getOwner() {
        return owner;
    }

    public void addUser(User user) {

    }

    public Set<User> getParticipants() {
        return null;
    }

    public void publishMessage(Message message) {

    }

    public List<Message> getMessages() {
        return null;
    }
}