package algorithms.codewars.SixKyu;

public class NumberZooPatrol {

    public static int findMissingNumber(int[] numbers) {

        int result = 1;
        for (int i = 2; i <= numbers.length + 1; i++)
        {
            result += i;
            result -= numbers[i - 2];
        }
        return result;
    }
}
