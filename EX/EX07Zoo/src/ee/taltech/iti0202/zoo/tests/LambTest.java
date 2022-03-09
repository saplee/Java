package ee.taltech.iti0202.zoo.tests;

import ee.taltech.iti0202.zoo.Zoo;
import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.animal.Lamb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LambTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void TestGetLambVoice() {
        Lamb lamb = new Lamb("Jan", 3);
        Zoo zoo = new Zoo();
        zoo.addAnimal(lamb);
        assertEquals("mää", lamb.getVoice());
    }

    @Test
    void TestGetLambVoice2() {
        Lamb lamb = new Lamb("Jan", 5);
        Zoo zoo = new Zoo();
        zoo.addAnimal(lamb);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        assertEquals("mää", lamb.getVoice());
    }

    @Test
    void TestGetLambType() {
        Lamb lamb = new Lamb("Jan", 5);
        Zoo zoo = new Zoo();
        zoo.addAnimal(lamb);
        assertEquals(Animal.Type.MAMMAL, lamb.getType());
    }

    @Test
    void TestIsLambHungry() {
        Lamb lamb = new Lamb("Jan", 2);
        Zoo zoo = new Zoo();
        zoo.addAnimal(lamb);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        assertFalse(lamb.isHungry());
    }
}