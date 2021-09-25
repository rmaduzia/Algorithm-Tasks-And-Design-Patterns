package algorithms.codewars.SixKyu;

import java.util.stream.IntStream;

public class FindTheMissingLetter {

    public static char findMissingLetter(char[] array)
    {

        int pos = IntStream.range(1, array.length).filter(index -> (array[index] - array[index-1] != 1))
                .findFirst().getAsInt();

        return (char) (array[pos] -1);

    }
}
