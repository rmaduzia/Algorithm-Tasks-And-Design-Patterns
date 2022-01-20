package algorithms.codewars.SixKyu;

import java.util.Arrays;
import java.util.List;

public class ConsonantValue {

    public static int solve(final String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int highestValue = 0;
        int actualValue=0;

        for (char c: s.toCharArray()) {
            if (!vowels.contains(c)) {
                actualValue += c -96;
            } else {
                if (actualValue > highestValue) {
                    highestValue = actualValue;
                }
                System.out.println(actualValue);
                actualValue=0;
            }
        }
        return Math.max(highestValue, actualValue);
    }
}
