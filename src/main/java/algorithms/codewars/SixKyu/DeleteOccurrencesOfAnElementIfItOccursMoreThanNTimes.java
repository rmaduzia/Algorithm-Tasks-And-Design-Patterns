package algorithms.codewars.SixKyu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteOccurrencesOfAnElementIfItOccursMoreThanNTimes {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        Map<Integer, Integer> countedElements = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int element : elements) {
            countedElements.merge(element, 1, Integer::sum);
            if (countedElements.get(element) <= maxOccurrences) {
                result.add(element);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
