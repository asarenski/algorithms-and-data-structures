package dice;

import org.apache.commons.math3.fraction.Fraction;

import java.util.Map;
import java.util.stream.Collectors;

public class DicePairOddsService {
    private DicePairCombinationsGraph graph;
    private DicePair dice;

    public DicePairOddsService(DicePairCombinationsGraph graph) {
        this.graph = graph;
        this.dice = graph.getDicePair();
    }

    public Map<Integer, Double> generateDicePairOdds() {
        return graph.getPossibleCombinations().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        tuples -> calculateOdds(tuples.getValue().size())
                ));
    }

    public Map<Integer, String> generateDicePairOddsWithFractions() {
        return graph.getPossibleCombinations().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        tuples -> new Fraction(calculateOdds(tuples.getValue().size())).toString()
                ));
    }

    public double calculateOdds(int numberOfCombinations) {
        return numberOfCombinations / (Math.pow((double) dice.getSidesPerDie(), 2));
    }

    public double calculateBaseOdds() {
        return calculateOdds(1);
    }

}
