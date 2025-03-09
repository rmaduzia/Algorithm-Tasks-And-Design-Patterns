package algorithms.adventOfCode.Advent2024;

import algorithms.adventOfCode.AdventOfCode;
import java.util.List;

public class AdventDay2024_4 extends AdventOfCode {

    private static final String XMAS = "XMAS";
    private static final String MAS = "X-MAS";

    @Override
    public long getFirstPartSolution() {

        long result = 0;
        List<String> grid = getInputDataAsListOfString();
        int rows = grid.size();
        int cols = grid.get(0).length();

        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1}
        };

        for (int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {

                for(int[] direction: directions) {
                    if (canFormWord(grid, row, col, direction[0], direction[1], XMAS))
                        result++;
                }
            }
        }
        return result;

    }

    private boolean canFormWord(List<String> grid, int row, int col, int rowOffset, int colOffset, String word) {

        int rows = grid.size();
        int cols = grid.get(0).length();

        for(int  i = 0; i < word.length(); i++) {

            int newRow = row + i * rowOffset;
            int newCol = col + i * colOffset;

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || grid.get(newRow).charAt(newCol) != word.charAt(i)) {
                return false;
            }
        }
        return true;

    }

    private boolean isXmasPattern(List<String> grid, int row, int col) {
        // Check the "X" shape with two "MAS" segments
        return
            grid.get(row - 1).charAt(col - 1) == 'M' && // Top-left M
                grid.get(row - 1).charAt(col + 1) == 'S' && // Top-right S
                grid.get(row).charAt(col) == 'A' &&        // Center A
                grid.get(row + 1).charAt(col - 1) == 'S' && // Bottom-left S
                grid.get(row + 1).charAt(col + 1) == 'M';  // Bottom-right M
    }


    @Override
    public long getSecondPartSolution() {
        List<String> grid = getInputDataAsListOfString();
        int rows = grid.size();
        int cols = grid.get(0).length();
        long result = 0;

        for (int i = 1; i < rows - 1; i++) { // Avoid edges
            for (int j = 1; j < cols - 1; j++) {
                if (isXmasAt(grid, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isXmasAt(List<String> grid, int i, int j) {
        if (grid.get(i).charAt(j) != 'A')
            return false;

        return matches(grid, i-1, j-1, i +1, j + 1)
            && matches(grid, i - 1, j +1, i + 1, j - 1);
    }

    private boolean matches(List<String> grid, int r1, int c1, int r2, int c2) {
        if (r1 < 0 || r2 >= grid.size() || c1 < 0 || c2 >= grid.get(0).length())
            return false;

        char firstChar = grid.get(r1).charAt(c1);
        char secondChar = grid.get(r2).charAt(c2);

        return ((firstChar == 'M' && secondChar == 'S') ||  firstChar == 'S' && secondChar == 'M');
    }




}
