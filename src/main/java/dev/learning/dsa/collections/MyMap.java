package dev.learning.dsa.collections;

public interface MyMap<K,V> {
    int size();
    V put(K key,V value);
    V get(Object key);
    V remove(Object key);
    boolean containsKey(Object key);
    void clear();
    default boolean isEmpty(){return size()==0;}
}
