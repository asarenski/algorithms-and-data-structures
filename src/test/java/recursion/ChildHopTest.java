package recursion;

import org.junit.Assert;
import org.junit.Test;

public class ChildHopTest {
    @Test
    public void childHop() {
        ChildHop hop = new ChildHop();
        Assert.assertEquals(4, hop.hopDP(3));
        Assert.assertEquals(7, hop.hopDP(4));
    }
}
