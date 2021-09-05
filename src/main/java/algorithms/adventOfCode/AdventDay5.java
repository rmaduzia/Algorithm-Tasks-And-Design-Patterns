package algorithms.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdventDay5 {


    public static int getResultAdventDay5Part1() throws IOException {

        List<String> dateFromFile = Files.readAllLines(Paths.get("src/main/resources/inputs/adventOfCode/adventOfCodeDay5.txt"));

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
}
