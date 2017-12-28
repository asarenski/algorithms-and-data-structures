package linkedList;

import com.google.common.base.Objects;

public class SLinkedNode {
    private Integer value;
    private SLinkedNode next;
    private Integer position;

    public SLinkedNode(Integer value, SLinkedNode next, Integer position) {
        this.value = value;
        this.next = next;
        this.position = position;
    }

    public Integer getValue() {
        return value;
    }

    public SLinkedNode getNext() {
        return next;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SLinkedNode SLinkedNode = (SLinkedNode) o;
        return Objects.equal(value, SLinkedNode.value) &&
                Objects.equal(next, SLinkedNode.next) &&
                Objects.equal(position, SLinkedNode.position);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value, next, position);
    }
}
