package ee.taltech.iti0202.files.morse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MorseTranslatorTest {

    @BeforeEach
    void setUp() {
    }
    @Test
    void morseTests(){
        MorseTranslator morseTranslator = new MorseTranslator();
        List<String> lines = new ArrayList<>(List.of("java, python"));
        morseTranslator.addMorseCodes(morseTranslator.readTextFromFile(
                "/Users/sanderpleesi1/Downloads/morse.txt"));
        List<String> morse = morseTranslator.translateLinesToMorse(lines);
        List<String> string = morseTranslator.translateLinesFromMorse(morse);
        assertEquals(lines, string);
    }
}
