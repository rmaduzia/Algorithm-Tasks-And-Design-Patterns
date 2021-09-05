package algorithms.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class AdventDay2 {

    public static int getResultAdventDay2Part1() throws IOException {

        int amountOfValidPassword = 0;
        List<String> dateFromFile = Files.readAllLines(Paths.get("src/main/resources/inputs/adventOfCode/adventOfCodeDay2.txt"));

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


    public static int getResultAdventDay2Part2() throws IOException {

        int amountOfValidPassword = 0;
        List<String> dateFromFile = Files.readAllLines(Paths.get("src/main/resources/inputs/adventOfCodeDay2.txt"));

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
