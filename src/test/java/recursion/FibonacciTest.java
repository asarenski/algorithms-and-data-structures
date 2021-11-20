package recursion;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
    @Test
    public void testFib() {
        Fibonacci fib = new Fibonacci();
        Assert.assertEquals(0, fib.fibDP(0));
        Assert.assertEquals(1, fib.fibDP(1));
        Assert.assertEquals(1, fib.fibDP(2));
        Assert.assertEquals(2, fib.fibDP(3));
        Assert.assertEquals(3, fib.fibDP(4));
        Assert.assertEquals(5, fib.fibDP(5));
        Assert.assertEquals(8, fib.fibDP(6));
        Assert.assertEquals(13, fib.fibDP(7));
    }
}
