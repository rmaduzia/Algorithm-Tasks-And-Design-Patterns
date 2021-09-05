package algorithms.spoj.classical.blue;

import java.math.BigInteger;
import java.util.Scanner;

public class RANJAN02TowerOfHanoiRevisited {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int amountOfCase = scanner.nextInt();

        while (amountOfCase > 0) {

            BigInteger value = scanner.nextBigInteger();
            System.out.println(pow(BigInteger.valueOf(3), value).subtract(BigInteger.valueOf(1)));
            amountOfCase--;
        }
    }

    public static BigInteger pow(BigInteger base, BigInteger exponent) {
        BigInteger result = BigInteger.ONE;
        while (exponent.signum() > 0) {
            if (exponent.testBit(0)) result = result.multiply(base);
            base = base.multiply(base);
            exponent = exponent.shiftRight(1);
        }
        return result;
    }
}
