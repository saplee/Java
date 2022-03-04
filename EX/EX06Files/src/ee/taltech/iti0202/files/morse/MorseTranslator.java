package ee.taltech.iti0202.files.morse;

import java.util.*;

public class MorseTranslator {
    private HashMap<String, String> map = new HashMap<>();

    /**
     * @param lines
     * @return
     */
    public Map<String, String> addMorseCodes(List<String> lines) {
        for (String line : lines) {
            List<String> list = new ArrayList<>(List.of(line.trim().split(" ")));
            map.put(list.get(0).toLowerCase(), list.get(1));
        }
        return map;
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
        String word = line.toLowerCase().trim();
        for (String key : map.keySet()) {
            for (int i = 0; i < line.length(); i++) {
                if (word.substring(i, i + 1).equals("\t")) {
                    result += " ";
                    break;
                } else if (map.get(key).equals(word.substring(i, i + 1))) {
                    result += key;
                    break;
                }
            }
        }
        return result.trim();
    }
}
