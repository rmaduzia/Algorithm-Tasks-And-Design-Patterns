package algorithms.spoj.bacics.blue;

import java.util.Scanner;

public class SMPDIVDivisibility {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int amountOfValues = scanner.nextInt();

        while(amountOfValues > 0) {
            amountOfValues--;

            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                if (i % x == 0 && i % y != 0)
                    System.out.print(i + " ");
            }
        }
    }
}
