package dice;

import org.apache.commons.math3.fraction.Fraction;

import java.util.Map;
import java.util.stream.Collectors;

public class DicePairOdds {
    private DicePairCombinationsGraph graph;
    private DicePair dice;

    public DicePairOdds(DicePairCombinationsGraph graph) {
        this.graph = graph;
        this.dice = graph.getDicePair();
    }

    public Map<Integer, Double> generateDicePairOdds() {
        return graph.getPossibleCombinations().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        tupleEntry -> calculateOdds(tupleEntry.getValue().size())
                ));
    }

    public Map<Integer, String> generateDicePairOddsWithFractions() {
        return graph.getPossibleCombinations().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        tupleEntry -> new Fraction(calculateOdds(tupleEntry.getValue().size())).toString()
                ));
    }

    public double calculateOdds(int numberOfCombinations) {
        return numberOfCombinations / (Math.pow((double) dice.getSidesPerDie(), 2));
    }

    public double calculateBaseOdds() {
        return calculateOdds(1);
    }

    public DicePair getDice() {
        return dice;
    }
}
