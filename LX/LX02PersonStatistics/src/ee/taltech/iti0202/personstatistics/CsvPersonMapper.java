package ee.taltech.iti0202.personstatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvPersonMapper {
    /**
     *
     */
    public CsvPersonMapper() {
    }

    /**
     *
     * @param path
     * @return
     */
    public List<Person> mapToPersons(String path) {
        Path path1 = Paths.get(path);
        List<Person> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path1)) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                } else {
                    List<String> person = List.of(line.split(","));
                    Gender gender;
                    if (person.get(3).equals("MALE")) {
                        gender = Gender.MALE;
                    } else {
                        gender = Gender.FEMALE;
                    }
                    result.add(new Person(person.get(0), person.get(1), Integer.parseInt(person.get(2)), gender,
                            Double.parseDouble(person.get(4)), person.get(5), person.get(5 + 1)));
                }
            }
        } catch (IOException e) {
            throw new CsvToPersonMappingException();
        }
        return result;
    }
}
