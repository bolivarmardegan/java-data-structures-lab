package dev.learning.dsa.collections.queue;

import dev.learning.dsa.collections.arraydeque.MyArrayDeque;
public final class MyQueue<E> {
    private final MyArrayDeque<E> data=new MyArrayDeque<>();
    public void enqueue(E v){data.addLast(v);}
    public E dequeue(){return data.removeFirst();}
    public int size(){return data.size();}
    public boolean isEmpty(){return data.isEmpty();}
}
