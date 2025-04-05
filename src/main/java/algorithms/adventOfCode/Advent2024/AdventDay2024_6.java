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
        List<String> lines = getInputDataAsListOfString();

        int rows = lines.size();
        int cols = lines.get(0).length();

        boolean[][] walls = new boolean[rows][cols];
        boolean[][] referenceMap = new boolean[rows][cols];
        int[][] deltaMap = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

        int[] location = new int[2];

        for (int y = 0; y < rows; y++) {
            String line = lines.get(y);
            if (line.contains("^")) {
                location[0] = y;
                location[1] = line.indexOf('^');
            }

            for (int x = 0; x < cols; x++) {
                if (lines.get(y).charAt(x) == '#') {
                    walls[y][x] = true;
                }
            }
        }

        walk(referenceMap, location.clone(), deltaMap, walls, lines);

        int result = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (referenceMap[y][x]) {
                    if (!(y == location[0] && x == location[1])) {
                        if (detectLoop(location.clone(), y, x, deltaMap, walls, lines)) {
                            result++;
                        }
                    }
                }
            }
        }

        return result;
    }

    private void walk(boolean[][] map, int[] location, int[][] deltaMap, boolean[][] walls, List<String> lines) {
        int direction = 0;

        while (true) {
            map[location[0]][location[1]] = true;

            int dY = location[0] + deltaMap[direction % 4][0];
            int dX = location[1] + deltaMap[direction % 4][1];

            if (dY < 0 || dY >= lines.size() || dX < 0 || dX >= lines.get(0).length()) {
                return;
            }

            if (walls[dY][dX]) {
                direction++;
            } else {
                location[0] = dY;
                location[1] = dX;
            }
        }
    }

    private boolean detectLoop(int[] location, int obstacleY, int obstacleX, int[][] deltaMap, boolean[][] walls, List<String> lines) {
        int rows = lines.size();
        int cols = lines.get(0).length();

        boolean[][][] visited = new boolean[rows][cols][4];
        int direction = 0;

        while (true) {
            visited[location[0]][location[1]][direction % 4] = true;

            int dY = location[0] + deltaMap[direction % 4][0];
            int dX = location[1] + deltaMap[direction % 4][1];

            if (dY < 0 || dY >= rows || dX < 0 || dX >= cols) {
                return false;
            }

            if (visited[dY][dX][direction % 4]) {
                return true;
            }

            if (walls[dY][dX] || (dY == obstacleY && dX == obstacleX)) {
                direction++;
            } else {
                location[0] = dY;
                location[1] = dX;
            }
        }
    }
}
