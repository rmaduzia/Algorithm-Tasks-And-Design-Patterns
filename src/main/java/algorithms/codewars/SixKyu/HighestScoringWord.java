package algorithms.codewars.SixKyu;

public class HighestScoringWord {

    public static String high(String s) {

        String[] words = s.split(" ");
        int highest = 0;
        int actual = 0;
        String result = words[0];
        int substractionForLowerCaseChar = 96; //for lower case

        for (String value: words) {
            char[] chars = value.toCharArray();
            for (char c: chars) {
                actual = actual + (int) c - substractionForLowerCaseChar;
                System.out.println("actual: " + actual  + " |" + c);
            }
            if (actual > highest) {
                highest = actual;
                result = value;
            }
            actual = 0;
        }
        return result;
    }
}
