package ee.taltech.iti0202.files.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputFilesBufferReader implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        Path path = Paths.get(filename);
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                } else {
                    result.add(line);
                }
            }
        } catch (IOException e) {
            throw new FileReaderException("No such file", e);
        }
        return result;
    }
}
