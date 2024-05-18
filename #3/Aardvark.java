import java.awt.*;
import java.util.*;

public class Aardvark extends Critter {

    Random randbool = new Random();
    private boolean walkSouth;
    private Direction lastMove;

    public Aardvark(boolean moveSouth) {
        this.walkSouth = moveSouth;
    }

    public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}

    public boolean eat() {
        return true;
    }

    public Direction getMove() {
        if(walkSouth) {
            if(lastMove == Direction.SOUTH) {
                lastMove = Direction.EAST;
                return Direction.EAST;
            } else {
                lastMove = Direction.SOUTH;
                return Direction.SOUTH;
            }
        } else {
            if(lastMove == Direction.NORTH) {
                lastMove = Direction.EAST;
                return Direction.EAST;
            } else {
                lastMove = Direction.NORTH;
                return Direction.NORTH;
            }
        }
    }

	// method comment goes here
	public Color getColor() {
		return Color.RED;
	}

	// method comment goes here
	public String toString() {
		return "%";
	}
}
