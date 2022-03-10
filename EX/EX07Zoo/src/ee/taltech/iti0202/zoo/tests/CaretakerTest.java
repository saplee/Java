package ee.taltech.iti0202.zoo.tests;

import ee.taltech.iti0202.zoo.Zoo;
import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.animal.Monkey;
import ee.taltech.iti0202.zoo.animal.Turtle;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CaretakerTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testCaretakerName() {
        List<Animal.Type> types = new ArrayList<>(List.of(Animal.Type.FISH, Animal.Type.BIRD));
        Caretaker caretaker = new Caretaker("Ago", types);
        assertEquals("Ago", caretaker.getName());
    }

    @Test
    void testGetTypes() {
        List<Animal.Type> types = new ArrayList<>(List.of(Animal.Type.FISH, Animal.Type.BIRD));
        Caretaker caretaker = new Caretaker("Ago", types);
        assertEquals(types, caretaker.getTypeCanFeed());
    }

    @Test
    void testGetBestCaretaker() {
        List<Animal.Type> types = new ArrayList<>(List.of(Animal.Type.AMPHIBIAN, Animal.Type.MAMMAL, Animal.Type.FISH));
        Caretaker caretaker = new Caretaker("Ago", types);
        List<Animal.Type> types2 = new ArrayList<>(List.of(Animal.Type.AMPHIBIAN, Animal.Type.FISH, Animal.Type.REPTILE, Animal.Type.BIRD));
        Caretaker caretaker2 = new Caretaker("Mati", types2);
        Zoo zoo = new Zoo();
        zoo.addCaretaker(caretaker);
        zoo.addCaretaker(caretaker2);
        Animal animal = new Animal("Ago", "Java", 1, Animal.Type.MAMMAL);
        Monkey monkey = new Monkey("pam", 4);
        Turtle turtle = new Turtle("John", 3);
        Animal animal1 = new Animal("Hai", "amps", 4, Animal.Type.FISH);
        zoo.addAnimal(animal);
        zoo.addAnimal(monkey);
        zoo.addAnimal(animal1);
        zoo.addAnimal(turtle);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        assertEquals("Ago oleks hetkel kõige efektiivsem töötaja.", zoo.getBestWorker());
    }

}