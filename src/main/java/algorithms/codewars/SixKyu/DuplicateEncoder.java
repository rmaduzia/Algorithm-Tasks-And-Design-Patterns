package algorithms.codewars.SixKyu;

public class DuplicateEncoder {

    static String encode(String word){

        word = word.toLowerCase();
        char[] chars = word.toCharArray();
        StringBuilder bd = new StringBuilder();

        for (char ch: chars) {
            if (word.lastIndexOf(ch) == word.indexOf(ch)) {
                bd.append("(");
            } else {
                bd.append(")");
            }
        }

        return bd.toString();
    }
}
