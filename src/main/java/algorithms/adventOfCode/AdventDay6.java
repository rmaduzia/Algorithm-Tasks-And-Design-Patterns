package algorithms.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import com.google.common.collect.Sets;


public class AdventDay6 {

    public static int getResultAdventDay6Part1() throws IOException {

        List<String> dateFromFiles = Files.readAllLines(Paths.get("src/main/resources/inputs/adventOfCode/adventOfCodeDay6.txt"));
        StringBuilder builder = new StringBuilder();
        int counter = 0;

        Iterator<String> iterator = dateFromFiles.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (!iterator.hasNext()) {
                counter += builder.toString().chars().distinct().count();
                builder.setLength(0);
            }
            if (!name.equals("")) {
                builder.append(name);
            }
            else {
                counter += builder.toString().chars().distinct().count();
                builder.setLength(0);
            }
        }
        return counter;
    }

    public static int getResultAdventDay6Part2() throws IOException {

        String dateFromFiles = Files.readString(Paths.get("src/main/resources/inputs/adventOfCodeDay6.txt"));

        return Arrays.stream(dateFromFiles.split("\n\n"))
                .mapToInt(group -> group.lines()
                        .map(person -> person.chars().boxed().collect(Collectors.toSet()))
                        .reduce(Sets::intersection)
                        .orElse(Set.of())
                        .size())
                .sum();
    }
}