package ee.taltech.iti0202.personstatistics;

import java.util.*;

/**
 * For calculating and finding statistical info based on persons.
 */
public class PersonStatistics {
    private List<Person> persons;

    /**
     * Constructor which stores the given list.
     */
    public PersonStatistics(List<Person> persons) {
        this.persons = persons;
    }

    /**
     * Return the number of people in the list.
     */
    public long countPersons() {
        return persons.size();
    }

    /**
     * Find the average height of the persons.
     */
    public OptionalDouble findAverageHeight() {
        return persons.size() == 0 ? OptionalDouble.empty() : OptionalDouble.of(persons.stream()
                .mapToDouble(Person::getHeightInMeters)
                .average().getAsDouble());
    }

    /**
     * Return the person with the lowest age.
     */
    public Optional<Person> findYoungestPerson() {
        return persons.stream().sorted(Comparator.comparing(Person::getAge)).findFirst();
    }

    /**
     * Return the person with the highest age.
     */
    public Optional<Person> findOldestPerson() {
        return persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).findFirst();
    }

    /**
     * Return the longest last name.
     */
    public Optional<String> findLongestLastName() {
        return persons.stream().map(Person::getLastName).toList().stream().sorted(Comparator
                .comparing(String::length).reversed()).findFirst();
    }

    /**
     * Return a list of nationalities.
     */
    public List<String> getNationalityData() {
        return persons.stream().map(Person::getNationality).toList();
    }

    /**
     * Converts persons heights from m to cm.
     *
     * @return list of heights in cm
     */
    public List<Double> getHeightInCm() {
        return null;
    }

    /**
     * Return a sublist with the given size.
     */
    public List<Person> findSamples(int sampleSize) {
        if (sampleSize <= 0){
            return new ArrayList<>();
        }
        return persons.subList(0, sampleSize);
    }

    /**
     * Find first person matching provided parameters criterias.
     *
     * @return first matching person
     */
    public Optional<Person> findSamplePerson(String nationality, Gender gender, int age) {
        return persons.stream()
                .filter(person -> person.getNationality().equals(nationality))
                .filter(person -> person.getGender().equals(gender))
                .filter(person -> person.getAge() == age).findFirst();
    }

    /**
     * Find unique first names.
     */
    public Set<String> getDistinctFirstNames() {
        return null;
    }

    /**
     * Order persons from tallest to shortest.
     *
     * @return ordered list of persons
     */
    public List<Person> getReverseOrderedByHeight() {
        return persons.stream().sorted(Comparator.comparing(Person::getHeightInMeters).reversed()).toList();
    }

    /**
     * Return list of people whose age is between ageFrom to ageTo (inclusive).
     */
    public List<Person> findBetweenAge(int ageFrom, int ageTo) {
        return persons.stream()
                .filter(person -> person.getAge() <= (ageFrom))
                .filter(person -> person.getAge() >= ageTo).toList();
    }

    /**
     * Find persons whose first name first letter is same as his/her nationality first letter.
     *
     * @return list of matching persons
     */
    public List<Person> findSameLetterNameAndNationality() {
        return null;
    }

    /**
     * Create map where each occupation has list of persons who have that occupation.
     *
     * @return map of occupations with persons
     */
    public Map<String, List<Person>> mapOccupationToPersons() {
        return null;
    }


}