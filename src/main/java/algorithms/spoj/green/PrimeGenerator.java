package algorithms.spoj.green;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeGenerator {
/*
    public static int execute(Long firstNumber, Long secondNumber) {


        //(1 <= m <= n <= 1000000000, n-m<=100000)

        //if (firstNumber >= 1 && secondNumber <= 1000000000 && secondNumber-firstNumber<=100000)

        while (firstNumber >= 1 && secondNumber <= 1000000000 && secondNumber-firstNumber<=100000) {

            if (firstNumber %2 == 0) {
                System.out.println(firstNumber);
                if (firstNumber )

            }

            firstNumber += 1;

        }

        return 0;
    }

    private static boolean isPrime(int number) {
        int x;
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .filter(n -> (n & 0X1) != 0)
                .allMatch(n -> x % n != 0);
    }


 */

    public static void main (String[] args) {
        int casesAmount;
        Scanner scanner = new Scanner(System.in);

//		System.out.println("Num of cases: ");

        while (true) {
            casesAmount = scanner.nextInt();
            if (casesAmount >= 10) {
                System.out.println("maximum 10 cases");
            } else {
                break;
            }
        }
    }




}
