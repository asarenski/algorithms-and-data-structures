package util;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class testMathUtil {
    @Test
    public void testRandomBetweenOneAndMax() throws Exception {
        for (int i = 0; i < 2000; i++) {
            final int max = 14;
            int random = MathUtil.randomBetweenOneAndMax(max);
            Assert.assertThat(random < max + 1 && random > -1, CoreMatchers.equalTo(true));
        }
    }
}
