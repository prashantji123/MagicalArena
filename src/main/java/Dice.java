import java.util.Random;

public class Dice {
    private static final Random RANDOM = new Random();
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return RANDOM.nextInt(sides) + 1;
    }
}
