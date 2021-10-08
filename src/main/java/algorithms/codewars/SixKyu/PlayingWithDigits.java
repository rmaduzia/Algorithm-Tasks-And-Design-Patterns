package algorithms.codewars.SixKyu;

public class PlayingWithDigits {

    public static long digPow(int n, int p) {

        String val = String.valueOf(n);
        long sum=0;

        for(int i = 0; i < val.length(); i++, p++) {
            sum += Math.pow(Character.getNumericValue(val.charAt(i)), p);
        }

        return (sum % n == 0) ? sum / n : -1;
    }
}
