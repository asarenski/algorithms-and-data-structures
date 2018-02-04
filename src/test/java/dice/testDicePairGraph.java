package dice;

import Fixtures.DicePairGraphFixture;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class testDicePairGraph {
    @Test
    public void testGenerateCombinationsFor6sided() throws Exception {
        DicePair dice = new DicePair(6);
        DicePairGraph dicePairGraph = new DicePairGraph(dice);

        Assert.assertEquals(dicePairGraph.generateCombinationsForValue(2), DicePairGraphFixture.combinationsFor2());
        Assert.assertEquals(dicePairGraph.generateCombinationsForValue(3), DicePairGraphFixture.combinationsFor3());
        Assert.assertEquals(dicePairGraph.generateCombinationsForValue(4), DicePairGraphFixture.combinationsFor4());
        Assert.assertEquals(dicePairGraph.generateCombinationsForValue(7), DicePairGraphFixture.combinationsFor7());
    }

    @Test
    public void testGeneratePossibleCombinations() throws Exception {
        DicePair dice = new DicePair(6);
        DicePairGraph dicePairGraph = Mockito.spy(new DicePairGraph(dice));
        dicePairGraph.generatePossibleCombinations();

        int testValue = dice.getLeast();
        while(testValue < dice.getGreatest() + 1) {
            Mockito.verify(dicePairGraph).generateCombinationsForValue(testValue);
            testValue++;
        }
    }
}
