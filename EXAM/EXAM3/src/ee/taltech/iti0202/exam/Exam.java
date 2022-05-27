package ee.taltech.iti0202.exam;

public class Exam {

    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i < number; i++)
            if (number % i == 0)
                return false;

        return true;
    }

    /**
     * Find the prime factors of a number and return the sum of all the factors.
     * 0 and 1 are not prime.
     * <p>
     * Examples:
     * primeFactorsSum(10) => 2 + 5 => 7
     * Prime factors of 10 are 2 * 5 => 2 + 5 => answer is 7
     * <p>
     * primeFactorsSum(102) => 22
     * Prime factors of 102 are 2 * 3 * 17 => 2 + 3 + 17 => answer is 22
     * <p>
     * primeFactorsSum(1) => 0
     * primeFactorsSum(40) => 11 (2 + 2 + 2 + 5)
     * primeFactorsSum(8881) => 190
     * primeFactorsSum(999961) => 999961
     *
     * @param num input number. 1 <= num <= 1000000
     * @return sum of all prime factors
     */
    public static int primeFactorsSum(int num) {
        int result = 0;
        int number = num;
        for (int i = num - 1; i > 1; i--) {
            if (number % i == 0 && isPrimeNumber(i)) {
                result += i;
                number = num / i;
            }
        }
        return result;
    }

    /**
     * Find the longest distance between two equal symbols.
     * <p>
     * The same symbol can contain in this distance.
     * <p>
     * If there are no equals symbols, return -1.
     * <p>
     * longestDistanceBetweenEqualSymbols("abcda") => 3
     * longestDistanceBetweenEqualSymbols("aaaa") => 2
     * longestDistanceBetweenEqualSymbols("aia") => 1
     * longestDistanceBetweenEqualSymbols("aiu") => -1
     * longestDistanceBetweenEqualSymbols("") => -1
     * longestDistanceBetweenEqualSymbols("abcdabbg") => 4
     *
     * @param s input string
     * @return longest distance
     */
    public static int longestDistanceBetweenEqualSymbols(String s) {
        return -1;
    }
}

