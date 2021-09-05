package algorithms.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdventDay3 {

    public static int getResultAdventDay3Part1(int right, int down) throws IOException {

        List<String> dateFromFile = Files.readAllLines(Paths.get("src/main/resources/inputs/adventOfCode/adventOfCodeDay3.txt"));

        int trees = 0;
        int index = 0;
        int columns = dateFromFile.get(0).length();

        for(int i = 0; i < dateFromFile.size(); i += down){
            if(dateFromFile.get(i).charAt(index) == '#'){
                trees ++;
            }
            index = (index + right) % columns;
        }
        return trees;    }

    public static long getResultAdventDay3Part2() throws IOException {

        long result = getResultAdventDay3Part1( 1, 1);
        result *= getResultAdventDay3Part1( 3, 1);
        result *= getResultAdventDay3Part1( 5, 1);
        result *= getResultAdventDay3Part1(7, 1);
        result *= getResultAdventDay3Part1( 1, 2);

       return result;
    }
}
