package algorithms.codewars.SixKyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interval {

    public static int[] IntervalMethod(int[] arr, String str) {

        if (arr.length == 0 || str.equals("")) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length() - 1);
        int firstNumber = 0;
        int lastNumber = 0;

        if (firstChar == '(') {
            firstNumber = Integer.parseInt((str.split(",")[0]).substring(1)) + 1;
        }
        if (firstChar == '[') {
            firstNumber = Integer.parseInt((str.split(",")[0]).substring(1));
        }
        if (lastChar == ')') {
            String lastNumberTemp = str.split(",")[str.split(",").length - 1];
            lastNumber = Integer.parseInt(lastNumberTemp.substring(0, lastNumberTemp.length() - 1));
        }
        if (lastChar == ']') {
            String lastNumberTemp = str.split(",")[str.split(",").length - 1];
            lastNumber = Integer.parseInt(lastNumberTemp.substring(0, lastNumberTemp.length() - 1)) + 1;

        }

        for (int i = firstNumber; i < lastNumber; i++) {
            int value = i;
            if (Arrays.stream(arr).anyMatch(x -> x == value)) {
                result.add(i);
            }

        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}


