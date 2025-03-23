package algorithms.adventOfCode.Advent2024;

import algorithms.adventOfCode.AdventOfCode;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdventDay2024_6 extends AdventOfCode {

    private static final char WALL = '#';
    private static final Set<Character> GUARD_DIRECTIONS = Set.of('^', 'v', '<', '>');
    private static final Map<Character, int[]> DIRECTIONS = Map.of(
        '^', new int[] {-1, 0},
        'v', new int[] {1,0},
        '<', new int[] {0, -1},
        '>', new int[] {0, 1}
    );

    private static final List<Character> TURN_ORDER = List.of('^', '>', 'v', '<');

    @Override
    public long getFirstPartSolution() {

        List<String> dataFromFile = getInputDataAsListOfString();
        int rows = dataFromFile.size();
        int cols = dataFromFile.get(0).length();
        char[][]grid = new char[rows][cols];

        int guardRow = -1;
        int guardCol = -1;
        char guardDirection = '^';

        for(int row = 0; row < rows; row++) {
            grid[row] = dataFromFile.get(row).toCharArray();
            for(int col = 0; col < cols; col++) {
                if (GUARD_DIRECTIONS.contains(grid[row][col])) {
                    guardRow = row;
                    guardCol = col;
                    guardDirection = grid[row][col];
                    grid[row][col] = '.';
                    break;
                }
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(guardRow + "," + guardCol);

        while (true) {

            int[] move = DIRECTIONS.get(guardDirection);
            int newRow = guardRow + move[0];
            int newCol = guardCol + move[1];

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                break;
            }

            if (grid[newRow][newCol] == WALL) {
                guardDirection = TURN_ORDER.get((TURN_ORDER.indexOf(guardDirection) + 1) % 4);
            } else {
                guardRow = newRow;
                guardCol = newCol;
                visited.add(guardRow + "," + guardCol);
            }
        }

        return visited.size();
    }

    @Override
    public long getSecondPartSolution() {
        return 0;
    }
}
