import java.awt.Color;
import java.util.*;

public class Salmon extends Critter {

    private int y = 0;
    private int x = 0;
    private boolean isMoving = false;
    Random attackNum = new Random();
    private int whatAttack = attackNum.nextInt(2);

    public Salmon() {
    }

    public Attack fight(String opponent) {
        if (opponent == "%") {
            return Attack.ROAR;
        } else if (opponent == "^" || opponent == "<" || opponent == ">" || opponent == "V") {
            if(whatAttack == 0) {
                return Attack.SCRATCH;
            } else {
                return Attack.POUNCE;
            }
        } else {
            return Attack.ROAR;
        }
    }

    public Direction getMove() {
        if (y == getHeight()) {
            isMoving = true;
            if (x == getWidth()) {
            } else {
                x++;
                y = 0;
                return Direction.EAST;
            }
        } 
        if (isMoving == false) {
            y++;

            return Direction.NORTH;
        } else {
            x++;
            if (x % 4 == 0)
                isMoving = false;
            return Direction.EAST;
        }
    }

    public boolean eat() {
        return true;
    }

    public Color getColor() {
        return Color.CYAN;
    }

    public String toString() {
        return "P";
    }

}