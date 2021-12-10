package linkedList;

public class DLinkedList<T> {
    private DLinkedNode<T> head;
    private DLinkedNode<T> tail;
    private Integer length = 0;

    public DLinkedList(DLinkedNode<T> head) {
        this.head = head;
        this.tail = head;

        if (this.head != null) {
            length++;
        }

        while (this.tail != null && this.tail.getNext() != null) {
            this.tail = this.tail.getNext();
            length++;
        }
    }

    public DLinkedNode<T> getHead() {
        return head;
    }

    public DLinkedNode<T> getTail() {
        return tail;
    }

    public Integer length() {
        return length;
    }

    /**
     * Adds a new head to the list in O(1) time.
     *
     * @param nextHead the node to replace the head of the list.
     */
    public void addHead(DLinkedNode<T> nextHead) {
        if (this.head == null) {
            this.head = nextHead;
            if (this.tail == null) {
                this.tail = this.head;
            }
            length++;
            return;
        }

        DLinkedNode<T> headCopy = this.head;
        this.head = nextHead;
        nextHead.setNext(headCopy);
        headCopy.setPrevious(this.head);
        length++;
    }

    /**
     * Adds a new tail to the list in O(1) time.
     *
     * @param nextTail the node to replace the tail of the list.
     */
    public void addTail(DLinkedNode<T> nextTail) {
        if (this.tail == null) {
            this.addHead(nextTail);
            length++;
            return;
        }

        DLinkedNode<T> tailCopy = this.tail;
        this.tail = nextTail;
        tailCopy.setNext(this.tail);
        this.tail.setPrevious(tailCopy);
        length++;
    }

    /**
     * Deletes the node in O(n) time.
     *
     * @param value the node value
     * @return DLinkedNode
     */
    public DLinkedNode<T> delete(T value) {
        if (length == 0) {
            return null;
        }

        DLinkedNode<T> found = find(value);

        if (found == null) {
            return null;
        }

        if (length == 1) {
            this.head = null;
            this.tail = null;
            length--;
            return found;
        }

        if (length == 2) {
            if (found == this.head) {
                this.head = this.tail;
            } else {
                this.tail = this.head;
            }

            length--;
            return found;
        }

        DLinkedNode<T> prev = found.getPrevious();
        DLinkedNode<T> next = found.getNext();

        next.setPrevious(prev);
        prev.setNext(next);

        length--;
        return found;
    }

    /**
     * Finds the node in O(n) time.
     *
     * @param value the desired value
     * @return DLinkedNode
     */
    public DLinkedNode<T> find(T value) {
        DLinkedNode<T> n = this.head;
        while (n != null) {
            if (n.getValue().equals(value)) {
                return n;
            }
            n = n.getNext();
        }
        return null;
    }

    /**
     * Says if the list contains the desired value in O(n) time.
     *
     * @param value the desired value
     * @return
     */
    public Boolean contains(T value) {
        return this.find(value) != null;
    }
}
