package algorithms.codewars.SixKyu;

public class CharacterWithLongestConsecutiveRepetition {

    public static Object[] longestRepetition(String s) {


        if (s.length() == 0) {
            return new Object[] {"", 0};
        }

        char lastChar = '\0';
        int counter = 0;
        int max = 0;

        Object result[] = new Object[]{"", 0};
        for (char c: s.toCharArray()) {
            if (c == lastChar) {
                counter ++;
            } else {
                counter = 1;
            }
            if (counter > max) {
                result = new Object[]{""+c, counter};
                max = counter;
            }
            lastChar = c;
        }
        return result;
    }
}
