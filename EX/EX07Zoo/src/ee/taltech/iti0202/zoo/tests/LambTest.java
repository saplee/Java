package ee.taltech.iti0202.zoo.tests;

import ee.taltech.iti0202.zoo.Zoo;
import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.animal.Lamb;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LambTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetLambVoice() {
        Lamb lamb = new Lamb("Jan", 3);
        Zoo zoo = new Zoo();
        zoo.addAnimal(lamb);
        Assertions.assertEquals("mää", lamb.getVoice());
    }

    @Test
    void testGetLambVoice2() {
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
        Assertions.assertEquals("mää", lamb.getVoice());
    }

    @Test
    void testGetLambType() {
        Lamb lamb = new Lamb("Jan", 5);
        Zoo zoo = new Zoo();
        zoo.addAnimal(lamb);
        Assertions.assertEquals(Animal.Type.MAMMAL, lamb.getType());
    }

    @Test
    void testIsLambHungry() {
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
        Assertions.assertFalse(lamb.isHungry());
    }
}
