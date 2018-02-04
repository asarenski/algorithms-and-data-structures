package dice;

import java.util.ArrayList;
import java.util.List;

public class DicePair {
    private final List<Die> dice = new ArrayList<>();
    private int least;
    private int greatest;
    private int sidesPerDie;

    public DicePair(int sidesPerDie) {
        this(sidesPerDie, 2);
    }

    public DicePair(int sidesPerDie, int numberOfDice) {
        this.sidesPerDie = sidesPerDie;
        for (int i = 0; i < numberOfDice; i++) {
            dice.add(new Die(sidesPerDie));
        }
        this.least = numberOfDice;
        this.greatest = numberOfDice * sidesPerDie;
    }

    public Integer roll() {
        return dice.stream()
                .mapToInt(Die::roll)
                .sum();
    }

    public int getSidesPerDie() {
        return sidesPerDie;
    }

    public int getLeast() {
        return least;
    }

    public int getGreatest() {
        return greatest;
    }
}
