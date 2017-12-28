package linkedList;

public class Node {
    private Integer value;
    private Node next;

    public Node(Integer value) {
        this(value, null);
    }

    public Node(Integer value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
