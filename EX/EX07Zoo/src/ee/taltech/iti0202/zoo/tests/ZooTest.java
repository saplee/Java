package ee.taltech.iti0202.zoo.tests;

import ee.taltech.iti0202.zoo.Zoo;
import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.animal.Monkey;
import ee.taltech.iti0202.zoo.animal.Turtle;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ZooTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetAnimals() {
        Monkey monkey = new Monkey("pam", 4);
        Animal animal = new Animal("Ago", "Java", 1, Animal.Type.MAMMAL);
        Turtle turtle = new Turtle("John", 3);
        Zoo zoo = new Zoo();
        zoo.addAnimal(monkey);
        zoo.addAnimal(animal);
        zoo.addAnimal(turtle);
        List<Animal> result = new ArrayList<>(List.of(monkey, animal, turtle));
        Assertions.assertEquals(result, zoo.getAnimals());
    }

    @Test
    void testGetCaretakers() {
        Monkey monkey = new Monkey("pam", 4);
        Animal animal = new Animal("Ago", "Java", 1, Animal.Type.MAMMAL);
        Turtle turtle = new Turtle("John", 3);
        Zoo zoo = new Zoo();
        List<Animal.Type> types = new ArrayList<>(List.of(Animal.Type.FISH, Animal.Type.BIRD));
        Caretaker caretaker = new Caretaker("Han", types);
        zoo.addCaretaker(caretaker);
        zoo.addAnimal(monkey);
        zoo.addAnimal(animal);
        zoo.addAnimal(turtle);
        List<Caretaker> result = new ArrayList<>(List.of(caretaker));
        Assertions.assertEquals(result, zoo.getCaretaker());
    }

    @Test
    void testGetHungryAnimals() {
        Monkey monkey = new Monkey("pam", 4);
        Animal animal = new Animal("Ago", "Java", 3, Animal.Type.MAMMAL);
        Turtle turtle = new Turtle("John", 3);
        Zoo zoo = new Zoo();
        List<Animal.Type> types = new ArrayList<>(List.of(Animal.Type.FISH, Animal.Type.BIRD));
        Caretaker caretaker = new Caretaker("Han", types);
        zoo.addCaretaker(caretaker);
        zoo.addAnimal(monkey);
        zoo.addAnimal(animal);
        zoo.addAnimal(turtle);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        List<Animal> result = new ArrayList<>();
        Assertions.assertEquals(result, zoo.getHungryAnimals());
    }

    @Test
    void testGetHungryAnimals2() {
        Monkey monkey = new Monkey("pam", 4);
        Animal animal = new Animal("Ago", "Java", 3, Animal.Type.MAMMAL);
        Turtle turtle = new Turtle("John", 3);
        Zoo zoo = new Zoo();
        List<Animal.Type> types = new ArrayList<>(List.of(Animal.Type.FISH, Animal.Type.BIRD));
        Caretaker caretaker = new Caretaker("Han", types);
        zoo.addCaretaker(caretaker);
        zoo.addAnimal(monkey);
        zoo.addAnimal(animal);
        zoo.addAnimal(turtle);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        List<Animal> result = new ArrayList<>(List.of(monkey, animal, turtle));
        Assertions.assertEquals(result, zoo.getHungryAnimals());
    }

    @Test
    void testGetHungryAnimalsWrongCaretaker() {
        Monkey monkey = new Monkey("pam", 4);
        Animal animal = new Animal("Ago", "Java", 3, Animal.Type.MAMMAL);
        Turtle turtle = new Turtle("John", 3);
        Zoo zoo = new Zoo();
        List<Animal.Type> types = new ArrayList<>(List.of(Animal.Type.FISH, Animal.Type.BIRD));
        Caretaker caretaker = new Caretaker("Han", types);
        zoo.addCaretaker(caretaker);
        zoo.addAnimal(monkey);
        zoo.addAnimal(animal);
        zoo.addAnimal(turtle);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        animal.giveFood(caretaker);
        monkey.giveFood(caretaker);
        turtle.giveFood(caretaker);
        List<Animal> result = new ArrayList<>(List.of(monkey, animal, turtle));
        Assertions.assertEquals(result, zoo.getHungryAnimals());
    }

    @Test
    void testGetHungryAnimalVoices() {
        Monkey monkey = new Monkey("pam", 4);
        Animal animal = new Animal("Ago", "Java", 3, Animal.Type.MAMMAL);
        Turtle turtle = new Turtle("John", 3);
        Zoo zoo = new Zoo();
        List<Animal.Type> types = new ArrayList<>(List.of(Animal.Type.FISH, Animal.Type.BIRD));
        Caretaker caretaker = new Caretaker("Han", types);
        zoo.addCaretaker(caretaker);
        zoo.addAnimal(monkey);
        zoo.addAnimal(animal);
        zoo.addAnimal(turtle);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        animal.giveFood(caretaker);
        monkey.giveFood(caretaker);
        turtle.giveFood(caretaker);
        HashMap<String, String> result = new HashMap<>();
        result.put("pam", "BANANA");
        result.put("John", "");
        result.put("Ago", "");
        Assertions.assertEquals(result, zoo.allAnimalVoices());
    }

    @Test
    void testGetHungryAnimalsAfterFood() {
        Monkey monkey = new Monkey("pam", 4);
        Animal animal = new Animal("Ago", "Java", 3, Animal.Type.MAMMAL);
        Turtle turtle = new Turtle("John", 3);
        Zoo zoo = new Zoo();
        List<Animal.Type> types = new ArrayList<>(List.of(Animal.Type.FISH, Animal.Type.MAMMAL));
        Caretaker caretaker = new Caretaker("Han", types);
        zoo.addCaretaker(caretaker);
        zoo.addAnimal(monkey);
        zoo.addAnimal(animal);
        zoo.addAnimal(turtle);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        animal.giveFood(caretaker);
        monkey.giveFood(caretaker);
        turtle.giveFood(caretaker);
        List<Animal> result = new ArrayList<>(List.of(turtle));
        Assertions.assertEquals(result, zoo.getHungryAnimals());
    }
}
