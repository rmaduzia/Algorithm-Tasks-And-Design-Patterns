package algorithms.codewars.SixKyu;

public class FindTheOddInt {

    public static int findIt(int[] a) {

        int result = 0;

        for (int j : a) {
            result = result ^ j;
        }
        return result;
    }
}