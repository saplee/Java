package ee.taltech.iti0202.zoo.tests;


import ee.taltech.iti0202.zoo.Zoo;
import ee.taltech.iti0202.zoo.animal.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AnimalTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void testGetName() {
        Animal animal = new Animal("Ago", "Java", 3, Animal.Type.MAMMAL);
        assertEquals("Ago", animal.getName());
    }

    @Test
    void testGetVoice() {
        Animal animal = new Animal("Ago", "Java", 3, Animal.Type.MAMMAL);
        assertEquals("Java", animal.getVoice());
    }

    @Test
    void testGetType() {
        Animal animal = new Animal("Ago", "Java", 3, Animal.Type.MAMMAL);
        assertEquals(Animal.Type.MAMMAL, animal.getType());
    }

    @Test
    void testGetVoice2() {
        Animal animal = new Animal("Ago", "Java", 1, Animal.Type.MAMMAL);
        Zoo zoo = new Zoo();
        zoo.addAnimal(animal);
        zoo.nextDay();
        zoo.nextDay();
        assertEquals("", animal.getVoice());
    }
}
