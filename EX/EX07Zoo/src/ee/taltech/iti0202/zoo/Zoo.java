package ee.taltech.iti0202.zoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zoo {
    public static int days;
    protected List<Animal> animals = new ArrayList<>();
    protected List<Caretaker> caretakers = new ArrayList<>();
    protected List<Animal> hungryAnimals = new ArrayList<>();

    public Zoo() {
    }

    public void addAnimal(Animal animal) {
        if (!animals.contains(animal)) {
            animals.add(animal);
        }
    }


    public void addCaretaker(Caretaker caretaker) {
        if (!caretakers.contains(caretaker)) {
            caretakers.add(caretaker);
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Caretaker> getCaretaker() {
        return caretakers;
    }

    public List<Animal> getHungryAnimals() {
        for (Animal animal1 : animals) {
            if (animal1.isHungry() && !hungryAnimals.contains(animal1)) {
                hungryAnimals.add(animal1);
            }
        }
        return hungryAnimals;
    }

    public HashMap<String, String> allAnimalVoices() {
        HashMap<String, String> result = new HashMap<>();
        for (Animal animal : animals) {
            result.put(animal.getName(), animal.getVoice());
        }
        return result;
    }

    public static void nextDay() {
        days++;
    }

    public static int getDays() {
        return days;
    }

}
