package algorithms.codewars.SixKyu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConsecutiveStrings {

    public static String longestConsec(String[] strarr, int k) {

        List<String> concatedStrings = new ArrayList<>();
        StringBuilder resultString = new StringBuilder();

        if (strarr.length == 0 || strarr.length < k) {
            return "";
        }

        for(int i=0; i<strarr.length-k+1; i++) {
            for(int j=i; j< k+i; j++){
                resultString.append(strarr[j]);
            }
            concatedStrings.add(resultString.toString());
            resultString.setLength(0);
        }

        return concatedStrings.stream().max(Comparator.comparingInt(String::length)).get();
    }

}
