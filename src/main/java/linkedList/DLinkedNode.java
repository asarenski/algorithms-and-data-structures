package linkedList;

public interface DLinkedNode<T> {
    T getValue();

    DLinkedNode<T> setNext(DLinkedNode<T> next);
    DLinkedNode<T> getNext();

    DLinkedNode<T> setPrevious(DLinkedNode<T> previous);
    DLinkedNode<T> getPrevious();
}
