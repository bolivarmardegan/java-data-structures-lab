package dev.learning.dsa.collections;

public interface MyList<E> extends MyCollection<E> {
    E get(int index);
    E set(int index,E value);
    void add(int index,E value);
    E removeAt(int index);
}
