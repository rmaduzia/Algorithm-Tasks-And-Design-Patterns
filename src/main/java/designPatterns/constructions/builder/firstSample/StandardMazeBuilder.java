package designPatterns.constructions.builder.firstSample;

import designPatterns.constructions.builder.firstSample.structure.*;

public class StandardMazeBuilder extends MazeBuilder{

    private Maze currentMaze;

    StandardMazeBuilder() {
        currentMaze = new Maze();
    }

    public void BuildMaze() {
        currentMaze = new Maze();
    }

    public void BuildRoom(int roomNumber) {

        if( currentMaze != null && currentMaze.roomNo( roomNumber ) == null ) {
            Room room = new Room(roomNumber);
            room.setSide(Direction.NORTH, new Wall());
            room.setSide(Direction.EAST, new Wall());
            room.setSide(Direction.SOUTH, new Wall());
            room.setSide(Direction.WEST, new Wall());
        }
    }

    @Override
    public void BuildDoor(int from, int to) {
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Door door = new Door(r1, r2);


        r1.setSide( commonWall( r1, r2 ), door );
        r2.setSide( commonWall( r2, r1 ), door );
    }

    @Override
    public Maze getMaze() {
        return currentMaze;
    }

    private Direction commonWall( Room r1, Room r2 )
    {
        if( r2.getRoomNumber() == r1.getRoomNumber() + 1 )
        {
            return Direction.EAST;
        }
        if( r1.getRoomNumber() == r2.getRoomNumber() + 1 )
        {
            return Direction.WEST;
        }
        if( r2.getRoomNumber() > r1.getRoomNumber() )
        {
            return Direction.SOUTH;
        }
        else
            return Direction.NORTH;
    }
}