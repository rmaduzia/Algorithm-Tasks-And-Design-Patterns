package algorithms.codewars.SixKyu;

public class MultiplesOf3Or5 {

    public int solution(int number) {

        int totalCount = 0;

        for (int i=0; i<number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                totalCount += i;
            }
        }
        return totalCount;
    }
}
