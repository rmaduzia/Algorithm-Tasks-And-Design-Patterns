package algorithms.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdventDay1 {

    public static int getResultAdventDay1() throws IOException {

        List<String> dateFromFile = Files.readAllLines(Paths.get("src/main/resources/inputs/adventOfCode/adventOfCodeDay1.txt"));

        for (int i=0; i<dateFromFile.size(); i++) {
            for (String s : dateFromFile) {
                if (Integer.parseInt(dateFromFile.get(i)) + Integer.parseInt(s) == 2020) {
                    return Integer.parseInt(dateFromFile.get(i)) * Integer.parseInt(s);
                }
            }
        }
        return 0;
    }
}
