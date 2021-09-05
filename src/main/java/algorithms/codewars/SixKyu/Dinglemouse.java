package algorithms.codewars.SixKyu;

public class Dinglemouse {

    public static long int123(final int a) {
        long b = 123 -a ;
        if (b >=0)
            return b;
        else
            return b + Long.MAX_VALUE + 1;
    }
}