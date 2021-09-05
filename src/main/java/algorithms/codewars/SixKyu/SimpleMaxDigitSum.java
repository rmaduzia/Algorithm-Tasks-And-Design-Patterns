package algorithms.codewars.SixKyu;

public class SimpleMaxDigitSum {

    public static long solve(long n){

        long result = n;
        long b=1;

        while(n != 0) {
            long current = (n-1) * b + (b -1);

            if (sumDigits(current) > sumDigits(result) || (sumDigits(current) == sumDigits(result) && current > result)) {
                result = current;
            }
            n /= 10;
            b *= 10;
        }
        return result;
    }

    public static long sumDigits(long a) {
        long sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
}
