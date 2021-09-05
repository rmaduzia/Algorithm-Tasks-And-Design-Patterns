package algorithms.spoj.bacics.blue;

import java.util.Arrays;
import java.util.Scanner;

public class SMPSEQ3FunWithSequences {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int first = scanner.nextInt();

        int[] firstTab = new int[first];

        for (int i=0; i<first; i++) {
            firstTab[i] = scanner.nextInt();
        }

        int second = scanner.nextInt();
        int[] secondTab = new int[second];

        for (int i=0; i<second; i++) {
            secondTab[i] = scanner.nextInt();
        }

        for (int j : firstTab) {
            int a = Arrays.binarySearch(secondTab, j);
            if (a < 0)
                System.out.print(j+" ");
        }
    }
}
