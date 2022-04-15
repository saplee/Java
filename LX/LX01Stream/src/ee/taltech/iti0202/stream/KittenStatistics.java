package ee.taltech.iti0202.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;


public class KittenStatistics {

    private List<Kitten> kittens;

    /**
     *
     * @param kittens
     */
    public void setKittens(List<Kitten> kittens) {
        this.kittens = kittens;
    }

    /**
     *
     * @return
     */
    public OptionalDouble findKittensAverageAge() {
        return kittens.size() == 0 ? OptionalDouble.empty() : OptionalDouble.of(kittens.stream()
                .mapToDouble(Kitten::getAge)
                .average().getAsDouble());
    }

    /**
     *
     * @return
     */
    public Optional<Kitten> findOldestKitten() {
        return Optional.of(kittens.stream().sorted(Comparator.comparing(Kitten::getAge).reversed()).toList().get(0));

    }

    /**
     *
     * @return
     */
    public List<Kitten> findYoungestKittens() {
        return kittensSortedByAgeYoungerFirst().stream()
                .filter(k -> k.getAge() == kittens.stream().map(Kitten::getAge).toList().get(0)).toList();
    }

    /**
     *
     * @param gender
     * @return
     */
    public List<Kitten> findKittensAccordingToGender(Kitten.Gender gender) {
        return kittens.stream().filter(kitten -> kitten.getGender().equals(gender)).toList();
    }

    /**
     *
     * @param minAge
     * @param maxAge
     * @return
     */
    public List<Kitten> findKittensBetweenAges(int minAge, int maxAge) {
        return kittens.stream().filter(kitten -> kitten.getAge() >= minAge).filter(kitten -> kitten.getAge() <= maxAge)
                .toList();
    }

    /**
     *
     * @param givenName
     * @return
     */
    public Optional<Kitten> findFirstKittenWithGivenName(String givenName) {
        return Optional.of(kittens.stream().filter(k -> !k.getName()
                                .equals(givenName))
                        .findFirst())
                .orElse(Optional.empty());
    }

    /**
     *
     * @return
     */
    public List<Kitten> kittensSortedByAgeYoungerFirst() {
        return kittens.stream().sorted(Comparator.comparing(Kitten::getAge)).toList();
    }

    /**
     *
     * @return
     */
    public List<Kitten> kittensSortedByAgeOlderFirst() {
        return kittens.stream().sorted(Comparator.comparing(Kitten::getAge).reversed()).toList();
    }
}
