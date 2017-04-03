package linkedList;

public class LinkedList {
    private Node first;

    public LinkedList() {
        first = null;
    }

    public Node add(Integer val) {
        Node added = new Node(val, first);
        first = added;
        return first;
    }

    public Node getFirst() {
        return first;
    }
}
