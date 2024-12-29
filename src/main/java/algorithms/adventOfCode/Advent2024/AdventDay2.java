package algorithms.adventOfCode.Advent2024;

import algorithms.adventOfCode.AdventOfCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdventDay2 extends AdventOfCode {

    @Override
    public long getFirstPartSolution() {

        long result = 0;

        List<String> dataFromFile = getInputDataAsListOfString();

        for(String row: dataFromFile) {
            List<Integer> record = Arrays.stream(row.split(" ")).map(Integer::valueOf).toList();
            if (isSafeReportFirstSolution(record)) {
                result++;
            }
        }
        return result;
    }


    @Override
    public long getSecondPartSolution() {

        long result = 0;

        List<String> dataFromFile = getInputDataAsListOfString();

        for (String row: dataFromFile) {

            List<Integer> record = Arrays.stream(row.split(" ")).map(Integer::valueOf).toList();

            if (isSafeReportSecondSolution(record))
                result++;


        }

        return result;
    }

    private boolean isSafeReportFirstSolution(List<Integer> record) {

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for(int i = 1; i < record.size(); i++) {

            int difference = record.get(i) - record.get(i - 1);

            if (Math.abs(difference) < 1 || Math.abs(difference) > 3) {
                return false;
            }
            if (difference < 0) {
                isIncreasing = false;
            } else if (difference > 0) {
                isDecreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }

    private boolean isSafeReportSecondSolution(List<Integer> record) {
        if (isSafeReportFirstSolution(record)) {
            return true;
        }

        for (int i = 0; i < record.size(); i++) {
            List<Integer> modifiedRecord = new ArrayList<>(record);
            modifiedRecord.remove(i);

            if (isSafeReportFirstSolution(modifiedRecord)) {
                return true;
            }
        }

        return false;
    }
}
