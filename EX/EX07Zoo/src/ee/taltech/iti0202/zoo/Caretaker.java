package ee.taltech.iti0202.zoo;

import java.util.List;

public class Caretaker {
    private String name;
    private Animal.Type typeCanFeed;

    public Caretaker(String name, Animal.Type typeCanFeed) {
        this.name = name;
        this.typeCanFeed = typeCanFeed;
    }

    public String getName() {
        return name;
    }

    public Animal.Type getTypeCanFeed() {
        return typeCanFeed;
    }

    public List<Animal> caretakerCanFeed(List<Animal> animals) {
        return null;
    }
}
