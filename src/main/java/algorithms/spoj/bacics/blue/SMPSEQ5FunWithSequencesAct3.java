package algorithms.spoj.bacics.blue;

import java.util.Scanner;

public class SMPSEQ5FunWithSequencesAct3 {

    public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);

            int first = scanner.nextInt();

            int[] firstTab = new int[first];

            for (int i = 0; i < first; i++) {
                firstTab[i] = scanner.nextInt();
            }

            int second = scanner.nextInt();
            int[] secondTab = new int[second];

            for (int i = 0; i < second; i++) {
                secondTab[i] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();

        int limit = Math.min(firstTab.length, secondTab.length);

        for (int j = 0; j < limit; j++) {

                if (firstTab[j] == secondTab[j]) {
                    result.append(j + 1).append(" ");
                }
            }
            result.trimToSize();
            System.out.println(result);
    }
}
