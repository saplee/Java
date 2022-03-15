package ee.taltech.iti0202.zoo.tests;


import ee.taltech.iti0202.zoo.Zoo;
import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.animal.AnimalBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AnimalTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void testGetName() {
        Animal animal = new AnimalBuilder().setName("Ago").setVoice("Java").setEatTime(3).setType(Animal.Type.MAMMAL)
                .createAnimal();
        assertEquals("Ago", animal.getName());
    }

    @Test
    void testGetVoice() {
        Animal animal = new AnimalBuilder().setName("Ago").setVoice("Java").setEatTime(3)
                .setType(Animal.Type.MAMMAL).createAnimal();
        assertEquals("Java", animal.getVoice());
    }

    @Test
    void testGetType() {
        Animal animal = new AnimalBuilder().setName("Ago").setVoice("Java").setEatTime(3).setType(Animal.Type.MAMMAL)
                .createAnimal();
        assertEquals(Animal.Type.MAMMAL, animal.getType());
    }

    @Test
    void testGetVoice2() {
        Animal animal = new AnimalBuilder().setName("Ago").setVoice("Java").setEatTime(1).setType(Animal.Type.MAMMAL)
                .createAnimal();
        Zoo zoo = new Zoo();
        zoo.addAnimal(animal);
        zoo.nextDay();
        zoo.nextDay();
        assertEquals("", animal.getVoice());
    }
}
