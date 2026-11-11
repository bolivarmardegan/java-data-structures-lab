package dev.learning.dsa.collections.arraylist;

import dev.learning.dsa.collections.MyList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
public final class MyArrayList<E> implements MyList<E> {
    private Object[] elements=new Object[10];private int size;
    public int size(){return size;}
    public boolean add(E value){grow(size+1);elements[size++]=value;return true;}
    public void add(int index,E value){checkInsert(index);grow(size+1);System.arraycopy(elements,index,elements,index+1,size-index);elements[index]=value;size++;}
    @SuppressWarnings("unchecked") public E get(int index){check(index);return (E)elements[index];}
    public E set(int index,E value){check(index);E old=get(index);elements[index]=value;return old;}
    public E removeAt(int index){E old=get(index);int trailing=size-index-1;if(trailing>0)System.arraycopy(elements,index+1,elements,index,trailing);elements[--size]=null;return old;}
    public boolean remove(Object value){for(int i=0;i<size;i++)if(Objects.equals(elements[i],value)){removeAt(i);return true;}return false;}
    public boolean contains(Object value){for(int i=0;i<size;i++)if(Objects.equals(elements[i],value))return true;return false;}
    public void clear(){for(int i=0;i<size;i++)elements[i]=null;size=0;}
    private void grow(int min){if(min>elements.length){int n=Math.max(min,elements.length+elements.length/2+1);elements=java.util.Arrays.copyOf(elements,n);}}
    private void check(int i){if(i<0||i>=size)throw new IndexOutOfBoundsException(i);}
    private void checkInsert(int i){if(i<0||i>size)throw new IndexOutOfBoundsException(i);}
    public Iterator<E> iterator(){return new Iterator<>(){int i;public boolean hasNext(){return i<size;}public E next(){if(!hasNext())throw new NoSuchElementException();return get(i++);}};}
}
