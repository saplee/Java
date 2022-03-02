package ee.taltech.iti0202.shelter.shelter;

import ee.taltech.iti0202.shelter.animal.Animal;
import ee.taltech.iti0202.shelter.animal.Hirola;
import ee.taltech.iti0202.shelter.animalprovider.AnimalProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AnimalShelter {
    private AnimalProvider animalProvider;
    private LinkedList<Animal> result = new LinkedList<>();

    /**
     * @param animalProvider
     */
    public AnimalShelter(AnimalProvider animalProvider) {
        this.animalProvider = animalProvider;
    }

    /**
     * Gets a list of up to {count} animals with the given {type} and {color}.
     * This method should use animal provider which is set in constructor.
     * As the provider only can filter by type, you have to filter by color yourself.
     * Also, the number of results from provider is not defined, you have to call the provider
     * multiple times to get all the results (but not more than required).
     * The results should come in the order provided by the provider.
     * Also, provider can return duplicate animals. You should return only unique animals.
     * If the provider returns an empty list, stop calling it
     * and return whatever you have by that point.
     *
     * @param animalType Type.
     * @param color      Color used when filtering.
     * @param count      Maximum number of result to return.
     * @return Maximum {count} number of animals with the given type and color.
     */
    public List<Animal> getAnimals(Animal.Type animalType, String color, int count) {
        while (true) {
            List<Animal> myList = animalProvider.provide(animalType);
            if (myList.size() != 0) {
                for (Animal animal : myList) {
                    if (result.size() == count) {
                        return result;
                    } else if (animal.getColor().equals(color)) {
                        result.add(animal);
                    }
                }
            } else if (myList.size() == 0) {
                return result;
            }
        }
    }

    public static void main(String[] args) {
        AnimalProvider animalProvid = new AnimalProvider() {
            @Override
            public List<Animal> provide(Animal.Type type) {
                List<Animal> animals = new ArrayList<>();
                Animal animal = new Hirola("red");
                animals.add(animal);
                animals.add(animal);
                animals.add(animal);
                animals.add(animal);
                animals.add(animal);
                animals.add(animal);
                animals.add(animal);
                return animals;
            }
        };
        AnimalShelter animalShelter = new AnimalShelter(animalProvid);
        System.out.println(animalShelter.getAnimals(Animal.Type.HIROLA, "red", 3));
    }
}
