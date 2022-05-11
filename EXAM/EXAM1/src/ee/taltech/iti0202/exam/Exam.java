package ee.taltech.iti0202.exam;

import java.util.ArrayList;
import java.util.List;

public class Exam {

    /**
     * Given a list of numbers, count how many 2-s are alone (no 2 before or after it).
     * <p>
     * countSingleTwos([2, 2, 1, 3]) => 0
     * countSingleTwos([7, 6, 1, 3]) => 0
     * countSingleTwos([2, 2, 1, 2]) => 1
     * countSingleTwos([2, 2, 2, 1, 3, 2, 1, 2]) => 2
     */
    public static int countSingleTwos(List<Integer> numbers) {
        int previousNumber = 0;
        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1 && numbers.get(i) == 2 && previousNumber != 2) {
                result += 1;
            } else if (i < numbers.size() - 1 && previousNumber != 2 && numbers.get(i + 1) != 2 && numbers.get(i) == 2) {
                result += 1;
                previousNumber = numbers.get(i);
            } else {
                previousNumber = numbers.get(i);
            }
        }
        return result;
    }

    /**
     * Write a method that takes a string and decodes it.
     * The string may contain some numbers.
     * All numbers need to be replaced with a corresponding letter from the alphabet.
     * Each number n references to n-th character of the lowercase alphabet (abcdefghijklmnopqrstuvwxyz).
     * If n is out of bounds, then it should start from "a" again. (0, 26 and 52 correspond to "a")
     * <p>
     * Examples:
     * decodeMessage("0") => "a"
     * decodeMessage("0b2d4f6") => "abcdefg"
     * decodeMessage("h8") => "hi"
     * decodeMessage("11o11") => "lol"
     * decodeMessage("h8 th4r30 p17ogramme43") => "hi there programmer"
     * decodeMessage(":14 19h8s 8s 84e45t34n58 54oo37e523423") => ":o this is getting cooler"
     * decodeMessage("This one doesn't need to be changed!") => "This one doesn't need to be changed!"
     *
     * @param message the message that needs to be decoded
     * @return decoded message
     */
    public static String decodeMessage(String message) {
        return "";
    }
}