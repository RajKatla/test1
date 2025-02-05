package uk.co.ageas;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Requirement
 * -----------
 * The input is a "string" containing 4 digits 0 and 1 only ex: "1101" etc.
 * Using the below formula convert the input string into a number.
 * <p>
 * Formula:
 * "1101" = 11
 * 1*2(0) + 1*2(1) + 0*2(2) + 1*2(3) = 11
 * <p>
 * 2(0) - 2 to the power of 0
 * 2(1) - 2 to the power of 1 ... etc
 * <p>
 * Ensure that input string only contains 0 and 1, return 0 if this is not the case
 * <p>
 * ====================================================
 * Please use Java 8 functional style where applicable.
 * Run the test cases to check whether all the conditions have passed.
 */


public class Exercise2 {

    private static final Pattern BINARY_PATTERN = Pattern.compile("^[01]{4}$");

    private static String calculate(String input) {

        System.out.println("Input-->" + input);

        String result = "";

        if (!isValidBinary(input)) {
            return "Invalid input";
        }
        final int value = IntStream.range(0, input.length())
                .map(i -> Character.getNumericValue(input.charAt(i)) * (int) Math.pow(2, i))
                .sum();

        result = (value == 8) ? "I am default" : "I am " + value;

        return result;
    }

    private static boolean isValidBinary(String input) {
        return BINARY_PATTERN.matcher(input).matches();
    }

    public static String check(String input) {
        return calculate(input);
    }

}