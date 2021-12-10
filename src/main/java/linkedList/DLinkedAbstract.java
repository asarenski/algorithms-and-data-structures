package linkedList;

public abstract class DLinkedAbstract<T> implements DLinkedNode<T> {
    private T value;
    private DLinkedNode<T> next;
    private DLinkedNode<T> previous;

    public DLinkedAbstract(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public DLinkedNode<T> setNext(DLinkedNode<T> next) {
        this.next = next;
        return this.next;
    }

    @Override
    public DLinkedNode<T> getNext() {
        return next;
    }

    @Override
    public DLinkedNode<T> setPrevious(DLinkedNode<T> previous) {
        this.previous = previous;
        return this.previous;
    }

    @Override
    public DLinkedNode<T> getPrevious() {
        return previous;
    }
}
