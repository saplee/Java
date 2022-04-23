package ee.taltech.iti0202.exam;

import java.util.ArrayList;
import java.util.List;

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
            }
            else if (number % 10 == 0) {
                result.add(number);
                numberA = number;
                aBoolean = true;
            }
            else if (number % 10 != 0 && aBoolean == true) {
                result.add(numberA);
            }
        }return result;
    }
}
