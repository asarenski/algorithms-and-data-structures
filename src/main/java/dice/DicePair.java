package dice;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DicePair {
    private final List<Die> dice = Lists.newArrayList();
    private int least;
    private int greatest;
    private int sidesPerDie;

    public DicePair(int sidesPerDie) {
        this(sidesPerDie, 2);
    }

    public DicePair(int sidesPerDie, int numberOfDice) {
        this.sidesPerDie = sidesPerDie;
        for (int i=0; i < numberOfDice; i++) {
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

    public Map<Integer, List<Tuple<Integer, Integer>>> generatePossibleCombinations() {
        Map<Integer, List<Tuple<Integer, Integer>>> possibleCombinations = new HashMap<>();
        for (int i=least; i<greatest+1; i++) {
            possibleCombinations.put(i, generateCombinationsForValue(i));
        }
        return possibleCombinations;
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
