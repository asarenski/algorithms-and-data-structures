package dice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DicePairCombinationsGraph {
    private DicePair dicePair;
    private Map<Integer, List<Tuple<Integer, Integer>>> possibleCombinations = new HashMap<>();

    public DicePairCombinationsGraph(DicePair dicePair) {
        this.dicePair = dicePair;
        this.possibleCombinations = generatePossibleCombinations();
    }

    public Map<Integer, List<Tuple<Integer, Integer>>> generatePossibleCombinations() {
        Map<Integer, List<Tuple<Integer, Integer>>> possibleCombinations = new HashMap<>();
        for (int i = dicePair.getLeast(); i < dicePair.getGreatest() + 1; i++) {
            possibleCombinations.put(i, generateCombinationsForValue(i));
        }
        return possibleCombinations;
    }

    public List<Tuple<Integer, Integer>> generateCombinationsForValue(int value) {
        List<Tuple<Integer, Integer>> combinations = new ArrayList<>();
        for (int i = 1; i < dicePair.getSidesPerDie() + 1; i++) {
            for (int j = 1; j < dicePair.getSidesPerDie() + 1; j++) {
                if (i + j == value) {
                    combinations.add(new Tuple<>(i, j));
                }
            }
        }
        return combinations;
    }

    public DicePair getDicePair() {
        return dicePair;
    }

    public Map<Integer, List<Tuple<Integer, Integer>>> getPossibleCombinations() {
        return possibleCombinations;
    }
}
