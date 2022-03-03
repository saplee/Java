package ee.taltech.iti0202.files.morse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseTranslator {
    private HashMap<String, String> map = new HashMap<>();

    public Map<String, String> addMorseCodes(List<String> lines) {
        for (String line : lines) {
            List<String> list = new ArrayList<>(List.of(line.split(" ")));
            map.put(list.get(0), list.get(1));
        }
        return map;
    }

    public List<String> translateLinesToMorse(List<String> lines) {
        return null;
    }

    public List<String> translateLinesFromMorse(List<String> lines) {
        return null;
    }

    private String translateLineToMorse(String line) {
        return null;
    }

    private String translateLineFromMorse(String line) {
        return null;
    }
}
