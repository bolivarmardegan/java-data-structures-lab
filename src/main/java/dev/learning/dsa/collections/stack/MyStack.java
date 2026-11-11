package dev.learning.dsa.collections.stack;

import dev.learning.dsa.collections.arraylist.MyArrayList;
import java.util.NoSuchElementException;
public final class MyStack<E> {
    private final MyArrayList<E> data=new MyArrayList<>();
    public void push(E v){data.add(v);}
    public E pop(){if(data.isEmpty())throw new NoSuchElementException();return data.removeAt(data.size()-1);}
    public E peek(){if(data.isEmpty())throw new NoSuchElementException();return data.get(data.size()-1);}
    public int size(){return data.size();}
    public boolean isEmpty(){return data.isEmpty();}
}
