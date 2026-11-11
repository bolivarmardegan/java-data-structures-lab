package dev.learning.dsa.collections;

public interface MyCollection<E> extends Iterable<E> {
    int size();
    boolean add(E value);
    boolean contains(Object value);
    boolean remove(Object value);
    void clear();
    default boolean isEmpty(){return size()==0;}
}
