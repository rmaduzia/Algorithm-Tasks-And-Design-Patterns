package algorithms.codewars.SixKyu;

import java.util.HashMap;
import java.util.Map;

public class FindTheUniqueNumber {

    public static double findUniq(double[] arr) {

        Map<Double, Integer> values = new HashMap<>();

        for (double v : arr) {
            if (values.containsKey(v)) {
                values.put(v, values.get(v) + 1);
            } else {
                values.put(v, 1);
            }
        }

        for (Map.Entry<Double, Integer> mapData: values.entrySet()) {
            if (mapData.getValue() == 1) {
                return mapData.getKey();
            }
        }

        return 0.0;
    }
}
