package algorithms.codewars.SixKyu;

import java.util.Arrays;

public class TheSupermarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {

        int[] total = new int[n];
        for (int customer : customers) {
            total[0] += customer;
            Arrays.sort(total);
        }
        return total[n-1];
    }


    public static void main(String[] args) {

        int[] test = {10,2,3,3};


        System.out.println(TheSupermarketQueue.solveSuperMarketQueue(test, 2));

    }

}
