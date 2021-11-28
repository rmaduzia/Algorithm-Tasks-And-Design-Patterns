package algorithms.codewars.SixKyu;

public class ValidBraces {

    public boolean isValid(String braces) {

        int x = braces.length();
        braces = braces.replaceAll("\\(\\)|\\[\\]|\\{\\}", "");
        return braces.length() != x && (braces.length() == 0 || isValid(braces));
    }
}
