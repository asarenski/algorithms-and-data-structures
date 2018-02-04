package dice;

import java.util.HashMap;
import java.util.Map;

public class DicePairOdds {
    private DicePairGraph graph;
    private DicePair dice;

    public DicePairOdds(DicePairGraph graph) {
        this.graph = graph;
        this.dice = graph.getDicePair();
    }

    public Map<Integer, Double> generateOddsMap() {
        Map<Integer, Double> odds = new HashMap<>();
        graph.getPossibleCombinations().forEach((integer, tuples) -> {
            odds.put(integer, calculateOdds(tuples.size()));
        });
        return odds;
    }

    public double calculateOdds(int numberOfCombinations) {
        return numberOfCombinations / ( Math.pow( (double)dice.getSidesPerDie(), 2) );
    }

    public double calculateBaseOdds() {
        return calculateOdds(1);
    }
}
