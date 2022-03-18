package algorithms.codewars.SixKyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopNClosestPoints {

    public static int[][] getTopN(int[][] points, int n) {

        ArrayList<ArrayList<Integer>> resultList = new ArrayList();

        if (n == 0 ) {
            return new int[0][0];
        }

        if (n > points.length) {
            return points;
        }

        int[] distances = new int[points.length];

        for(int i=0; i<points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            distances[i] = (x * x) + (y * y);
        }

        Arrays.sort(distances);

        int maxDistance = distances[n-1];

        for (int[] point : points) {

            int x = point[0];
            int y = point[1];

            int distance = (x * x) + (y * y);

            if (distance <= maxDistance) {
                List<Integer> insideElement = Arrays.asList(y, x);
                resultList.add(new ArrayList(insideElement));
            }

        }
        return resultList.stream().map(v -> v.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    }
}
