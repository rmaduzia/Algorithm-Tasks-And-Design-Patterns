package algorithms.spoj.classical.blue;

import java.util.Scanner;

public class ADDREVAddingReversedNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int amountOfLines = scanner.nextInt();

        while (amountOfLines > 0) {

            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();

            int reversedFirstNumber = reverseNumber(firstNumber);
            int reversedSecondNumber = reverseNumber(secondNumber);

            int sumResult = reverseNumber(reversedFirstNumber+ reversedSecondNumber);

            System.out.println(sumResult);

            amountOfLines--;
        }
    }

    public static int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number >0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;
        }
        return reversedNumber;
    }
}