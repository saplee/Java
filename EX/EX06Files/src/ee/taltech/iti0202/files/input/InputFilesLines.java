package ee.taltech.iti0202.files.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputFilesLines implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        Path path = Paths.get(filename);
        List<String> result = new ArrayList<>();
        try {
            while (true) {
                Stream<String> lines = Files.lines(path);
                lines.forEach(s -> result.add(s));
                if (lines == null) break;
            }
        } catch (IOException e) {
            throw new FileReaderException("No such file", e);
        }
        return result;
    }
}
