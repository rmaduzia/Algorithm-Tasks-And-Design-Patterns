package algorithms.codewars.SixKyu;

public class BreakCamelCase {

    public static String camelCase(String input) {

        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();

        for(char ch: chars) {
            if (Character.isUpperCase(ch)) {
                sb.append(" ");
                sb.append(ch);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}