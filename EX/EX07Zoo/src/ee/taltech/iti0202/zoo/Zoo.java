package ee.taltech.iti0202.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    protected int days = 0;
    protected List<Animal> animals = new ArrayList<>();

    public Zoo() {
    }

    public void addAnimal(Animal animal) {
        if (!animals.contains(animal)) {
            animals.add(animal);
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<String> allAnimalVoices() {
        List<String> result = new ArrayList<>();
        for (Animal animal : animals) {
            result.add(animal.getVoice());
        }
        return result;
    }

    public void nextDay() {
        days++;
    }
}
