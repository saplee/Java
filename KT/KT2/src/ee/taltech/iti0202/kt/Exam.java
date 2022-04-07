package ee.taltech.iti0202.kt;

import java.util.HashSet;
import java.util.Set;

public class Exam {
    /**
     * Given an array of integers,
     * every element appears twice except for one. Find that single one.
     * If there are not such (and in any other case) return 0.
     * <p>
     * singleNumber([2, 2, 1]) => 1
     * singleNumber([4, 1, 2, 1, 2]) => 4
     */
    public static int singleNumber(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        for (int number : nums) {
            if (!numberSet.contains(number)) {
                numberSet.add(number);
                int count = 0;
                for (int num : nums) {
                    if (num == number) {
                        count++;
                    }
                }
                if (count == 1) {
                    return number;
                }
            }
        }
        return 0;
    }

    /**
     * Calculate the result of the expression.
     * <p>
     * The input contains of only digits, plus and minus sign.
     * <p>
     * "1+2" => 3
     * "3" => 3
     * "" => 0
     * "-4+5" => 1
     */
    public static int calculate(String expression) {
        int result = 0;
        String calculate = "+";
        String number = "";
        if (expression.length() == 0) {
            return 0;
        }
        for (int i = 0; i < expression.length(); i++) {
            String c = expression.substring(i, i + 1);
            if ((c.equals("+") || c.equals("-"))) {
                if (calculate.equals("+") && number.length() != 0) {
                    result += Integer.parseInt(number);
                } else if (calculate.equals("-") && number.length() != 0) {
                    result -= Integer.parseInt(number);
                }
                calculate = c;
                number = "";
            } else {
                number += c;
            }
        }
        if (number.length() != 0) {
            if (calculate.equals("+")) {
                result += Integer.parseInt(number);
            } else if (calculate.equals("-")) {
                result -= Integer.parseInt(number);
            }
        }
        return result;
    }
}

