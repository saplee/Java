package ee.taltech.iti0202.files.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputFilesLinesTest {

    @BeforeEach
    void setUp() {
    }
    @Test
    void linesReader(){
        InputFilesLines inputFilesLines = new InputFilesLines();
        List<String> result = new ArrayList<>(List.of("Java", "Python"));
        assertEquals(result,inputFilesLines.readTextFromFile("/Users/sanderpleesi1/Downloads/Test.txt"));
    }
}
