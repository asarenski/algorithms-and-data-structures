package linkedList;

import java.util.Objects;

public class SLinkedList {
    private SLinkedNode head;
    private Integer length = 0;

    public SLinkedList() {
        head = null;
    }

    public Integer add(Integer val) {
        head = new SLinkedNode(val, head, ++length);
        return head.getValue();
    }

    public Integer size() {
        return length;
    }

    public Integer getFirstValue() {
        return head.getValue();
    }

    public Integer findValueAtIndex(Integer index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Cannot use negative indexes.");
        }

        SLinkedNode checked = head;
        while (Objects.nonNull(checked)) {
            if (checked.getPosition() - 1 == index) {
                return checked.getValue();
            }
            checked = checked.getNext();
        }

        return null;
    }
}
