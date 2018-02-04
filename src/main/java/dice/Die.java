package dice;

import util.MathUtil;

public class Die {
    private int sides;

    public Die(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return MathUtil.randomBetweenOneAndMax(sides);
    }
}
