package ee.taltech.iti0202.socialnetwork.user;
public class User {

    private String name;
    private Integer age;

    /**
     * User.
     * @param name
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * User and age.
     * @param name
     * @param age
     */
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
