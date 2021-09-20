package designPatterns.creational.builder.firstSample;

import designPatterns.creational.builder.firstSample.structure.Maze;

public abstract class MazeBuilder {

    public void BuildMaze() {

    }

    public void BuildRoom(int room) {

    }

    public void BuildDoor(int roomFrom, int roomTo) {

    }

    public Maze getMaze() {
        return null;
    }

    protected MazeBuilder() {

    }

}
