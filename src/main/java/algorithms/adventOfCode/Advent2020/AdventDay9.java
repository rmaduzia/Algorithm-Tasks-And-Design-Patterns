package algorithms.adventOfCode.Advent2020;

import algorithms.adventOfCode.AdventOfCode;
import java.util.List;

public class AdventDay9 extends AdventOfCode {

    @Override
    public long getFirstPartSolution() {
        List<Long> dataFromFile = getInputDataAsListOfLong();

        boolean isFound;

        for(int i = 25; i < dataFromFile.size(); i++) {

            long currentValue = dataFromFile.get(i);
            isFound = false;

            for(int n = i - 25; n < i; n++) {
                for(int m = n +1; m < i; m++) {
                    if (currentValue == dataFromFile.get(n) + dataFromFile.get(m)) {
                        isFound = true;
                        break;
                    }
                }
            }

            if (!isFound) {
                return currentValue;
            }
        }

        return -1;
    }

    @Override
    public long getSecondPartSolution() {

        List<Long> dataFromFile = getInputDataAsListOfLong();

        long number = getFirstPartSolution();

        long min;
        long max;
        long currentSum;

        for(int i = 0; i < dataFromFile.size(); i++) {

            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            currentSum = 0;

            for(int j = i; j < dataFromFile.size(); j++) {

                min = Math.min(min, dataFromFile.get(j));
                max = Math.max(max, dataFromFile.get(j));

                currentSum += dataFromFile.get(j);

                if (currentSum == number) {
                    return min + max;
                }
            }
        }
        return -1;
    }
}