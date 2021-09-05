package algorithms.spoj.bacics.blue;

import java.util.Scanner;

public class SMPSEQ6FunWithSequencesAct4 {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int amountOfValues = scanner.nextInt();
            int xParametr = scanner.nextInt();

            int[] firstTab = new int[amountOfValues];
            int[] secondTab = new int[amountOfValues];


            for (int i = 0; i < amountOfValues; i++) {
                firstTab[i] = scanner.nextInt();
            }

            for (int i = 0; i < amountOfValues; i++) {
                secondTab[i] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();

           for (int j = 0; j < amountOfValues; j++) {
               for (int k= -xParametr; k<= xParametr; k++) {
                   if ((j + k >= 0) && (j + k < amountOfValues) && (firstTab[j] == secondTab[(j + k)])) {
                       result.append(j+1+ " ");
                   }
                   }
           }

            result.trimToSize();
            System.out.println(result);
    }
}
