package dice;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class testDicePair {
    @Test
    public void rollAlwaysOutputsInRange2To12() throws Exception {
        final int least = 2;
        final int greatest = 12;

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
}
