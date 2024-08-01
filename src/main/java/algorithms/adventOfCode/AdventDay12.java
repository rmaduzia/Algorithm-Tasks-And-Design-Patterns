package algorithms.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AdventDay12 {

    public static Map<String, int[]> DIRECTIONS = new HashMap<>();
    public static Map<Integer, int[]> COORDINATIONS = new HashMap<>();

    static {
        DIRECTIONS.put("N", new int[]{1, 0});
        DIRECTIONS.put("E", new int[]{0, 1});
        DIRECTIONS.put("S", new int[]{-1, 0});
        DIRECTIONS.put("W", new int[]{0, -1});

        COORDINATIONS.put(0, new int[]{1, 0});
        COORDINATIONS.put(90, new int[]{0, 1});
        COORDINATIONS.put(180, new int[]{-1, 0});
        COORDINATIONS.put(270, new int[]{0, -1});
    }

    public static int getResultAdventDay12Part1() throws IOException {

        List<String> dataFromFile = Files.readAllLines(Paths.get("src/main/resources/inputs/adventOfCode/adventOfCodeDay12.txt"));

        int [] position = new int[]{0,0};
        int directionFace = 90;


        for(String value: dataFromFile) {
            String direction = value.split("")[0];
            int coordination = Integer.parseInt(value.substring(1));

            if (Objects.equals(direction, "F")) {
                int[] move = COORDINATIONS.get(directionFace);
                position[0] += move[0] * coordination;
                position[1] += move[1] * coordination;

            } else if (Objects.equals(direction, "L")) {
                directionFace = (directionFace - coordination + 360) % 360;
            } else if (Objects.equals(direction, "R")) {
                directionFace = (directionFace + coordination) % 360;
            } else {
                int[] move = DIRECTIONS.get(direction);
                position[0] += move[0] * coordination;
                position[1] += move[1] * coordination;
            }
        }
        return Math.abs(position[0]) + Math.abs(position[1]);
    }

    public static int getResultAdventDay12Part2() throws IOException {

        int[] shipPosition = new int[]{0,0};
        int[] waypoint = new int[]{1, 10};

        List<String> dataFromFile = Files.readAllLines(Paths.get("src/main/resources/inputs/adventOfCode/adventOfCodeDay12.txt"));

        for(String value: dataFromFile) {
            String direction = value.split("")[0];
            int coordination = Integer.parseInt(value.substring(1));

            switch (direction) {
                case "F" -> {
                    shipPosition[0] += waypoint[0] * coordination;
                    shipPosition[1] += waypoint[1] * coordination;
                }
                case "L" -> rotateWaypoint(waypoint, (360 - coordination) % 360);
                case "R" -> rotateWaypoint(waypoint, coordination);
                default -> {
                    int[] tmp = DIRECTIONS.get(direction);
                    waypoint[0] += tmp[0] * coordination;
                    waypoint[1] += tmp[1] * coordination;
                }
            }
        }
        return Math.abs(shipPosition[0]) + Math.abs(shipPosition[1]);
    }

    public static void rotateWaypoint(int[] waypoint, int value) {

        int tmp = waypoint[0];

        if (value == 90) {
            waypoint[0] = -waypoint[1];
            waypoint[1] = tmp;
        } else if (value == 180) {
            waypoint[0] = -waypoint[0];
            waypoint[1] = -waypoint[1];
        } else if (value == 270) {
            waypoint[0] = waypoint[1];
            waypoint[1] = -tmp;
        }
    }
}