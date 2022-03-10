package ee.taltech.iti0202.zoo;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zoo {
    public int days;
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

    public void nextDay() {
        for (Animal animal : animals) {
            animal.nextDay();
        }
    }

    public int getDays() {
        return days;
    }

    public String getBestWorker() {
        int number = 0;
        String result = "";
        for (Caretaker caretaker : caretakers) {
            if (caretaker.caretakerCanFeed(getHungryAnimals()).size() > number) {
                number = caretaker.caretakerCanFeed(getHungryAnimals()).size();
                result = caretaker.getName();
            }
        }
        return result + " oleks hetkel kõige efektiivsem töötaja.";
    }
}
