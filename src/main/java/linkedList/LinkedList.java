package linkedList;

import java.util.Objects;

public class LinkedList {
    private Node first;
    private Integer length = 0;

    public LinkedList() {
        first = null;
    }

    public Node add(Integer val) {
        first = new Node(val, first, ++length);
        return first;
    }

    public Node getFirst() {
        return first;
    }

    public Integer size() {
        return length;
    }

    public Node findItemAtIndex(Integer index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Cannot use negative indexes.");
        }

        Node checked = first;
        while (Objects.nonNull(checked)) {
            if (checked.getPosition() - 1 == index) {
                return checked;
            }
            checked = checked.getNext();
        }

        return null;
    }
}
