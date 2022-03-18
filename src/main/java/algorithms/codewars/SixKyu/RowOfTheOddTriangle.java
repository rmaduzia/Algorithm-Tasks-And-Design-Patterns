package algorithms.codewars.SixKyu;

public class RowOfTheOddTriangle {

    public static long[] oddRow(int n) {

        long[] result = new long[n];

        for (int i = 0; i< (long) n; i++) {
            result[i] = (long) n * (long) n - (long) n +1 + 2L *i;
        }
        return result;
    }
}
