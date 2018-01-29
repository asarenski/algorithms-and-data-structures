package dice;

import com.google.common.collect.Lists;

import java.util.List;

public class DicePair {
    private static final int numberOfDice = 2;
    private List<Die> dice = Lists.newArrayList();

    public DicePair(int sidesPerDie) {
        for (int i=0; i < numberOfDice; i++) {
            dice.add(new Die(sidesPerDie));
        }
    }

    public Integer roll() {
        return dice.stream()
                .mapToInt(Die::roll)
                .sum();
    }
}
