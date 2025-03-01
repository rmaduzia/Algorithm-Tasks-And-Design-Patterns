package algorithms.adventOfCode.Advent2024;

import algorithms.adventOfCode.AdventOfCode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AdventDay12 extends AdventOfCode {

    private static final int[][] DIRECTIONS = {
        {-1, 0}, // up
        {0, -1}, // left
        {1, 0},  // down
        {0, 1}   // right
    };


    @Override
    public long getFirstPartSolution() {
        char[][] matrix = parseInputMatrix();
        return calculateTotal(matrix);
    }

    @Override
    public long getSecondPartSolution() {
        char[][] matrix = parseInputMatrix();
        return calculateTotalSides(matrix);
    }

    private char[][] parseInputMatrix() {
        List<String> dataFromFile = getInputDataAsListOfString();
        char[][] matrix = new char[dataFromFile.size()][];
        for (int i = 0; i < dataFromFile.size(); i++) {
            matrix[i] = dataFromFile.get(i).toCharArray();
        }
        return matrix;
    }

    private long calculateTotal(char[][] matrix) {
        long result = 0;
        Set<String> visited = new HashSet<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String key = row + "," + col;
                if (visited.contains(key)) {
                    continue;
                }

                int[] properties = calculateProperties(matrix, row, col, visited);
                int area = properties[0];
                int value = properties[1];
                result += (long) area * value;
            }
        }

        return result;
    }

    private int[] calculateProperties(char[][] matrix, int startRow, int startCol, Set<String> visited) {
        char regionType = matrix[startRow][startCol];
        int area = 0;
        int boundaryValue = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            String key = row + "," + col;

            if (visited.contains(key)) {
                continue;
            }

            visited.add(key);
            area++;

            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isOutOfBounds(newRow, newCol, matrix)) {
                    boundaryValue++;
                } else if (matrix[newRow][newCol] != regionType) {
                    boundaryValue++;
                } else if (!visited.contains(newRow + "," + newCol)) {
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return new int[]{area, boundaryValue};
    }

    private long calculateTotalSides(char[][] matrix) {
        long result = 0;
        Set<String> visited = new HashSet<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String key = row + "," + col;
                if (visited.contains(key)) {
                    continue;
                }

                int[] properties = calculateSides(matrix, row, col, visited);
                int area = properties[0];
                int sides = properties[1];
                result += (long) area * sides;
            }
        }

        return result;
    }

    private int[] calculateSides(char[][] matrix, int startRow, int startCol, Set<String> visited) {
        char regionType = matrix[startRow][startCol];
        int area = 0;

        Map<int[], Set<String>> boundarySegments = new HashMap<>();
        for (int[] dir : DIRECTIONS) {
            boundarySegments.put(dir, new HashSet<>());
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            String key = row + "," + col;

            if (visited.contains(key)) {
                continue;
            }

            visited.add(key);
            area++;

            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isOutOfBounds(newRow, newCol, matrix) || matrix[newRow][newCol] != regionType) {
                    boundarySegments.get(direction).add(key);
                } else if (!visited.contains(newRow + "," + newCol)) {
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        int totalSides = 0;
        for (Set<String> segment : boundarySegments.values()) {
            totalSides += countConnectedSegments(segment);
        }

        return new int[]{area, totalSides};
    }

    private int countConnectedSegments(Set<String> boundary) {
        int sides = 0;
        Set<String> visitedSegments = new HashSet<>();

        for (String start : boundary) {
            if (visitedSegments.contains(start)) {
                continue;
            }
            sides++;
            Queue<String> queue = new LinkedList<>();
            queue.add(start);

            while (!queue.isEmpty()) {
                String current = queue.poll();
                if (visitedSegments.contains(current)) {
                    continue;
                }

                visitedSegments.add(current);
                int row = Integer.parseInt(current.split(",")[0]);
                int col = Integer.parseInt(current.split(",")[1]);

                for (int[] dir : DIRECTIONS) {
                    String neighbor = (row + dir[0]) + "," + (col + dir[1]);
                    if (boundary.contains(neighbor) && !visitedSegments.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return sides;
    }

    private boolean isOutOfBounds(int row, int col, char[][] mat) {
        return row < 0 || row >= mat.length || col < 0 || col >= mat[row].length;
    }

}
