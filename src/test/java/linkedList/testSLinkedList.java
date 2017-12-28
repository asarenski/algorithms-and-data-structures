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
        SLinkedList list = new SLinkedList();
        list.add(15);
        list.add(14);
        list.add(13);

        SLinkedNode nextval;
        nextval = list.getFirst();
        Assert.assertThat(nextval.getValue(), CoreMatchers.equalTo(13));

        nextval = nextval.getNext();
        Assert.assertThat(nextval.getValue(), CoreMatchers.equalTo(14));

        nextval = nextval.getNext();
        Assert.assertThat(nextval.getValue(), CoreMatchers.equalTo(15));

        nextval = nextval.getNext();
        Assert.assertThat(nextval, CoreMatchers.nullValue());
    }

    @Test
    public void testFindAtIndex() throws Exception {
        SLinkedList list = new SLinkedList();
        Assert.assertThat(list.findItemAtIndex(120), CoreMatchers.nullValue());

        Integer expectedLastIndex = 5;
        SLinkedNode expectedLastSLinkedNode = null;
        Integer mockValue = 15;
        for (int i=0; i < expectedLastIndex + 1; i++) {
            SLinkedNode addedSLinkedNode = list.add(i);
            if (i == expectedLastIndex) {
                expectedLastSLinkedNode = addedSLinkedNode;
            }
            mockValue--;
        }

        Assert.assertThat(list.size(), CoreMatchers.equalTo(6));
        Assert.assertThat(list.findItemAtIndex(5), CoreMatchers.equalTo(expectedLastSLinkedNode));
    }

    @Test
    public void testFindAtIndexReturnNullIfOutsideLength() throws Exception {
        SLinkedList list = new SLinkedList();

        Integer expectedLastIndex = 5;
        for (int i=0; i < expectedLastIndex + 1; i++) {
            list.add(i);
        }

        Assert.assertThat(list.findItemAtIndex(expectedLastIndex + 20), CoreMatchers.nullValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindAtIndexThrowsWithNegative() throws Exception {
        SLinkedList list = new SLinkedList();
        list.findItemAtIndex(-5);
    }
}
