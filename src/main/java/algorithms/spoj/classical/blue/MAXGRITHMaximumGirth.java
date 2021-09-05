package algorithms.spoj.classical.blue;

import java.math.BigInteger;
import java.util.Scanner;

public class MAXGRITHMaximumGirth {

    public static void main(String[] args)  {

        Scanner scanner  = new Scanner(System.in);

        int amountOfLines = scanner.nextInt();

        while (amountOfLines >0) {

            BigInteger value = scanner.nextBigInteger();

            BigInteger result = new BigInteger(String.valueOf((value.add(BigInteger.valueOf(1))).multiply(BigInteger.valueOf(2))
                                                .divide(BigInteger.valueOf(3)).mod(BigInteger.valueOf(1000000007))));

            System.out.println(result);
            amountOfLines--;
        }
    }
}
