
package ee.taltech.iti0202.personstatistics;

public class PersonBuilder {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private double heightInMeters;
    private String occupation;
    private String nationality;

    /**
     *
     * @param firstName
     * @return
     */
    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     *
     * @param lastName
     * @return
     */
    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     *
     * @param age
     * @return
     */
    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    /**
     *
     * @param gender
     * @return
     */
    public PersonBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    /**
     *
     * @param heightInMeters
     * @return
     */
    public PersonBuilder setHeightInMeters(double heightInMeters) {
        this.heightInMeters = heightInMeters;
        return this;
    }

    /**
     *
     * @param occupation
     * @return
     */
    public PersonBuilder setOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    /**
     *
     * @param nationality
     * @return
     */
    public PersonBuilder setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    /**
     *
     * @return
     */
    public Person createPerson() {
        return new Person(firstName, lastName, age, gender, heightInMeters, occupation, nationality);
    }
}