package dice;

import org.junit.Test;

public class testDicePairOddsFormatter {
    @Test
    public void testFormat() throws Exception {
        DicePair dicePair = new DicePair(6);
        DicePairCombinationsGraph dicePairCombinationsGraph = new DicePairCombinationsGraph(dicePair);
        DicePairOdds dicePairOdds = new DicePairOdds(dicePairCombinationsGraph);
        DicePairOddsFormatter dicePairOddsFormatter = new DicePairOddsFormatter(dicePairOdds);

        String formattedOdds =  dicePairOddsFormatter.printFormattedOdds();
        System.out.println(formattedOdds);
    }
}
