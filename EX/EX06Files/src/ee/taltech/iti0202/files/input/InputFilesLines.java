package ee.taltech.iti0202.files.input;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputFilesLines implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> result = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            result = stream.collect(Collectors.toList());

        } catch (IOException e) {
            throw new FileReaderException("No such file", e);
        }
        return result;
    }
}
