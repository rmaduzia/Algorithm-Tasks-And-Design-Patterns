package algorithms.adventOfCode.Advent2020;

import algorithms.adventOfCode.AdventOfCode;
import java.util.ArrayList;
import java.util.List;

public class AdventDay2020_11 extends AdventOfCode {

    private static final int[][] DIRECTIONS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    @Override
    public long getFirstPartSolution() {
        List<List<Character>> dataFromFile = getInputDataAsListOfListCharacters();

        return run(dataFromFile, AdventDay2020_11::checkAdjacent, 4);
    }

    @Override
    public long getSecondPartSolution() {
        List<List<Character>> dataFromFile = getInputDataAsListOfListCharacters();

        return run(dataFromFile, AdventDay2020_11::checkVisibility, 5);
    }

    public static int run (List<List<Character>> dataFromFile, SeatChecker check, int occupancyThreshold) {

        while(true) {

            List<int[]> seatsToFill = new ArrayList<>();
            List<int[]> seatsToEmpty = new ArrayList<>();

            for (int i = 0; i < dataFromFile.size(); i++) {
                for (int j = 0; j < dataFromFile.get(0).size(); j++) {

                    char currentChar = dataFromFile.get(i).get(j);

                    if (currentChar == '.')
                        continue;

                    int adjustCount = check.count(dataFromFile, i, j);

                    if (currentChar == 'L' && adjustCount == 0) {
                        seatsToFill.add(new int[]{i, j});
                    } else if (currentChar == '#' && adjustCount >= occupancyThreshold) {
                        seatsToEmpty.add(new int[]{i, j});
                    }
                }
            }

            for (int[] seat: seatsToFill) {
                dataFromFile.get(seat[0]).set(seat[1], '#');
            }

            for (int[] seat: seatsToEmpty) {
                dataFromFile.get(seat[0]).set(seat[1], 'L');
            }

            if (seatsToFill.size() + seatsToEmpty.size() == 0) {
                return (int) dataFromFile.stream()
                    .flatMap(List::stream)
                    .filter(c -> c == '#')
                    .count();
            }
        }
    }

    public static int checkAdjacent (List<List<Character>> grid, int i, int j) {

        int counter = 0;

        for(int y = Math.max(0, i - 1); y < Math.min(grid.size(), i + 2); y++) {
            for (int x = Math.max(0, j - 1); x < Math.min(grid.get(0).size(), j + 2); x++) {
                if (!(y == i && x == j) && grid.get(y).get(x) == '#') {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static int checkVisibility(List<List<Character>> grid, int i, int j) {

        int counter = 0;

        for(int[] direction : DIRECTIONS) {
            int[] current = {i + direction[0], j + direction[1]};

            boolean found = false;

            while (0 <= current[0] && current[0] < grid.size() && 0 <= current[1]
                && current[1] < grid.get(0).size() && !found) {

                char currentChar = grid.get(current[0]).get(current[1]);

                if (currentChar == '#') {
                    counter++;
                    found = true;
                } else if (currentChar == 'L') {
                    found = true;
                } else {
                    current[0] += direction[0];
                    current[1] += direction[1];
                }
            }
        }
        return counter;
    }

    @FunctionalInterface
    interface SeatChecker {
        int count(List<List<Character>> grid, int i, int j);
    }
}