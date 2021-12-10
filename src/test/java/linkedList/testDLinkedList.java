package linkedList;

import org.junit.Assert;
import org.junit.Test;

public class testDLinkedList {
    @Test
    public void testDLinkedNodes() {
        int start = 1;
        int total = 20;

        DLinkedInteger head = new DLinkedInteger(start);
        DLinkedInteger curr = head;

        for (int i=start+1; i<total+1; i++) {
            DLinkedInteger next = new DLinkedInteger(i);
            curr.setNext(next);
            next.setPrevious(curr);

            curr = next;
        }

        Assert.assertNull(head.getPrevious());

        Assert.assertEquals(Integer.valueOf(start+1), head.getNext().getValue());
    }

    @Test
    public void testDLinkedListGet() {
        int start = 1;
        int total = 20;

        DLinkedInteger head = new DLinkedInteger(start);
        DLinkedInteger curr = head;

        for (int i=start+1; i<total+1; i++) {
            DLinkedInteger next = new DLinkedInteger(i);
            curr.setNext(next);
            next.setPrevious(curr);

            curr = next;
        }

        DLinkedList<Integer> list = new DLinkedList<>(head);

        Assert.assertEquals(head, list.getHead());
        Assert.assertEquals(Integer.valueOf(1), list.getHead().getValue());
        Assert.assertEquals(Integer.valueOf(20), list.getTail().getValue());
    }

    @Test
    public void testAddHead() {
        DLinkedList<Integer> list = this.setupList(1, 20);
        Assert.assertEquals(Integer.valueOf(1), list.getHead().getValue());
        Assert.assertEquals(Integer.valueOf(20), list.getTail().getValue());

        list.addHead(new DLinkedInteger(0));
        Assert.assertEquals(Integer.valueOf(0), list.getHead().getValue());
        Assert.assertEquals(Integer.valueOf(1), list.getHead().getNext().getValue());
        Assert.assertEquals(Integer.valueOf(0), list.getHead().getNext().getPrevious().getValue());
    }

    @Test
    public void testAddTail() throws Exception {
        DLinkedList<Integer> list = this.setupList(1, 20);
        Assert.assertEquals(Integer.valueOf(1), list.getHead().getValue());
        Assert.assertEquals(Integer.valueOf(20), list.getTail().getValue());

        list.addTail(new DLinkedInteger(21));

        Assert.assertEquals(Integer.valueOf(21), list.getTail().getValue());
        Assert.assertEquals(Integer.valueOf(20), list.getTail().getPrevious().getValue());
        Assert.assertEquals(Integer.valueOf(21), list.getTail().getPrevious().getNext().getValue());
    }

    private DLinkedList<Integer> setupList(int start, int total) {
        DLinkedInteger head = new DLinkedInteger(start);
        DLinkedInteger curr = head;

        for (int i=start+1; i<total+1; i++) {
            DLinkedInteger next = new DLinkedInteger(i);
            curr.setNext(next);
            next.setPrevious(curr);

            curr = next;
        }

        return new DLinkedList<>(head);
    }
}
