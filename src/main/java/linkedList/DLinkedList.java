package linkedList;

public class DLinkedList<T> {
    private DLinkedNode<T> head;
    private DLinkedNode<T> tail;

    public DLinkedList(DLinkedNode<T> head) {
        this.head = head;

        this.tail = head;
        while (this.tail.getNext() != null) {
            this.tail = this.tail.getNext();
        }
    }

    public DLinkedNode<T> getHead() {
        return head;
    }

    public DLinkedNode<T> getTail() {
        return tail;
    }

    /**
     * Adds a new head to the list in O(1) time.
     *
     * @param nextHead the node to replace the head of the list.
     */
    public void addHead(DLinkedNode<T> nextHead) {
        DLinkedNode<T> headCopy = this.head;
        this.head = nextHead;
        nextHead.setNext(headCopy);
        headCopy.setPrevious(this.head);
    }

    /**
     * Adds a new tail to the list in O(1) time.
     *
     * @param nextTail the node to replace the tail of the list.
     */
    public void addTail(DLinkedNode<T> nextTail) {
        DLinkedNode<T> tailCopy = this.tail;
        this.tail = nextTail;
        tailCopy.setNext(this.tail);
        this.tail.setPrevious(tailCopy);
    }

    /**
     * Deletes the node in O(n) time.
     *
     * @param value the node value
     * @return DLinkedNode
     */
    public DLinkedNode<T> delete(T value) {
        DLinkedNode<T> found = findNode(value);

        if (found == null) {
            return null;
        }

        DLinkedNode<T> prev = found.getPrevious();
        DLinkedNode<T> next = found.getNext();

        next.setPrevious(prev);
        prev.setNext(next);

        return found;
    }

    /**
     * Finds the node in O(n) time.
     *
     * @param value the node value
     * @return DLinkedNode
     */
    private DLinkedNode<T> findNode(T value) {
        DLinkedNode<T> n = this.head;
        while (n != null) {
            if (n.getValue().equals(value)) {
                return n;
            }
            n = n.getNext();
        }
        return null;
    }
}
