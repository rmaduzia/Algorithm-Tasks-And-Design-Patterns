package algorithms.adventOfCode.Advent2020;

import algorithms.adventOfCode.AdventOfCode;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdventDay5 extends AdventOfCode {

    @Override
    public int getFirstPartSolution() {
        List<String> dateFromFile = getInputDataAsListOfString();

        int rowCol;
        int max=0;

        for (String s : dateFromFile) {
            int col = 0;
            int row = 0;
            for (int j = 0; j < 7; j++) {
                if (s.charAt(j) == 'B') {
                    row += Math.pow(2, 6 - j);
                }
            }
            for (int j = 7; j < 10; j++) {
                if (s.charAt(j) == 'R') {
                    col += Math.pow(2, 9 - j);
                }
            }
            rowCol = (row * 8) + col;
            if (rowCol > max)
                max = rowCol;
        }
        return max;
    }

    @Override
    public int getSecondPartSolution() {
        return 0;
    }
}