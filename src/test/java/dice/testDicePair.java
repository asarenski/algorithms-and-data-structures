package dice;

import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testDicePair {
    private static final int least = 2;
    private static final int greatest = 12;

    @Test
    public void rollAlwaysOutputsInRange2To12For6sided() throws Exception {
        DicePair dice = new DicePair(6);
        Map<Integer, Integer> count = new HashMap<>();
        for (int i=0; i<500; i++) {
            Integer currentRoll = dice.roll();
            Integer interCount = count.get(currentRoll) != null ? count.get(currentRoll) : 0;
            count.put(currentRoll, interCount + 1);
            Assert.assertThat(currentRoll, Matchers.not(Matchers.lessThan(least)));
            Assert.assertThat(currentRoll, Matchers.not(Matchers.greaterThan(greatest)));
        }

        for (Integer i=least; i<greatest + 1; i++) {
            Assert.assertThat(count.get(i), Matchers.greaterThan(0));
        }
    }

    @Test
    public void testGenerateCombinationsFor6sided() throws Exception {
        DicePair dice = new DicePair(6);

        final List<Tuple> expectedFor2 = Lists.newArrayList(
                new Tuple<>(1, 1)
        );
        Assert.assertEquals(dice.generateCombinationsForValue(2), expectedFor2);

        final List<Tuple> expectedFor3 = Lists.newArrayList(
                new Tuple<>(1, 2),
                new Tuple<>(2, 1)
        );
        Assert.assertEquals(dice.generateCombinationsForValue(3), expectedFor3);

        final List<Tuple> expectedFor4 = Lists.newArrayList(
                new Tuple<>(1, 3),
                new Tuple<>(2, 2),
                new Tuple<>(3, 1)
        );
        Assert.assertEquals(dice.generateCombinationsForValue(4), expectedFor4);

        final List<Tuple> expectedFor7 = Lists.newArrayList(
                new Tuple<>(1, 6),
                new Tuple<>(2, 5),
                new Tuple<>(3, 4),
                new Tuple<>(4, 3),
                new Tuple<>(5, 2),
                new Tuple<>(6, 1)
        );
        Assert.assertEquals(dice.generateCombinationsForValue(7), expectedFor7);
    }

    @Test
    public void testGeneratePossibleCombinations() throws Exception {
        DicePair dice = Mockito.spy(new DicePair(6));
        dice.generatePossibleCombinations();

        int testValue = dice.getLeast();
        while(testValue < dice.getGreatest() + 1) {
            Mockito.verify(dice).generateCombinationsForValue(testValue);
            testValue++;
        }
    }
}
