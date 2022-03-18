package algorithms.codewars.SixKyu;

import java.util.Arrays;

public class FormatWordsIntoASentence {

    public static String formatWords(String[] words) {

        if (words == null || words.length == 0) {
            return "";
        }

        String[] cleanedWords = Arrays.stream(words)
                .filter(v -> v != null && !v.trim().isEmpty())
                .toArray(String[]::new);

        StringBuilder result = new StringBuilder();

        for (int i=0; i<cleanedWords.length; i++) {
            if(i == cleanedWords.length - 1 && i > 0) {
                result.append(" and ");
            } else if (i > 0) {
                result.append(", ");
            }
            result.append(cleanedWords[i]);
        }
        return result.toString().trim();
    }
}
