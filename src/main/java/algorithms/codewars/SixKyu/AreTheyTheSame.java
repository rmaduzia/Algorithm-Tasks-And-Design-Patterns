package algorithms.codewars.SixKyu;

import java.util.Arrays;

public class AreTheyTheSame {

    public static boolean comp(int[] a, int[] b) {

        if (a == null | b == null) {
            return false;
        }

        Arrays.sort(b);
        int[] arrayOfPow = Arrays.stream(a).map(v -> v *v).toArray();

        Arrays.sort(arrayOfPow);

        return  Arrays.equals(arrayOfPow, b);
    }
}
