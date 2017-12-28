package linkedList;

import java.util.Objects;

public class SLinkedList {
    private SLinkedNode first;
    private Integer length = 0;

    public SLinkedList() {
        first = null;
    }

    public SLinkedNode add(Integer val) {
        first = new SLinkedNode(val, first, ++length);
        return first;
    }

    public SLinkedNode getFirst() {
        return first;
    }

    public Integer size() {
        return length;
    }

    public SLinkedNode findItemAtIndex(Integer index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Cannot use negative indexes.");
        }

        SLinkedNode checked = first;
        while (Objects.nonNull(checked)) {
            if (checked.getPosition() - 1 == index) {
                return checked;
            }
            checked = checked.getNext();
        }

        return null;
    }
}
