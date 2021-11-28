package algorithms.codewars.SixKyu;

import java.util.Arrays;

public class EqualSidesOfAnArray {

    public static int findEvenIndex(int[] arr) {

        int leftSum = 0;
        int sum = Arrays.stream(arr).sum();

        for(int i =0; i< arr.length; i++) {
            int current = arr[i];

            if(2 * leftSum + current == sum) {
                return i;
            }
            leftSum += current;
        }

        return -1;

    }
}
