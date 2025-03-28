package algorithms.adventOfCode.Advent2020;

import algorithms.adventOfCode.AdventOfCode;
import java.util.Arrays;
import java.util.List;

public class AdventDay2020_2 extends AdventOfCode {

    @Override
    public long getFirstPartSolution() {
        int amountOfValidPassword = 0;
        List<String> dateFromFile = getInputDataAsListOfString();

        for (String s : dateFromFile) {

            List<String> values = Arrays.asList(s.split(" ", 0));
            int min = Integer.parseInt(values.get(0).split("-", 0)[0]);
            int max = Integer.parseInt(values.get(0).split("-", 0)[1]);
            char lookingChar = values.get(1).charAt(0);
            String password = values.get(2);

            long amountOfChars = password.chars().filter(ch -> ch == lookingChar).count();

            if (amountOfChars >= min && amountOfChars <= max)
                amountOfValidPassword += 1;
        }
        return amountOfValidPassword;
    }

    @Override
    public long getSecondPartSolution() {
        int amountOfValidPassword = 0;
        List<String> dateFromFile = getInputDataAsListOfString();

        for (String s : dateFromFile) {

            List<String> values = Arrays.asList(s.split(" ", 0));
            int min = Integer.parseInt(values.get(0).split("-", 0)[0]);
            int max = Integer.parseInt(values.get(0).split("-", 0)[1]);
            char lookingChar = values.get(1).charAt(0);
            String password = values.get(2);

            if (password.charAt(min-1) == lookingChar && password.charAt(max-1) != lookingChar) {
                amountOfValidPassword += 1;
            }
            else if (password.charAt(max-1) == lookingChar && password.charAt(min-1) != lookingChar) {
                amountOfValidPassword += 1;
            }
        }
        return amountOfValidPassword;
    }
}
