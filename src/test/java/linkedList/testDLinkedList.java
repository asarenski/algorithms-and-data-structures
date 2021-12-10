package linkedList;

import org.junit.Assert;
import org.junit.Test;

public class testDLinkedList {
    @Test
    public void testGeneral() {
        DLinkedInteger d1 = new DLinkedInteger(1);
        DLinkedInteger d2 = new DLinkedInteger(2);
        DLinkedInteger d3 = new DLinkedInteger(3);

        d1.setNext(d2);
        d2.setPrevious(d1);

        d2.setNext(d3);
        d3.setPrevious(d2);

        Assert.assertNull(d1.getPrevious());
        Assert.assertNull(d3.getNext());

        Assert.assertEquals(d1.getNext(), d2);
        Assert.assertEquals(d2.getPrevious(), d1);
        Assert.assertEquals(d2.getNext(), d3);
        Assert.assertEquals(d3.getPrevious(), d2);
    }
}
