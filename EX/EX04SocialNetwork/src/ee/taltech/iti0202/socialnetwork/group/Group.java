
package ee.taltech.iti0202.socialnetwork.group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.*;

public class Group {

    private String name;
    private User owner;
    private Set<User> groupMembers = new HashSet<>();
    private LinkedList<Message> messageList = new LinkedList<>();

    /**
     * Name and owner.
     *
     * @param name
     * @param owner
     */
    public Group(String name, User owner) {
        this.name = name;
        this.owner = owner;
        groupMembers.add(owner);
    }

    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @param user
     */
    public void addUser(User user) {
        groupMembers.add(user);
    }

    public Set<User> getParticipants() {
        return groupMembers;
    }

    /**
     * @param message
     */
    public void publishMessage(Message message) {
        for (User person : groupMembers){
            if (person.equals(message.getAuthor())){
                messageList.add(message);
            }
        }
    }

    public List<Message> getMessages() {
        return messageList;
    }
}
