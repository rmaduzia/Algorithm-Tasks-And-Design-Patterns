package algorithms.codewars.SixKyu;

import java.util.stream.IntStream;

public class MexicanWave {

    public static String[] wave(String str) {
        return IntStream.range(0, str.length())
                .mapToObj(x -> new StringBuilder(str).replace(x, x+1, String.valueOf(str.charAt(x)).toUpperCase()).toString())
                .filter(x -> !x.equals(str))
                .toArray(String[]::new);
    }
}
