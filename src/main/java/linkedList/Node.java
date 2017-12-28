package linkedList;

import com.google.common.base.Objects;

public class Node {
    private Integer value;
    private Node next;
    private Integer position;

    public Node(Integer value, Node next, Integer position) {
        this.value = value;
        this.next = next;
        this.position = position;
    }

    public Integer getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equal(value, node.value) &&
                Objects.equal(next, node.next) &&
                Objects.equal(position, node.position);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value, next, position);
    }
}
