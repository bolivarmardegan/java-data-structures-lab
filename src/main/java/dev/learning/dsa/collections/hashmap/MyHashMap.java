package dev.learning.dsa.collections.hashmap;

import dev.learning.dsa.collections.MyMap;
import java.util.Objects;
public final class MyHashMap<K,V> implements MyMap<K,V> {
    private static final class Node<K,V>{final K key;V value;Node<K,V> next;Node(K k,V v,Node<K,V> n){key=k;value=v;next=n;}}
    @SuppressWarnings("unchecked") private Node<K,V>[] buckets=new Node[16];private int size;
    public int size(){return size;}
    private int index(Object key,int cap){int h=Objects.hashCode(key);h^=h>>>16;return (h&0x7fffffff)%cap;}
    private Node<K,V> find(Object key){for(Node<K,V> n=buckets[index(key,buckets.length)];n!=null;n=n.next)if(Objects.equals(n.key,key))return n;return null;}
    public boolean containsKey(Object key){return find(key)!=null;}
    public V get(Object key){Node<K,V> n=find(key);return n==null?null:n.value;}
    public V put(K key,V value){Node<K,V> n=find(key);if(n!=null){V old=n.value;n.value=value;return old;}
        if(size+1>buckets.length*.75)resize();int b=index(key,buckets.length);buckets[b]=new Node<>(key,value,buckets[b]);size++;return null;}
    public V remove(Object key){int b=index(key,buckets.length);Node<K,V> prev=null;
        for(Node<K,V> n=buckets[b];n!=null;n=n.next){if(Objects.equals(n.key,key)){if(prev==null)buckets[b]=n.next;else prev.next=n.next;size--;return n.value;}prev=n;}return null;}
    @SuppressWarnings("unchecked") private void resize(){Node<K,V>[] old=buckets;buckets=new Node[old.length*2];for(Node<K,V> head:old)for(Node<K,V> n=head;n!=null;){Node<K,V> next=n.next;int b=index(n.key,buckets.length);n.next=buckets[b];buckets[b]=n;n=next;}}
    public void clear(){java.util.Arrays.fill(buckets,null);size=0;}
}
