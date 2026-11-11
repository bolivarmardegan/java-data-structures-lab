package dev.learning.dsa.collections.hashset;

import dev.learning.dsa.collections.MySet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
public final class MyHashSet<E> implements MySet<E> {
    private static final class Node<E>{final E value;Node<E> next;Node(E v,Node<E> n){value=v;next=n;}}
    @SuppressWarnings("unchecked") private Node<E>[] buckets=new Node[16];private int size;
    public int size(){return size;}
    private int index(Object key,int length){int h=Objects.hashCode(key);h^=h>>>16;return (h&0x7fffffff)%length;}
    public boolean contains(Object value){for(Node<E> n=buckets[index(value,buckets.length)];n!=null;n=n.next)if(Objects.equals(n.value,value))return true;return false;}
    public boolean add(E value){if(contains(value))return false;if((size+1)>buckets.length*0.75)resize();int b=index(value,buckets.length);buckets[b]=new Node<>(value,buckets[b]);size++;return true;}
    public boolean remove(Object value){int b=index(value,buckets.length);Node<E> prev=null;
        for(Node<E> n=buckets[b];n!=null;n=n.next){if(Objects.equals(n.value,value)){
            if(prev==null)buckets[b]=n.next;else prev.next=n.next;size--;return true;}prev=n;}return false;}
    @SuppressWarnings("unchecked") private void resize(){Node<E>[] old=buckets;buckets=new Node[old.length*2];for(Node<E> head:old){
        for(Node<E> n=head;n!=null;){Node<E> next=n.next;int b=index(n.value,buckets.length);n.next=buckets[b];buckets[b]=n;n=next;}}}
    public void clear(){java.util.Arrays.fill(buckets,null);size=0;}
    public Iterator<E> iterator(){return new Iterator<>(){int bucket;Node<E> node;
        public boolean hasNext(){if(node!=null)return true;while(bucket<buckets.length){if(buckets[bucket]!=null){node=buckets[bucket++];return true;}bucket++;}return false;}
        public E next(){if(!hasNext())throw new NoSuchElementException();E v=node.value;node=node.next;return v;}};}
}
