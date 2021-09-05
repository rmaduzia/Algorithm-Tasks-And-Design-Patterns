package algorithms.codewars.SixKyu;

public class FindTheParityOutlier {

    static int find(int[] integers){

        int even = 0;
        int odd = 0;
        int cycle = 0;

        for (Integer value: integers) {
            if (value % 2 == 0) {
                even = value;
                cycle++;
            } else {
                odd = value;
            }
        }

        return cycle > 1 ? odd:even;
    }
}