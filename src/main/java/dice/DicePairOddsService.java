package dice;

import org.apache.commons.math3.fraction.Fraction;

import java.util.HashMap;
import java.util.Map;

public class DicePairOddsService {
    private DicePairCombinationsGraph graph;
    private DicePair dice;

    public DicePairOddsService(DicePairCombinationsGraph graph) {
        this.graph = graph;
        this.dice = graph.getDicePair();
    }

    public Map<Integer, Double> generateDicePairOdds() {
        Map<Integer, Double> odds = new HashMap<>();
        graph.getPossibleCombinations().forEach((integer, tuples) -> {
            odds.put(integer, calculateOdds(tuples.size()));
        });
        return odds;
    }

    public Map<Integer, String> generateDicePairOddsWithFractions() {
        Map<Integer, String> odds = new HashMap<>();
        graph.getPossibleCombinations().forEach((integer, tuples) -> {
            odds.put(integer, new Fraction(calculateOdds(tuples.size())).toString());
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
