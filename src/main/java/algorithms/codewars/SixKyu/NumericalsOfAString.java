package algorithms.codewars.SixKyu;

import java.util.HashMap;
import java.util.Map;

public class NumericalsOfAString {

    public static String numericals(String s) {

        Map<Character, Integer> chars = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()) {

            if (chars.get(c) != null) {
                chars.put(c, chars.get(c) + 1);
                sb.append(chars.get(c));
            } else {
                chars.put(c, 1);
                sb.append(1);
            }
        }

        return sb.toString();
    }
}
