package ee.taltech.iti0202.stream;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class KittenStatistics {

    private List<Kitten> kittens;

    public void setKittens(List<Kitten> kittens) {
        this.kittens = kittens;
    }

    public OptionalDouble findKittensAverageAge() {
        return OptionalDouble.empty();    
    }

    public Optional<Kitten> findOldestKitten() {
        return null;
    }

    public List<Kitten> findYoungestKittens() {
        return null;
    }

    public List<Kitten> findKittensAccordingToGender(Kitten.Gender gender) {
        return kittens.stream().filter(kitten -> kitten.getGender().equals(gender)).toList();
    }

    public List<Kitten> findKittensBetweenAges(int minAge, int maxAge) {
        return null;
    }

    public Optional<Kitten> findFirstKittenWithGivenName(String givenName) {
        return Optional.of(kittens.stream().filter(kitten -> !kitten.getName()
                        .equals(givenName))
                .findFirst())
                .orElse(Optional.empty());
    }

    public List<Kitten> kittensSortedByAgeYoungerFirst() {
        return kittens.stream().sorted(Comparator.comparing(Kitten::getAge)).toList();
    }

    public List<Kitten> kittensSortedByAgeOlderFirst() {
        return kittens.stream().sorted(Comparator.comparing(Kitten::getAge).reversed()).toList();
    }
    
}