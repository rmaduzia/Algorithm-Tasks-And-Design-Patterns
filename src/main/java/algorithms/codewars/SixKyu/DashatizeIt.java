package algorithms.codewars.SixKyu;

public class DashatizeIt {

    public static String dashatize(int num) {

        String numAsString = String.valueOf(Math.abs(num));
        StringBuilder result = new StringBuilder();

        for(char c: numAsString.toCharArray()) {
            if (Character.getNumericValue(c) % 2 != 0) {
                result.append("-").append(c).append("-");
            }
            else {
                result.append(c);
            }
        }

        result = new StringBuilder(result.toString().replace("---", "-"));
        result = new StringBuilder(result.toString().replace("--", "-"));

        if (result.toString().startsWith("-"))
            result = new StringBuilder(result.substring(1, result.length()));
        if (result.toString().endsWith("-"))
            result = new StringBuilder(result.substring(0, result.length() - 1));

        return result.toString();

    }
}
