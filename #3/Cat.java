import java.awt.*;
import java.util.*;

public class Cat extends Critter{

    Random randbool = new Random();
    private Direction lastMove;
    private int inc = 0;
    private int direction = 0;

    public Cat() {
    }

    public Attack fight(String opponent) {
        if(opponent == "%") {
            return Attack.POUNCE;
        } else {
            return Attack.ROAR;
        }
    }

    public boolean eat() {
        return false;
    }

    public Direction getMove() {
        switch (direction) {
            case 0:
                inc++;
                if (inc == 3) {
                    inc = 0;
                    direction = 1; // Update direction
                }
                lastMove = Direction.NORTH;
                return Direction.NORTH;

            case 1:
                inc++;
                if (inc == 3) {
                    inc = 0;
                    direction = 2; // Update direction
                }
                lastMove = Direction.EAST;
                return Direction.EAST;

            case 2:
                inc++;
                if (inc == 3) {
                    inc = 0;
                    direction = 3; // Update direction
                }
                lastMove = Direction.SOUTH;
                return Direction.SOUTH;

            case 3:
                inc++;
                if (inc == 3) {
                    inc = 0;
                    direction = 0; // Update direction
                }
                lastMove = Direction.WEST;
                return Direction.WEST;
        }
        return Direction.CENTER;
    }

    // method comment goes here
    public Color getColor() {
        return Color.BLUE;
    }

    // method comment goes here
    public String toString() {
        if(lastMove == Direction.NORTH || lastMove == Direction.CENTER) {
            return "^";
        } else if(lastMove == Direction.EAST) {
            return ">";
        } else if(lastMove == Direction.WEST) {
            return "<";
        } else {
            return "V";
        }
    }
}