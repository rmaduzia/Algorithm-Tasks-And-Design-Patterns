package algorithms.codewars.SixKyu;

import java.util.Arrays;

public class LengthOfMissingArray {

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays)
    {
        if (arrayOfArrays == null || arrayOfArrays.length ==0) {
            return 0;
        }
        int[] arraySizes = new int[arrayOfArrays.length];
        int result=0;

        for (int i=0; i<arrayOfArrays.length; i++) {
            if (arrayOfArrays[i] == null || arrayOfArrays[i].length == 0) {
                return 0;
            }
            arraySizes[i] = arrayOfArrays[i].length;
        }

        Arrays.sort(arraySizes);
        int firstSize = arraySizes[0];
        for (int i=0; i<arraySizes.length; i++) {
            if((firstSize +i) != arraySizes[i]) {
                result = firstSize + i;
                break;
            }
        }
        return result;
    }
}
