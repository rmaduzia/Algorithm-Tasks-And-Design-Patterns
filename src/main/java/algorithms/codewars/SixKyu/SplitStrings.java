package algorithms.codewars.SixKyu;

public class SplitStrings {

    public static String[] solution(String s) {

        int stingLength = s.length();
        String[] result = new String[(int) Math.ceil((double) stingLength / 2)];

        for (int i=0; i<s.length(); i++) {
            System.out.println(i);
            if (i < stingLength-1) {
                result[i/2] = s.substring(i, i+2);
            }
            i++;
        }

        if (stingLength % 2 != 0) {
            result[result.length-1] = s.substring(stingLength-1) + "_";
        }

        return result;
    }
}
