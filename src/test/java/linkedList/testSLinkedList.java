package linkedList;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class testSLinkedList {

    @Test
    public void testDefaultConstructorForNode() throws Exception {
        SLinkedNode SLinkedNode = new SLinkedNode(5, null, null);
        Assert.assertThat(SLinkedNode.getValue(), CoreMatchers.equalTo(5));
        Assert.assertThat(SLinkedNode.getNext(), CoreMatchers.nullValue());
    }

    @Test
    public void testAdd() {
        final SLinkedList list = new SLinkedList();
        int countDown = 15;
        for (int i = 0; i < countDown; i++) {
            list.add(countDown);
            Assert.assertThat(list.getFirstValue(), CoreMatchers.equalTo(countDown));
            Assert.assertThat(list.size(), CoreMatchers.equalTo(i + 1));
            countDown--;
        }
    }

    @Test
    public void testFindAtIndex() throws Exception {
        SLinkedList list = new SLinkedList();
        Assert.assertThat(list.findValueAtIndex(120), CoreMatchers.nullValue());

        Integer expectedLastIndex = 5;
        Integer expectedLastSLinkValue = null;
        Integer mockValue = 15;
        for (int i = 0; i < expectedLastIndex + 1; i++) {
            Integer addedSLinkedNode = list.add(i);
            if (i == expectedLastIndex) {
                expectedLastSLinkValue = addedSLinkedNode;
            }
            mockValue--;
        }

        Assert.assertThat(list.size(), CoreMatchers.equalTo(6));
        Assert.assertThat(list.findValueAtIndex(5), CoreMatchers.equalTo(expectedLastSLinkValue));
    }

    @Test
    public void testFindAtIndexReturnNullIfOutsideLength() throws Exception {
        SLinkedList list = new SLinkedList();

        Integer expectedLastIndex = 5;
        for (int i = 0; i < expectedLastIndex + 1; i++) {
            list.add(i);
        }

        Assert.assertThat(list.findValueAtIndex(expectedLastIndex + 20), CoreMatchers.nullValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindAtIndexThrowsWithNegative() throws Exception {
        SLinkedList list = new SLinkedList();
        list.findValueAtIndex(-5);
    }
}
