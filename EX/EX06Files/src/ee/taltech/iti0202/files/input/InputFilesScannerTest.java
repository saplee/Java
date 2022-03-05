package ee.taltech.iti0202.files.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class InputFilesScannerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void scannerReader() {
        InputFilesScanner inputFilesScanner = new InputFilesScanner();
        List<String> result = new ArrayList<>(List.of("Java", "Python"));
        Assertions.assertEquals(result, inputFilesScanner.readTextFromFile("/Users/sanderpleesi1/Downloads/Test.txt"));
    }
}
