package algorithms.adventOfCode.Advent2020;

import algorithms.adventOfCode.AdventOfCode;
import java.util.ArrayList;
import java.util.List;

public class AdventDay10 extends AdventOfCode {

    @Override
    public long getFirstPartSolution() {
        List<Long> dataFromFile = getInputDataAsListOfLong()
            .stream()
            .sorted()
            .toList();

        long oneJoltCounter = 0;
        long threeJoltCounter = 0;

        long currentJoltage = 0;
        for (Long adapter : dataFromFile) {
            long difference = adapter - currentJoltage;

            if (difference == 1) {
                oneJoltCounter++;
            } else if (difference == 3) {
                threeJoltCounter++;
            }
            currentJoltage = adapter;
        }

        threeJoltCounter++;

        return oneJoltCounter * threeJoltCounter;
    }

    @Override
    public long getSecondPartSolution() {
        List<Long> dataFromFile = getInputDataAsListOfLong()
            .stream()
            .sorted()
            .toList();

        List<Long> adapters = new ArrayList<>(dataFromFile);
        adapters.add(0, 0L);

        adapters.add(adapters.get(adapters.size() - 1) + 3);

        long[] paths = new long[adapters.size()];
        paths[0] = 1;

        for (int i = 1; i < adapters.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (adapters.get(i) - adapters.get(j) <= 3) {
                    paths[i] += paths[j];
                }
            }
        }

        return paths[paths.length - 1];
    }
}