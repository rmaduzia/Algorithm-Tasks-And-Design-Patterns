package algorithms.codewars.SixKyu;

import java.util.ArrayList;
import java.util.List;

public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {

        List<Integer> result = new ArrayList<>();
        boolean contain = false;

        for (int k : a) {
            for (int i : b) {
                if (k == i) {
                    contain = true;
                    break;
                } else {
                    contain = false;
                }
            }
            if (!contain) {
                result.add(k);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
