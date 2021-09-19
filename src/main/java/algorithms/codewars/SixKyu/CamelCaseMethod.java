package algorithms.codewars.SixKyu;

public class CamelCaseMethod {

    public static String camelCase(String str) {

        str = str.trim();

        if (str.length() == 0)
            return "";

        StringBuilder sb = new StringBuilder();

        boolean shouldConvertNextCharToLower = true;
        sb.append(Character.toUpperCase(str.charAt(0)));

        for (int i = 1; i<str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == ' ') {
                shouldConvertNextCharToLower = false;
            } else if (shouldConvertNextCharToLower) {
                sb.append(Character.toLowerCase(currentChar));
            } else {
                sb.append(Character.toUpperCase(currentChar));
                shouldConvertNextCharToLower = true;
            }
        }

        return sb.toString();
    }

}
