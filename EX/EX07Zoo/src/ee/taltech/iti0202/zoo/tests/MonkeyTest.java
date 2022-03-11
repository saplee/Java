package ee.taltech.iti0202.zoo.tests;

import ee.taltech.iti0202.zoo.Zoo;
import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.animal.Monkey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MonkeyTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetMonkeyVoice() {
        List<String> voice = new ArrayList<>(List.of("uuh", "ääh"));
        Monkey monkey = new Monkey("pam", 4);
        Zoo zoo = new Zoo();
        zoo.addAnimal(monkey);
        zoo.nextDay();
        assertTrue(voice.contains(monkey.getVoice()));
    }

    @Test
    void testGetMonkeyVoiceWhenHungry() {
        Monkey monkey = new Monkey("pam", 4);
        Zoo zoo = new Zoo();
        zoo.addAnimal(monkey);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        assertEquals("BANANA", monkey.getVoice());
    }

    @Test
    void testGetMonkeyType() {
        Monkey monkey = new Monkey("pam", 4);
        Zoo zoo = new Zoo();
        zoo.addAnimal(monkey);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        assertEquals(Animal.Type.MAMMAL, monkey.getType());
    }

    @Test
    void testGetMonkey2Voice() {
        Monkey monkey = new Monkey("pam", 4);
        Monkey monkey2 = new Monkey("lan", 4);
        List<String> voice = new ArrayList<>(List.of("uuh", "ääh"));
        Zoo zoo = new Zoo();
        zoo.addAnimal(monkey);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.addAnimal(monkey2);
        assertTrue(voice.contains(monkey2.getVoice()));
    }

}
