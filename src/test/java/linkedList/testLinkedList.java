package linkedList;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class testLinkedList {

    @Test
    public void testDefaultConstructorForNode() throws Exception {
        Node node = new Node(5, null, null);
        Assert.assertThat(node.getValue(), CoreMatchers.equalTo(5));
        Assert.assertThat(node.getNext(), CoreMatchers.nullValue());
    }

    @Test
    public void testAdd() {
        LinkedList list = new LinkedList();
        list.add(15);
        list.add(14);
        list.add(13);

        Node nextval;
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
        LinkedList list = new LinkedList();
        Assert.assertThat(list.findItemAtIndex(120), CoreMatchers.nullValue());

        Integer expectedLastIndex = 5;
        Node expectedLastNode = null;
        Integer mockValue = 15;
        for (int i=0; i < expectedLastIndex + 1; i++) {
            Node addedNode = list.add(i);
            if (i == expectedLastIndex) {
                expectedLastNode = addedNode;
            }
            mockValue--;
        }

        Assert.assertThat(list.size(), CoreMatchers.equalTo(6));
        Assert.assertThat(list.findItemAtIndex(5), CoreMatchers.equalTo(expectedLastNode));
    }

    @Test
    public void testFindAtIndexReturnNullIfOutsideLength() throws Exception {
        LinkedList list = new LinkedList();

        Integer expectedLastIndex = 5;
        for (int i=0; i < expectedLastIndex + 1; i++) {
            list.add(i);
        }

        Assert.assertThat(list.findItemAtIndex(expectedLastIndex + 20), CoreMatchers.nullValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindAtIndexThrowsWithNegative() throws Exception {
        LinkedList list = new LinkedList();
        list.findItemAtIndex(-5);
    }
}
