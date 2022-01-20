package algorithms.codewars.SixKyu;

import java.util.Arrays;
import java.util.List;

public class CountTheSmileyFaces {

    public static int countSmileys(List<String> arr) {

        if (arr.isEmpty())
            return 0;

        List<String> smileValues = Arrays.asList(":)",";)",":D",";D",":-D",":~D",":-)",":~)",";~D",";~)",";-D",";-)");
        int counter =0;

        for (String s: arr) {
            for(String smiles: smileValues) {
                if (s.equals(smiles)) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }
}
