package algorithms.codewars.SixKyu;

public class DetectPangram {

    public boolean check(String sentence){

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        sentence = sentence.toLowerCase();

        for(char c: alphabet) {
            if (sentence.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}
