package algorithms.codewars.SixKyu;

public class BuildAPileOfCubes {

    public static long findNb(long m) {

        long total = 0;
        long n = 0;
        for (n = 1; total < m; n++) {
            total += (long) Math.pow(n, 3);
        }
        return total == m ? n - 1 : -1;
    }
}
