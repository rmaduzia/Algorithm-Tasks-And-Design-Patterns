package algorithms.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdventDay9 {

    public static long getResultAdventDay9Part1() throws IOException {

        List<Long> dataFromFile = getLongs();

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

    public static long getResultAdventDay9Part2() throws IOException {

        List<Long> dataFromFile = getLongs();

        long number = getResultAdventDay9Part1();

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

    private static List<Long> getLongs() throws IOException {
        return Files.readAllLines(Paths.get("src/main/resources/inputs/adventOfCode/adventOfCodeDay9.txt"))
            .stream()
            .map(Long::valueOf)
            .toList();
    }

}