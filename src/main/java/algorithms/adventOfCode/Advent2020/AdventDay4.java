package algorithms.adventOfCode.Advent2020;

import algorithms.adventOfCode.AdventOfCode;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class AdventDay4 extends AdventOfCode {

    public static List<String> validKeys = Arrays.asList("hcl", "iyr", "hgt", "pid", "byr", "eyr", "ecl");
    public List<String> dateFromFile;

    @Override
    public long getFirstPartSolution() {
        StringBuilder fullData = new StringBuilder();
        int validPassports;
        dateFormater(fullData);

        validPassports = (int) Arrays.stream(fullData.toString().split(System.lineSeparator() + System.lineSeparator())).map(s -> s.replace(System.lineSeparator(), " "))
            .map(s -> Arrays.stream(s.split(" ")).map(s1 -> s1.split(":")).collect(Collectors.toMap(strings -> strings[0], o -> o[1]))).filter(AdventDay4::isValidPart1).count();

        return validPassports;
    }

    @Override
    public long getSecondPartSolution() {
        int validPassports;
        StringBuilder fullData = new StringBuilder();
        dateFormater(fullData);

        validPassports = (int) Arrays.stream(fullData.toString().split(System.lineSeparator() + System.lineSeparator())).map(s -> s.replace(System.lineSeparator(), " "))
            .map(s -> Arrays.stream(s.split(" ")).map(s1 -> s1.split(":")).collect(Collectors.toMap(strings -> strings[0], o -> o[1]))).filter(AdventDay4::isValidPart2).count();

        return validPassports;
    }

    public static  boolean isValidPart1(Map<String, String> data) {
        return data.keySet().containsAll(validKeys);
    }

    private void dateFormater(StringBuilder fullData) {
        dateFromFile = getInputDataAsListOfString();
        dateFromFile.forEach(s -> fullData.append(s).append(System.lineSeparator()));
    }

    public static  boolean isValidPart2(Map<String, String> data) {

        if (!data.keySet().containsAll(validKeys)) return false;
        if (!data.get("byr").matches("^(200[0-2]|19[2-9][0-9])$")) return false;
        if (!data.get("iyr").matches("^(2020|201[0-9])$")) return false;
        if (!data.get("eyr").matches("^(2030|202[0-9])$")) return false;
        if (!data.get("hgt").matches("^((1([5-8][0-9]|9[0-3])cm)|((59|6[0-9]|7[0-6])in))$")) return false;
        if (!data.get("hcl").matches("^(#[0-9a-f]{6})$")) return false;
        if (!data.get("ecl").matches("^(amb|blu|brn|gry|grn|hzl|oth)$")) return false;
        return data.get("pid").matches("^[0-9]{9}$");
    }

}
