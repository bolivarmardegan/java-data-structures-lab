package dev.learning.dsa.collections.linkedlist;

import dev.learning.dsa.collections.MyList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
public final class MyLinkedList<E> implements MyList<E> {
    private static final class Node<E>{E value;Node<E> prev,next;Node(E v){value=v;}}
    private Node<E> head,tail;private int size;
    public int size(){return size;}
    public boolean add(E value){add(size,value);return true;}
    public void add(int index,E value){insertIndex(index);Node<E> n=new Node<>(value);
        if(size==0){head=tail=n;}else if(index==0){n.next=head;head.prev=n;head=n;}
        else if(index==size){n.prev=tail;tail.next=n;tail=n;}
        else{Node<E> at=node(index);n.prev=at.prev;n.next=at;at.prev.next=n;at.prev=n;}size++;
    }
    public E get(int index){return node(index).value;}
    public E set(int index,E v){Node<E> n=node(index);E old=n.value;n.value=v;return old;}
    public E removeAt(int index){Node<E> n=node(index);unlink(n);return n.value;}
    public boolean remove(Object value){for(Node<E> n=head;n!=null;n=n.next)if(Objects.equals(n.value,value)){unlink(n);return true;}return false;}
    public boolean contains(Object value){for(Node<E> n=head;n!=null;n=n.next)if(Objects.equals(n.value,value))return true;return false;}
    public void clear(){head=tail=null;size=0;}
    private void unlink(Node<E> n){if(n.prev==null)head=n.next;else n.prev.next=n.next;if(n.next==null)tail=n.prev;else n.next.prev=n.prev;size--;}
    private Node<E> node(int index){if(index<0||index>=size)throw new IndexOutOfBoundsException(index);
        Node<E> n;if(index<size/2){n=head;for(int i=0;i<index;i++)n=n.next;}else{n=tail;for(int i=size-1;i>index;i--)n=n.prev;}return n;}
    private void insertIndex(int i){if(i<0||i>size)throw new IndexOutOfBoundsException(i);}
    public Iterator<E> iterator(){return new Iterator<>(){Node<E> n=head;public boolean hasNext(){return n!=null;}public E next(){if(n==null)throw new NoSuchElementException();E v=n.value;n=n.next;return v;}};}
}
