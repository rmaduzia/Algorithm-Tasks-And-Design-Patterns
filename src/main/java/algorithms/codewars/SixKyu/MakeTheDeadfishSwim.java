package algorithms.codewars.SixKyu;

import java.util.ArrayList;
import java.util.List;

public class MakeTheDeadfishSwim {

    public static int[] parse(String data) {

        List<Integer> result = new ArrayList<>();
        char[] chars = data.toCharArray();
        int number = 0;
        for(char c: chars) {

            if (c == 'i')
                number++;

            if (c == 'd')
                number--;

            if (c == 's')
                number *= number;

            if (c == 'o') {
                result.add(number);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
