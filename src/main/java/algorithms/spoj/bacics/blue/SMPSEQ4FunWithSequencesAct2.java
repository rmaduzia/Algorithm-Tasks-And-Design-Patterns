package algorithms.spoj.bacics.blue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SMPSEQ4FunWithSequencesAct2 {

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

        StringBuilder result = new StringBuilder();

        List<Integer> intList = new ArrayList<>(secondTab.length);
        for (int i : secondTab)
        {
            intList.add(i);
        }

        for (int j : firstTab) {
            if (intList.contains(j))
                result.append(j).append(" ");
        }
        result.trimToSize();
        System.out.println(result);
    }

}
