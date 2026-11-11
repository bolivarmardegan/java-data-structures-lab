package dev.learning.dsa.collections.binarysearchtree;

import dev.learning.dsa.collections.arraylist.MyArrayList;
import java.util.Objects;
public final class MyBinarySearchTree<E extends Comparable<? super E>> {
    private static final class Node<E>{E value;Node<E> left,right;Node(E v){value=v;}}
    private Node<E> root;private int size;
    public int size(){return size;}
    public boolean add(E value){Objects.requireNonNull(value);if(root==null){root=new Node<>(value);size++;return true;}
        Node<E> cur=root;while(true){int c=value.compareTo(cur.value);if(c==0)return false;
            if(c<0){if(cur.left==null){cur.left=new Node<>(value);size++;return true;}cur=cur.left;}
            else{if(cur.right==null){cur.right=new Node<>(value);size++;return true;}cur=cur.right;}}}
    public boolean contains(E value){Objects.requireNonNull(value);Node<E> n=root;
        while(n!=null){int c=value.compareTo(n.value);if(c==0)return true;n=c<0?n.left:n.right;}return false;}
    public MyArrayList<E> inOrder(){MyArrayList<E> out=new MyArrayList<>();walk(root,out);return out;}
    private void walk(Node<E> n,MyArrayList<E> out){if(n==null)return;walk(n.left,out);out.add(n.value);walk(n.right,out);}
}
