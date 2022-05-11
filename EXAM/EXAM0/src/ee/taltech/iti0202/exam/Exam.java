package ee.taltech.iti0202.exam;

import java.util.*;

public class Exam {


    /**
     * 01
     * <p>
     * For each multiple of 10 in the given array,
     * change all the values following it to be that multiple of 10,
     * until encountering another multiple of 10.
     * So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
     * <p>
     * tenRun([2, 10, 3, 4, 20, 5]) => [2, 10, 10, 10, 20, 20]
     * tenRun([10, 1, 20, 2]) => [10, 10, 20, 20]
     * tenRun([10, 1, 9, 20]) => [10, 10, 10, 20]
     */
    public static List<Integer> tenRun(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        Integer numberA = 0;
        boolean aBoolean = false;
        for (Integer number : nums) {
            if (number % 10 != 0 && aBoolean == false) {
                result.add(number);
            } else if (number % 10 == 0) {
                result.add(number);
                numberA = number;
                aBoolean = true;
            } else if (number % 10 != 0 && aBoolean == true) {
                result.add(numberA);
            }
        }
        return result;
    }

    /**
     * 02
     * <p>
     * Write a method that analyzes input String and returns all pairs of same letter that is present as lower-case and upper-case in input String.
     * Returned letter pairs have to be in alphabetic order. If there are multiple same letter pairs, then return only one. If there are no suitable pairs, return "".
     * Take latin alphabet 'a' - 'z' as base.
     * mixedPairs("abcABD") => "AaBb" (a and b are represented by both lowe and upper cased letter)
     * mixedPairs("aaaAAAaaaa") => "Aa"
     * mixedPairs("tere") => ""
     * mixedPairs("bBaacA") => "AaBb" (result is in alphabetic order, although in input String, b is earlier than a).
     *
     * @param input
     * @return
     */
    public static String mixedPairs(String input) {
        List<String> result = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            hashSet.add(String.valueOf(input.charAt(i)));
        }
        String lastWord = "";
        for (int i = 0; i < input.length(); i++) {
            String upper = String.valueOf(Character.toUpperCase(input.charAt(i)));
            String lower = String.valueOf(Character.toLowerCase(input.charAt(i)));
            if (!result.contains(upper) && !result.contains(lower) && hashSet.contains(upper) && hashSet.contains(lower)) {
                result.add(lower);
            }
        }
        if (result.size() == 0) {
            return lastWord;
        } else {
            List<String> newResult = result.stream().sorted().toList();
            for (String s : newResult) {
                lastWord += s.toUpperCase() + s;
            }
        }
        return lastWord;
    }
}
