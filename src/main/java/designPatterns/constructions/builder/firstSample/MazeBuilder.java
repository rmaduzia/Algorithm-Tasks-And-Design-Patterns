package designPatterns.constructions.builder.firstSample;

import designPatterns.constructions.builder.firstSample.structure.Maze;

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
