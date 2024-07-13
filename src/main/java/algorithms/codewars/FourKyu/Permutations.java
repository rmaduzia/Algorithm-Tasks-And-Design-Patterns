package algorithms.codewars.FourKyu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    public static List<String> singlePermutations(String s) {

        List<String> result = new ArrayList<>();

        for (String value : permute(s))
        {
            result.add(value);
        }
        return result;
    }

    public static Set<String> permute(String chars) {

        Set<String> set = new HashSet<>();

        if (chars.length() == 1)
        {
            set.add(chars);
        }
        else {
            for (int i=0; i<chars.length(); i++)
            {
                String pre = chars.substring(0, i);
                String post = chars.substring(i+1);
                String remaining = pre+post;

                for (String permutation : permute(remaining))
                {
                    set.add(chars.charAt(i) + permutation);
                }
            }
        }
        return set;
    }
}
