import java.awt.Color;
import java.util.*;


public class Koala extends Critter {
    private int hunger;
    private int inc = 0;
    Random direction = new Random();
    private int newDir = direction.nextInt(4);

    public Koala(int hungry) {
        this.hunger = hungry;
    }

    public Attack fight(String opponent) {
        if(eat()) {
            return Attack.SCRATCH;
        } else {
            return Attack.POUNCE;
        }
    }

    public Direction getMove() {
        switch (newDir) {
            case 0:
                inc++;
                if (inc == 5) {
                    inc = 0;
                    newDir = direction.nextInt(4);
                }
                return Direction.NORTH;

            case 1:
                inc++;
                if (inc == 5) {
                    inc = 0;
                    newDir = direction.nextInt(4);
                }
                return Direction.EAST;

            case 2:
                inc++;
                if (inc == 5) {
                    inc = 0;
                    newDir = direction.nextInt(4);
                }
                return Direction.SOUTH;

            case 3:
                inc++;
                if (inc == 5) {
                    inc = 0;
                    newDir = direction.nextInt(4);
                }
                return Direction.WEST;
        }
        return Direction.CENTER;
    }

    public boolean eat(){
        if(hunger == 0) {
            return false;
        } else {
            hunger--;
            return true;
        }
    }

    public Color getColor() {
        if(hunger == 0) {
            return Color.WHITE;
        } else {
            return Color.GRAY;
        }
    }

    public String toString() {
        return Integer.toString(hunger);
    }
}