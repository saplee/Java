package ee.taltech.iti0202.zoo.tests;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CaretakerTest {
    @BeforeEach
    void setUp() {}
    @Test
    void TestCaretakerName(){
        List<Animal.Type> types = new ArrayList<>(List.of(Animal.Type.FISH, Animal.Type.BIRD));
        Caretaker caretaker = new Caretaker("Ago", types);
        assertEquals("Ago", caretaker.getName());
    }
    @Test
    void TestGetTypes(){
        List<Animal.Type> types = new ArrayList<>(List.of(Animal.Type.FISH, Animal.Type.BIRD));
        Caretaker caretaker = new Caretaker("Ago", types);
        assertEquals(types, caretaker.getTypeCanFeed());
    }

}