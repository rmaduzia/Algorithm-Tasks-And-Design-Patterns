package algorithms.adventOfCode.Advent2024;

import algorithms.adventOfCode.AdventOfCode;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdventDay3 extends AdventOfCode {

    private static final String MUL_REGEX = "(?<=mul\\()\\d+,\\d+(?=\\))";
    private static final Pattern MUL_PATTERN = Pattern.compile(MUL_REGEX);
    private static final String DO_DONT_MUL_REGEX = "(?:mul\\((\\d+),(\\d+)\\))|(do\\(\\)|don't\\(\\))";
    private static final Pattern DO_DONT_MUL_PATTERN = Pattern.compile(DO_DONT_MUL_REGEX);


    @Override
    public long getFirstPartSolution() {

        long result = 0;

        List<String> dataFromFile = getInputDataAsListOfString();

        for(String line: dataFromFile) {

            Matcher matcher = MUL_PATTERN.matcher(line);

            while(matcher.find()) {
                long leftNumber  = getLeftNumber(matcher);
                long rightNumber = getRightNumber(matcher);
                result += leftNumber * rightNumber;
            }
        }
        return result;
    }

    @Override
    public long getSecondPartSolution() {

        List<String> dataFromFile = getInputDataAsListOfString();

        boolean enabled = true;
        long result = 0;

        for (String line : dataFromFile) {
            Matcher matcher = DO_DONT_MUL_PATTERN.matcher(line);
            while (matcher.find()) {
                if (matcher.group(3) == null && enabled) {
                    long num1 = Long.parseLong(matcher.group(1));
                    long num2 = Long.parseLong(matcher.group(2));
                    result += num1 * num2;
                } else if ("do()".equals(matcher.group(3))) {
                    enabled = true;
                } else if ("don't()".equals(matcher.group(3))) {
                    enabled = false;
                }
            }
        }
        return result;
    }

    private long getRightNumber(Matcher matcher) {
        return Long.parseLong(matcher.group().split(",")[1]);
    }

    private long getLeftNumber(Matcher matcher) {
        return Long.parseLong(matcher.group().split(",")[0]);
    }
}
