package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ImpiCodeElephants {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int amountOfElephants = scanner.nextInt();
        scanner.nextLine();
        String elephantWeightsInString = scanner.nextLine();
        String actualOrderInString = scanner.nextLine();
        String wantedOrderInString = scanner.nextLine();

        int[] elephantWeights = Arrays.stream(elephantWeightsInString.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] actualOrder = Arrays.stream(actualOrderInString.split(" "))
                .mapToInt(v -> Integer.parseInt(v) - 1)
                .toArray();
        int[] wantedOrder = Arrays.stream(wantedOrderInString.split(" "))
                .mapToInt(v -> Integer.parseInt(v) - 1)
                .toArray();

        int[] permutations = new int[amountOfElephants];
        int minW = Arrays.stream(elephantWeights).min().getAsInt();

        for (int i = 0; i < amountOfElephants; i++) {
            permutations[wantedOrder[i]] = actualOrder[i];
        }

        boolean[] visitedPath = new boolean[amountOfElephants];

        List<Integer> cLength = new ArrayList<>();
        List<List<Integer>> cOrder = new ArrayList<>();

        for (int i = 0; i < amountOfElephants; i++) {
            if (!visitedPath[i]) {
                cLength.add(0);
                List<Integer> order = new ArrayList<>();
                cOrder.add(order);
                int head = i;
                do {
                    cLength.set(cLength.size() - 1, cLength.get(cLength.size() - 1) + 1);
                    order.add(permutations[head]);
                    head = permutations[head];
                    visitedPath[head] = true;
                } while (i != head);
            }
        }

        List<Long> cMin = new ArrayList<>();
        List<Long> cSum = new ArrayList<>();

        for (int i = 0; i < cLength.size(); i++) {
            cMin.add(Long.MAX_VALUE);
            cSum.add(0L);
            for (int e = 0; e < cOrder.get(i).size(); e++) {
                cSum.set(i, elephantWeights[cOrder.get(i).get(e)] + cSum.get(i));
                cMin.set(i, Math.min(elephantWeights[cOrder.get(i).get(e)], cMin.get(i)));
            }
        }

        long w = 0;
        for (int i = 0; i < cLength.size(); i++) {
            long m1 =  (cSum.get(i) + (cLength.get(i) - 2) * cMin.get(i));
            long m2 =  (cSum.get(i) + cMin.get(i) + (cLength.get(i) + 1) * minW);
            w += Math.min(m1, m2);
        }
        System.out.println(w);

    }
}
