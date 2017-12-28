package linkedList;

public class LinkedList {
    private Node first;

    public LinkedList() {
        first = null;
    }

    public Node add(Integer val) {
        first = new Node(val, first);
        return first;
    }

    public Node getFirst() {
        return first;
    }
}
