package algorithms.adventOfCode.Advent2020;

import algorithms.adventOfCode.AdventOfCode;
import java.util.Arrays;
import java.util.List;

public class AdventDay2020_13 extends AdventOfCode {

    @Override
    public long getFirstPartSolution() {

        List<String> inputData = getInputDataAsListOfString();

        List<Integer> buses = Arrays.stream(inputData.get(1).split(",")).filter(v -> !v.equals("x")).map(Integer::valueOf).toList();
        int earliestDeparture = Integer.parseInt(inputData.get(0));
        int earliestBusId = -1;
        int shortestWaitTime = Integer.MAX_VALUE;

        for(int bus: buses) {

            int waitTime = bus - (earliestDeparture % bus);

            if (waitTime < shortestWaitTime) {
                shortestWaitTime = waitTime;
                earliestBusId = bus;
            }
        }

        return (long) earliestBusId * shortestWaitTime;
    }

    @Override
    public long getSecondPartSolution() {

        List<String> inputData = getInputDataAsListOfString();

        List<Integer> buses = Arrays.stream(inputData.get(1).split(",")).map(v -> v.equals("x") ? 1: Integer.parseInt(v)).toList();

        long time = 0;
        long stepIncrement = buses.get(0);

        for(int i = 1; i < buses.size(); i++) {

            int bus = buses.get(i);

            while ((time + i) % bus != 0) {
                time += stepIncrement;
            }
            stepIncrement *= bus;
        }

        return time;
    }
}
