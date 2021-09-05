package designPatterns.constructions.builder.firstSample.structure;

import designPatterns.constructions.builder.firstSample.structure.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Maze {

    private List<Room> roomList = new ArrayList<>();


    public Maze() {

    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public Room roomNo(int roomNumber) {
        for (Room room: roomList) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void enterRoom(int roomNumber) {
        Room room = roomNo(roomNumber);
        room.enter();
    }

}
