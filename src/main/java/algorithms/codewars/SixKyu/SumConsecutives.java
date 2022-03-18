package algorithms.codewars.SixKyu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SumConsecutives {

    public static List<Integer> sumConsecutives(List<Integer> s) {
        LinkedList<Integer> result = new LinkedList<>();
        int previous = s.get(0);
        result.add(previous);
        for (int i=1; i<s.size(); i++){
            result.add(s.get(i) == previous? result.pollLast() + s.get(i) : s.get(i));
            previous = s.get(i);
        }
        return result;
    }
}
