package ee.taltech.iti0202.stream;
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
        return Optional.empty();
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
        if(!kittens.stream().map(Kitten::getName).toList().contains(givenName)){
            return Optional.empty();
        }else {
            Kitten result = kittens.stream().filter(kitten -> kitten.getName().equals(givenName)).toList().get(0);
            return Optional.of(result);
        }
    }

    public List<Kitten> kittensSortedByAgeYoungerFirst() {
        return null;
    }

    public List<Kitten> kittensSortedByAgeOlderFirst() {
        return null;
    }
    
}