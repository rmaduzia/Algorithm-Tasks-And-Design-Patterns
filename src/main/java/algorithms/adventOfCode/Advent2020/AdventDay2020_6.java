package algorithms.adventOfCode.Advent2020;

import algorithms.adventOfCode.AdventOfCode;
import java.util.*;
import java.util.stream.Collectors;
import com.google.common.collect.Sets;


public class AdventDay2020_6 extends AdventOfCode {

    @Override
    public long getFirstPartSolution() {

        List<String> dateFromFiles = getInputDataAsListOfString();
        StringBuilder builder = new StringBuilder();
        long counter = 0;

        Iterator<String> iterator = dateFromFiles.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (!iterator.hasNext()) {
                counter += builder.toString().chars().distinct().count();
                builder.setLength(0);
            }
            if (!name.isEmpty()) {
                builder.append(name);
            }
            else {
                counter += builder.toString().chars().distinct().count();
                builder.setLength(0);
            }
        }
        return counter;
    }

    @Override
    public long getSecondPartSolution() {
        String dateFromFiles = getInputDataAsString();

        return Arrays.stream(dateFromFiles.split("\n\n"))
            .mapToInt(group -> group.lines()
                .map(person -> person.chars().boxed().collect(Collectors.toSet()))
                .reduce(Sets::intersection)
                .orElse(Set.of())
                .size())
            .sum();
    }
}