package algorithms.codewars.SixKyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {

        List<String> result = new ArrayList<>();

        for (String value : array1) {
            for (String s : array2) {
                if (s.contains(value)) {
                    if (!result.contains(value)) {
                        result.add(value);
                        break;
                    }
                }
            }
        }
        Collections.sort(result);

        String[] arrayResult = new String[result.size()];
        return result.toArray(arrayResult);
    }
}
