package algorithms.codewars.SixKyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataReverse {

    public static int[] DataReverse(int[] data) {

        int[] result = new int[data.length];
        List<Integer> resultList = new ArrayList<>();
        int chunk = 8;

        for(int i=data.length;i>0;i-=chunk){
            Collections.addAll(resultList, Arrays.stream(Arrays.copyOfRange(data, i-chunk, i)).boxed().toArray(Integer[]::new));
        }
        Collections.reverse(Arrays.asList(data));
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
