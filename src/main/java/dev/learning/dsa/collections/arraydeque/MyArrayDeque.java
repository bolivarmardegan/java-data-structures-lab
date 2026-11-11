package dev.learning.dsa.collections.arraydeque;

import java.util.NoSuchElementException;
public final class MyArrayDeque<E> {
    private Object[] data=new Object[8];private int head,size;
    public int size(){return size;}
    public boolean isEmpty(){return size==0;}
    public void addFirst(E value){if(value==null)throw new NullPointerException("null disallowed");grow();head=(head-1+data.length)%data.length;data[head]=value;size++;}
    public void addLast(E value){if(value==null)throw new NullPointerException("null disallowed");grow();data[(head+size)%data.length]=value;size++;}
    @SuppressWarnings("unchecked") public E removeFirst(){if(size==0)throw new NoSuchElementException();E v=(E)data[head];data[head]=null;head=(head+1)%data.length;size--;return v;}
    @SuppressWarnings("unchecked") public E removeLast(){if(size==0)throw new NoSuchElementException();int i=(head+size-1)%data.length;E v=(E)data[i];data[i]=null;size--;return v;}
    private void grow(){if(size<data.length)return;Object[] next=new Object[data.length*2];for(int i=0;i<size;i++)next[i]=data[(head+i)%data.length];data=next;head=0;}
}
