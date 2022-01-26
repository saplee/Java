
package ee.taltech.iti0202.idcode;

public class IdCode {

    private final String idCodeValue;

    enum Gender {
        MALE, FEMALE
    }

    /**
     * Method returns the id code.
     *
     * @return id code.
     */
    public String getIdCodeValue() {
        return idCodeValue;
    }

    public IdCode(String idCodeValue) {
        this.idCodeValue = idCodeValue;
    }

    /**
     * Check if the id code is valid or not.
     *
     * @return boolean describing whether or not the id code was correct.
     */
    public boolean isCorrect() {
        return false;
    }

    /**
     * Get all information about id code.
     *
     * @return String containing information.
     */
    public String getInformation() {
        return null;
    }

    /**
     * Get gender enum.
     *
     * @return enum describing person's gender
     */
    public Gender getGender() {
        return null;
    }

    /**
     * Get person's birth location.
     *
     * @return String with the person's birth place.
     */
    public String getBirthPlace() {
        int birthPlace = Integer.parseInt(idCodeValue.substring(7, 10));
        if (1 <= birthPlace && 10 >= birthPlace) {
            return "Kuressaare";
        } else if (11 <= birthPlace && 20 >= birthPlace) {
            return "Tartu";
        } else if (21 <= birthPlace && 220 >= birthPlace) {
            return "Tallinn";
        } else if (221 <= birthPlace && 270 >= birthPlace) {
            return "Kohtla-Järve";
        } else if (271 <= birthPlace && 370 >= birthPlace) {
            return "Tartu";
        } else if (371 <= birthPlace && 420 >= birthPlace) {
            return "Narva";
        } else if (421 <= birthPlace && 470 >= birthPlace) {
            return "Pärnu";
        } else if (471 <= birthPlace && 490 >= birthPlace) {
            return "Tallinn";
        } else if (491 <= birthPlace && 520 >= birthPlace) {
            return "Paide";
        } else if (521 <= birthPlace && 570 >= birthPlace) {
            return "Rakvere";
        } else if (571 <= birthPlace && 600 >= birthPlace) {
            return "Valga";
        } else if (601 <= birthPlace && 650 >= birthPlace) {
            return "Viljandi";
        } else if (651 <= birthPlace && 700 >= birthPlace) {
            return "Võru";
        } else if (701 <= birthPlace) {
            return "unknown";
        }
        return "unknown";
    }

    /**
     * Get the year that the person was born in.
     *
     * @return int with person's birth year.
     */
    public int getFullYear() {
        return 0;
    }

    /**
     * Check if gender number is correct.
     *
     * @return boolean describing whether the gender number is correct.
     */
    private boolean isGenderNumberCorrect() {
        return false;
    }

    /**
     * Check if the year number is correct.
     *
     * @return boolean describing whether the year number is correct.
     */
    private boolean isYearNumberCorrect() {
        return false;
    }

    /**
     * Check if the month number is correct.
     *
     * @return boolean describing whether the month number is correct.
     */
    private boolean isMonthNumberCorrect() {
        int value = Integer.parseInt(idCodeValue.substring(3, 5));
        if (0 <= value && value <= 12) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if the day number is correct.
     *
     * @return boolean describing whether the day number is correct.
     */
    private boolean isDayNumberCorrect() {
        return false;
    }

    /**
     * Check if the control number is correct.
     *
     * @return boolean describing whether the control number is correct.
     */
    private boolean isControlNumberCorrect() {
        int lastNumber = Integer.parseInt(idCodeValue.substring(10));
        int firstSum = Integer.parseInt(idCodeValue.substring(0, 1)) + 2 * Integer.parseInt(idCodeValue.substring(1, 2)) + 3 * Integer.parseInt(idCodeValue.substring(2, 3)) + 4 * Integer.parseInt(idCodeValue.substring(3, 4)) + 5 * Integer.parseInt(idCodeValue.substring(4, 5)) + 6 * Integer.parseInt(idCodeValue.substring(5, 6)) + 7 * Integer.parseInt(idCodeValue.substring(6, 7)) + 8 * Integer.parseInt(idCodeValue.substring(7, 8)) + 9 * Integer.parseInt(idCodeValue.substring(8, 9)) + Integer.parseInt(idCodeValue.substring(9, 10));
        int secondSum = 3 * Integer.parseInt(idCodeValue.substring(0, 1)) + 4 * Integer.parseInt(idCodeValue.substring(1, 2)) + 5 * Integer.parseInt(idCodeValue.substring(2, 3)) + 6 * Integer.parseInt(idCodeValue.substring(3, 4)) + 7 * Integer.parseInt(idCodeValue.substring(4, 5)) + 8 * Integer.parseInt(idCodeValue.substring(5, 6)) + 9 * Integer.parseInt(idCodeValue.substring(6, 7)) + Integer.parseInt(idCodeValue.substring(7, 8)) + 2 * Integer.parseInt(idCodeValue.substring(8, 9)) + 3 * Integer.parseInt(idCodeValue.substring(9, 10));
        if (firstSum % 11 == lastNumber) {
            return true;
        } else if (secondSum % 11 == lastNumber && firstSum % 11 >= 10) {
            return true;
        } else if (secondSum % 11 >= 10 && lastNumber == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if the given year is a leap year.
     *
     * @param fullYear
     * @return boolean describing whether the given year is a leap year.
     */
    private boolean isLeapYear(int fullYear) {
        return false;
    }

    /**
     * Run tests.
     *
     * @param args info.
     */
    public static void main(String[] args) {
        IdCode validMaleIdCode = new IdCode("37605030299");
        System.out.println(validMaleIdCode.isCorrect());
        System.out.println(validMaleIdCode.getInformation());
        System.out.println(validMaleIdCode.getGender());
        System.out.println(validMaleIdCode.getBirthPlace());
        System.out.println(validMaleIdCode.getFullYear());
        System.out.println(validMaleIdCode.isGenderNumberCorrect());
        System.out.println(validMaleIdCode.isYearNumberCorrect());
        System.out.println(validMaleIdCode.isMonthNumberCorrect());
        System.out.println(validMaleIdCode.isDayNumberCorrect());
        System.out.println(validMaleIdCode.isControlNumberCorrect());
        System.out.println(validMaleIdCode.isLeapYear(validMaleIdCode.getFullYear()));
    }

}

