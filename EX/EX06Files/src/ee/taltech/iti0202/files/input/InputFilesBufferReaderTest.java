package ee.taltech.iti0202.files.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputFilesBufferReaderTest {
    @BeforeEach
    void setUp() {
    }
    @Test
    void bufferReader(){
        InputFilesBufferReader inputFilesBufferReader = new InputFilesBufferReader();
        List<String> result = new ArrayList<>(List.of("Java", "Python"));
        assertEquals(result,inputFilesBufferReader.readTextFromFile("/Users/sanderpleesi1/Downloads/Test.txt"));
    }

}
