package linkedList;

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
}
