package ee.taltech.iti0202.zoo.tests;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.animal.Turtle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurtleTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetTurtleType() {
        Turtle turtle = new Turtle("John", 3);
        Assertions.assertEquals(Animal.Type.AMPHIBIAN, turtle.getType());
    }

    @Test
    void testGetTurtleName() {
        Turtle turtle = new Turtle("John", 3);
        Assertions.assertEquals("John", turtle.getName());
    }

    @Test
    void testGetTurtleVoiceWhenNotHungry() {
        Turtle turtle = new Turtle("John", 3);
        turtle.nextDay();
        turtle.nextDay();
        Assertions.assertEquals("", turtle.getVoice());
    }

    @Test
    void testGetTurtleVoiceWhenHungry() {
        Turtle turtle = new Turtle("John", 3);
        turtle.nextDay();
        turtle.nextDay();
        turtle.nextDay();
        turtle.nextDay();
        Assertions.assertEquals("", turtle.getVoice());
    }

}
