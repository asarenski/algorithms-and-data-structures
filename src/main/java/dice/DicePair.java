package dice;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class DicePair {
    private static final int numberOfDice = 2;
    private int sidesPerDie = 6;
    private List<Die> dice = Lists.newArrayList();

    public DicePair(int sidesPerDie) {
        this.sidesPerDie = sidesPerDie;
        for (int i=0; i < numberOfDice; i++) {
            dice.add(new Die(sidesPerDie));
        }
    }

    public Integer roll() {
        return dice.stream()
                .mapToInt(Die::roll)
                .sum();
    }

    public List<Tuple<Integer, Integer>> generateCombinationsForValue(int value) {
        List<Tuple<Integer, Integer>> combinations = new ArrayList<>();
        for (int i=1; i<sidesPerDie+1; i++) {
            for(int j=1; j<sidesPerDie+1; j++) {
                if (i + j == value) {
                    combinations.add(new Tuple<>(i, j));
                }
            }
        }
        return combinations;
    }

    public int getSidesPerDie() {
        return sidesPerDie;
    }
}
