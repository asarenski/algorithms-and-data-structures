package dice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DicePairGraph {
    private DicePair dicePair;
    private Map<Integer, List<Tuple<Integer, Integer>>> possibleCombinations = new HashMap<>();

    public DicePairGraph(DicePair dicePair) {
        this.dicePair = dicePair;
        this.possibleCombinations = generatePossibleCombinations();
    }

    public List<Tuple<Integer, Integer>> generateCombinationsForValue(int value) {
        List<Tuple<Integer, Integer>> combinations = new ArrayList<>();
        for (int i=1; i<dicePair.getSidesPerDie()+1; i++) {
            for(int j=1; j<dicePair.getSidesPerDie()+1; j++) {
                if (i + j == value) {
                    combinations.add(new Tuple<>(i, j));
                }
            }
        }
        return combinations;
    }

    public Map<Integer, List<Tuple<Integer, Integer>>> generatePossibleCombinations() {
        Map<Integer, List<Tuple<Integer, Integer>>> possibleCombinations = new HashMap<>();
        for (int i=dicePair.getLeast(); i<dicePair.getGreatest()+1; i++) {
            possibleCombinations.put(i, generateCombinationsForValue(i));
        }
        return possibleCombinations;
    }

    @Override
    public String toString() {
        return "DicePairGraph{" +
                "possibleCombinations=" + possibleCombinations +
                '}';
    }
}
