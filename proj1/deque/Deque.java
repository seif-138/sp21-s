package deque;

public interface Deque<T> {
    public void addFirst(T item);
    public void addLast(T item);
    boolean isEmpty();
    public int size();
    public T removeFirst();
    public T removeLast();
    public T get(int index);


}
