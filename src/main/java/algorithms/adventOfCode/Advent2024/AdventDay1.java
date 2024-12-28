package algorithms.adventOfCode.Advent2024;

import algorithms.adventOfCode.AdventOfCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.checkerframework.checker.units.qual.A;

public class AdventDay1 extends AdventOfCode {

    @Override
    public long getFirstPartSolution() {

        List<String> dataFromFile = getInputDataAsListOfString();

        List<Integer> leftSideNumbers = new ArrayList<>();
        List<Integer> rightSideNumbers = new ArrayList<>();

        long result = 0;

        for(String value: dataFromFile) {

            leftSideNumbers.add(Integer.valueOf(value.split(" {3}")[0]));
            rightSideNumbers.add(Integer.valueOf(value.split(" {3}")[1]));
        }

        Collections.sort(leftSideNumbers);
        Collections.sort(rightSideNumbers);

        Map<Integer, Long> rightSideOccurrence = rightSideNumbers.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        for(int i = 0 ; i < leftSideNumbers.size(); i++) {

            result += Math.abs(leftSideNumbers.get(i) - rightSideNumbers.get(i));

        }

        return result;
    }

    @Override
    public long getSecondPartSolution() {
        List<String> dataFromFile = getInputDataAsListOfString();

        List<Integer> leftSideNumbers = new ArrayList<>();
        List<Integer> rightSideNumbers = new ArrayList<>();

        long result = 0;

        for(String value: dataFromFile) {

            leftSideNumbers.add(Integer.valueOf(value.split(" {3}")[0]));
            rightSideNumbers.add(Integer.valueOf(value.split(" {3}")[1]));
        }

        Map<Integer, Long> rightSideOccurrence = rightSideNumbers.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Integer leftSideNumber : leftSideNumbers) {
            result += leftSideNumber * rightSideOccurrence.getOrDefault(leftSideNumber, 0L);
        }

        return result;
    }
}
