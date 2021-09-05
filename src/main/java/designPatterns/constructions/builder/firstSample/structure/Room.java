package designPatterns.constructions.builder.firstSample.structure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room extends MapSite {

    int roomNumber;
    private final MapSite[] sides;

    public Room(int roomNo) {
        this.roomNumber = roomNo;
        this.sides = new MapSite[4];
    }

    public MapSite getSide(Direction direction){
        return sides[direction.ordinal()];
    }

    public void setSide(Direction direction, MapSite mapSite) {
        sides[direction.ordinal()] = mapSite;
    }

    @Override
    public void enter() {

    }


    public void InitializeRoomNo(int r){

    }
}
