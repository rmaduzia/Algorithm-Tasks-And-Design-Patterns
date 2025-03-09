package algorithms.adventOfCode.Advent2020;

import algorithms.adventOfCode.AdventOfCode;
import java.util.List;

public class AdventDay2020_1 extends AdventOfCode {

    @Override
    public long getFirstPartSolution() {
        List<String> dateFromFile = getInputDataAsListOfString();

        for (int i=0; i<dateFromFile.size(); i++) {
            for (String s : dateFromFile) {
                if (Integer.parseInt(dateFromFile.get(i)) + Integer.parseInt(s) == 2020) {
                    return Long.parseLong(dateFromFile.get(i)) * Integer.parseInt(s);
                }
            }
        }
        return 0;
    }

    @Override
    public long getSecondPartSolution() {
        return 0;
    }
}
