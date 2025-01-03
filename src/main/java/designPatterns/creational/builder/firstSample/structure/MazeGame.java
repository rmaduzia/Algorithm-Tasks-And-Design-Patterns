package designPatterns.creational.builder.firstSample.structure;

import designPatterns.creational.builder.firstSample.MazeBuilder;
import designPatterns.creational.builder.firstSample.StandardMazeBuilder;

public class MazeGame {

    public Maze createMaze(MazeBuilder builder) {


        builder.BuildMaze();

        builder.BuildRoom(1);
        builder.BuildRoom(2);
        builder.BuildDoor(1, 2);

        return builder.getMaze();
    }

    public static void main( String[] args ) {

        Maze maze;
        MazeGame game = null;
        StandardMazeBuilder builder = null;

        game.createMaze(builder);
        maze = builder.getMaze();
    }
}