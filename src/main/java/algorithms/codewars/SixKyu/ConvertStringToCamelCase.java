package algorithms.codewars.SixKyu;

public class ConvertStringToCamelCase {

    static String toCamelCase(String s){

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '-'  || s.charAt(i) == '_') {
                sb.append(Character.toUpperCase(s.charAt(i+1)));
                i++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}