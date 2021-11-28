package algorithms.codewars.SixKyu;

public class ARuleOfDivisibilityBy13 {

    public static long thirt(long n) {

        int[] numbers = {1, 10, 9, 12, 3, 4};

        while(n > 99) {
            long number = 0;
            int i = 0;

            while (n > 0) {
                number += n % 10 * numbers[i++ % 6];
                n /= 10;
            }
            n = number;
        }

        return n;
    }
}
