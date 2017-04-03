package linkedList;

public class Node {
    private Integer value;
    private Node nextVal;

    public Node(Integer value) {
        this.value = value;
    }

    public Node(Integer value, Node nextVal) {
        this.value = value;
        this.nextVal = nextVal;
    }

    public Integer getValue() {
        return value;
    }

    public Node getNextVal() {
        return nextVal;
    }
}
