package algorithms.codewars.SixKyu;

public class StopGninnipSMySdroW {

    public String spinWords(String sentence) {

        String [] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (word.length() > 4) {
                sb.append(new StringBuilder(word).reverse());
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}