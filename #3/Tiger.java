import java.awt.Color;

public class Tiger extends Cat{
    
    private boolean hungry = true;
    
    public Tiger() {
    }

    public boolean eat() {
        if (hungry) {
            hungry = false;
            return true;
        } else {
            return hungry;
        }
    }


    public Attack fight(String opponent) {
        if (hungry == false) {
            hungry = true;
        }
        if (opponent == "%") {
            return Attack.ROAR;
        } else {
            return Attack.POUNCE;
        }
    }

    public Direction getMove() {
        return super.getMove();
    }

    public Color getColor() {
        return Color.BLACK;
    }
    
    public String toString() {
        return super.toString();
    }
}
