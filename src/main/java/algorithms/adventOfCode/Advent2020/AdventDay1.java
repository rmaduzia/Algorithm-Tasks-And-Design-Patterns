package algorithms.adventOfCode.Advent2020;

import algorithms.adventOfCode.AdventOfCode;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdventDay1 extends AdventOfCode {

    @Override
    public int getFirstPartSolution() {
        List<String> dateFromFile = getInputDataAsListOfString();

        for (int i=0; i<dateFromFile.size(); i++) {
            for (String s : dateFromFile) {
                if (Integer.parseInt(dateFromFile.get(i)) + Integer.parseInt(s) == 2020) {
                    return Integer.parseInt(dateFromFile.get(i)) * Integer.parseInt(s);
                }
            }
        }
        return 0;
    }

    @Override
    public int getSecondPartSolution() {
        return 0;
    }
}