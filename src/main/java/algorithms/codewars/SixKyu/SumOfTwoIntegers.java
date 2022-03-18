package algorithms.codewars.SixKyu;

public class SumOfTwoIntegers {

    public static int add(int x, int y)
    {
        int xor = x ^ y;
        int carry = x & y;

        if (carry == 0)
            return xor;
        else
            return add(xor, carry << 1);
    }
}
