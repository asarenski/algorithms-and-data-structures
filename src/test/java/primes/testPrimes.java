package primes;

import com.google.common.collect.Maps;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class testPrimes {

    private Map<Integer, Boolean> map = Maps.newHashMap();

    @Before
    public void setUp() throws Exception {
        map.put(3, true);
        map.put(4, false);
        map.put(5, true);
        map.put(6, false);
        map.put(7, true);
        map.put(8, false);
        map.put(9, false);
        map.put(10, false);
        map.put(11, true);
    }

    @Test
    public void testIsPrime() {
        map.keySet().forEach(num -> {
            try {
                Assert.assertThat(Primes.isPrime(num), CoreMatchers.equalTo(map.get(num)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
