package util;

public class NodeImpl<T> implements Node<T> {
    private final T value;
    
    public NodeImpl(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }
}
