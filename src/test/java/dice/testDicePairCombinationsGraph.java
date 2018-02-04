package dice;

import fixtures.DicePairGraphFixture;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class testDicePairCombinationsGraph {
    @Test
    public void testGenerateCombinationsFor6sided() throws Exception {
        DicePair dice = new DicePair(6);
        DicePairCombinationsGraph dicePairCombinationsGraph = new DicePairCombinationsGraph(dice);

        Assert.assertEquals(dicePairCombinationsGraph.generateCombinationsForValue(2), DicePairGraphFixture.combinationsFor2());
        Assert.assertEquals(dicePairCombinationsGraph.generateCombinationsForValue(3), DicePairGraphFixture.combinationsFor3());
        Assert.assertEquals(dicePairCombinationsGraph.generateCombinationsForValue(4), DicePairGraphFixture.combinationsFor4());
        Assert.assertEquals(dicePairCombinationsGraph.generateCombinationsForValue(7), DicePairGraphFixture.combinationsFor7());
    }

    @Test
    public void testGeneratePossibleCombinations() throws Exception {
        DicePair dice = new DicePair(6);
        DicePairCombinationsGraph dicePairCombinationsGraph = Mockito.spy(new DicePairCombinationsGraph(dice));
        dicePairCombinationsGraph.generatePossibleCombinations();

        int testValue = dice.getLeast();
        while(testValue < dice.getGreatest() + 1) {
            Mockito.verify(dicePairCombinationsGraph).generateCombinationsForValue(testValue);
            testValue++;
        }
    }
}
