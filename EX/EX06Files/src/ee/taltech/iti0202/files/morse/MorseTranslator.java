package ee.taltech.iti0202.files.morse;


import java.io.BufferedReader;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.file.Files.newBufferedReader;

public class MorseTranslator {
    private HashMap<String, String> map = new HashMap<>();
    private HashMap<String, String> map2 = new HashMap<>();

    /**
     * @param lines
     * @return
     */
    public Map<String, String> addMorseCodes(List<String> lines) {
        for (String line : lines) {
            List<String> list = new ArrayList<>(List.of(line.trim().split(" ")));
            map.put(list.get(0).toLowerCase(), list.get(1));
        }
        for (String line : lines) {
            List<String> list = new ArrayList<>(List.of(line.trim().split(" ")));
            map2.put(list.get(1), list.get(0).toLowerCase());
        }
        return map;
    }

    /**
     *
     * @param filename
     * @return
     */
    public List<String> readTextFromFile(String filename) {
        Path path = Paths.get(filename);
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = newBufferedReader(path)) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                } else {
                    result.add(line);
                }
            }
        } catch (IOException e) {
            return null;
        }
        return result;
    }


    /**
     * @param lines
     * @return
     */
    public List<String> translateLinesToMorse(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            result.add(translateLineToMorse(line));
        }
        return result;
    }

    /**
     * @param lines
     * @return
     */
    public List<String> translateLinesFromMorse(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            result.add(translateLineFromMorse(line));
        }
        return result;
    }

    private String translateLineToMorse(String line) {
        String result = "";
        String word = line.toLowerCase().trim();
        for (int i = 0; i < line.length(); i++) {
            if (word.substring(i, i + 1).equals(" ")) {
                result += "\t";
            } else if (map.containsKey(word.substring(i, i + 1)) && i > 1 && word.charAt(i - 1) == ' ') {
                result += map.get(word.substring(i, i + 1));
            } else if (map.containsKey(word.substring(i, i + 1))) {
                result += " " + map.get(word.substring(i, i + 1));
            }
        }
        return result.trim();
    }

    private String translateLineFromMorse(String line) {
        String result = "";
        List<String> list = new ArrayList<>(List.of(line.split(" ")));
        for (String morse : list) {
            if (morse.contains("\t")) {
                result += map2.get(morse.substring(0, morse.indexOf("\t")));
                result += " ";
                result += map2.get(morse.substring(morse.indexOf("\t") + 1));
            } else if (map2.containsKey(morse)) {
                result += map2.get(morse);
            }
        }
        return result.trim();
    }

    public static void main(String[] args) {
        List<String> lit = new ArrayList<>(List.of(".-.. --- .-. . --\t.. .--. ... ..- --\t-.. --- .-.. --- .-.\t... .. -\t.- -- . - --..--\t-.-. --- -. ... . -.-. - . - ..- .-.\t.- -.. .. .--. .. ... -.-. .. -. --.\t. .-.. .. - --..--"));
        MorseTranslator morseTranslator = new MorseTranslator();
        morseTranslator.addMorseCodes(morseTranslator.readTextFromFile("/Users/sanderpleesi1/Downloads/morse.txt"));
        System.out.println(morseTranslator.translateLinesFromMorse(lit));
    }
}
