package ee.taltech.iti0202.personstatistics;

public class Person {
    private String firstName;
    private String lastName;
    private final int age;
    private final Gender gender;
    private final double heightInMeters;
    private final String occupation;
    private final String nationality;

    /**
     *
     * @param firstName
     * @param lastName
     * @param age
     * @param gender
     * @param heightInMeters
     * @param occupation
     * @param nationality
     */
    public Person(String firstName, String lastName, int age, Gender gender, double heightInMeters, String occupation,
                  String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.heightInMeters = heightInMeters;
        this.occupation = occupation;
        this.nationality = nationality;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public double getHeightInMeters() {
        return heightInMeters;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getNationality() {
        return nationality;
    }
}
