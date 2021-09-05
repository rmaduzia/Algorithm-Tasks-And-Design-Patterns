package designPatterns.constructions.builder.firstSample.structure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Door extends MapSite{

    private Room firstRoom;
    private Room secondRoom;
    private boolean isOpen;

    public Door(Room firstRoom, Room secondRoom){
        this.firstRoom = firstRoom;
        this.secondRoom = secondRoom;
    }

    @Override
    public void enter() {

    }

    Room otherSideFrom(Room room) {

        if (room == null)
            return null;

        return room.equals(firstRoom) ? firstRoom : secondRoom;

    }

}
