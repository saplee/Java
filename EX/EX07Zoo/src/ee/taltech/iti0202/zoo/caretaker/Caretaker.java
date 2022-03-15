package ee.taltech.iti0202.zoo.caretaker;

import ee.taltech.iti0202.zoo.animal.Animal;


import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private String name;
    private List<Animal.Type> typesCanFeed;

    /**
     *
     * @param name
     * @param typesCanFeeD
     */
    public Caretaker(String name, List<Animal.Type> typesCanFeeD) {
        this.name = name;
        this.typesCanFeed = typesCanFeeD;
    }

    public String getName() {
        return name;
    }

    public List<Animal.Type> getTypeCanFeed() {
        return typesCanFeed;
    }

    public List<Animal> caretakerCanFeed(List<Animal> animals) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals) {
            if (typesCanFeed.contains(animal.getType())) {
                result.add(animal);
            }
        }
        return result;
    }
}
