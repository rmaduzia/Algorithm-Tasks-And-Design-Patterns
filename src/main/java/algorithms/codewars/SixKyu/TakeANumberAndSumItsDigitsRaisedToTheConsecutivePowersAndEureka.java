package algorithms.codewars.SixKyu;

import java.util.ArrayList;
import java.util.List;

public class TakeANumberAndSumItsDigitsRaisedToTheConsecutivePowersAndEureka {

    public static List<Long> sumDigPow(long a, long b) {

        List<Long> result = new ArrayList<>();
        long actualNumber=0;
        int counter;
        for(; a < b; a++) {
            long number = a;
            counter = String.valueOf(a).length();
            while (number>0) {
                long lastNumber = number % 10;
                actualNumber = actualNumber + (long) Math.pow(lastNumber,counter);
                number = number / 10;
                counter--;
            }
            if(a == actualNumber) {
                result.add(actualNumber);
            }
            actualNumber=0;
        }
        return result;
    }
}