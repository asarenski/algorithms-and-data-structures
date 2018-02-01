package dice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DicePairGraph {
    private DicePair dicePair = new DicePair(6);
    private Map<Integer, List<Tuple<Integer, Integer>>> map;
    private List<Tuple> possibleCombinations;

    public DicePairGraph(DicePair dicePair) {
        this.dicePair = dicePair;
        this.map = new HashMap<>();

        final int least = 2;
        final int greatest = 2 * dicePair.getSidesPerDie();
        for (int i=least; i<greatest+1; i++) { // for 2-12
            // matchCombos
        }
    }

    private List<Tuple> matchCombos(Integer sum) {
        return null;
    }

    @Override
    public String toString() {
        return "DicePairGraph{" +
                "map=" + map +
                '}';
    }
}
