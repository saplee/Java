package ee.taltech.iti0202.stream;

import com.sun.tools.javac.Main;

import java.nio.channels.FileLock;
import java.util.*;
import java.util.stream.Collectors;

public class KittenStatistics {

    private List<Kitten> kittens;

    public void setKittens(List<Kitten> kittens) {
        this.kittens = kittens;
    }

    public OptionalDouble findKittensAverageAge() {
        return kittens.size() == 0 ? OptionalDouble.empty() : OptionalDouble.of(kittens.stream()
                .mapToDouble(Kitten::getAge)
                .average().getAsDouble());
    }

    public Optional<Kitten> findOldestKitten() {
        return Optional.of(kittens.stream().sorted(Comparator.comparing(Kitten::getAge).reversed()).toList().get(0));

    }

    public List<Kitten> findYoungestKittens() {
        return kittens.stream()
                .filter(k -> k.getAge() == kittens.stream().map(Kitten::getAge).toList().get(0))
                .collect(Collectors.toList());
    }

    public List<Kitten> findKittensAccordingToGender(Kitten.Gender gender) {
        return kittens.stream().filter(kitten -> kitten.getGender().equals(gender)).toList();
    }

    public List<Kitten> findKittensBetweenAges(int minAge, int maxAge) {
        return kittens.stream().filter(kitten -> kitten.getAge() >= minAge).filter(kitten -> kitten.getAge() <= maxAge).toList();
    }

    public Optional<Kitten> findFirstKittenWithGivenName(String givenName) {
        return Optional.of(kittens.stream().filter(k -> !k.getName()
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