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
}
