package dice;

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

        final List<Tuple> expectedFor2 = Lists.newArrayList(
                new Tuple<>(1, 1)
        );
        Assert.assertEquals(dicePairGraph.generateCombinationsForValue(2), expectedFor2);

        final List<Tuple> expectedFor3 = Lists.newArrayList(
                new Tuple<>(1, 2),
                new Tuple<>(2, 1)
        );
        Assert.assertEquals(dicePairGraph.generateCombinationsForValue(3), expectedFor3);

        final List<Tuple> expectedFor4 = Lists.newArrayList(
                new Tuple<>(1, 3),
                new Tuple<>(2, 2),
                new Tuple<>(3, 1)
        );
        Assert.assertEquals(dicePairGraph.generateCombinationsForValue(4), expectedFor4);

        final List<Tuple> expectedFor7 = Lists.newArrayList(
                new Tuple<>(1, 6),
                new Tuple<>(2, 5),
                new Tuple<>(3, 4),
                new Tuple<>(4, 3),
                new Tuple<>(5, 2),
                new Tuple<>(6, 1)
        );
        Assert.assertEquals(dicePairGraph.generateCombinationsForValue(7), expectedFor7);
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
