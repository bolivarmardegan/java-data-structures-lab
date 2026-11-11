package dev.learning.dsa.examples;

import dev.learning.dsa.collections.arraylist.MyArrayList;
import dev.learning.dsa.collections.linkedlist.MyLinkedList;
import dev.learning.dsa.collections.hashset.MyHashSet;
import dev.learning.dsa.collections.hashmap.MyHashMap;
import dev.learning.dsa.collections.queue.MyQueue;
import dev.learning.dsa.collections.stack.MyStack;
import dev.learning.dsa.collections.binarysearchtree.MyBinarySearchTree;
public final class CollectionExamples {
    private CollectionExamples(){}
    public static void main(String[] args){
        var list=new MyArrayList<String>();list.add("Java");list.add("Python");System.out.println("ArrayList: "+list.get(0));
        var linked=new MyLinkedList<Integer>();linked.add(10);linked.add(0,5);System.out.println("LinkedList: "+linked.get(0));
        var set=new MyHashSet<String>();set.add("retro");set.add("retro");System.out.println("HashSet size: "+set.size());
        var map=new MyHashMap<String,Integer>();map.put("level",21);System.out.println("HashMap: "+map.get("level"));
        var queue=new MyQueue<String>();queue.enqueue("first");System.out.println("Queue: "+queue.dequeue());
        var stack=new MyStack<Integer>();stack.push(42);System.out.println("Stack: "+stack.pop());
        var bst=new MyBinarySearchTree<Integer>();bst.add(3);bst.add(1);bst.add(5);System.out.println("BST contains 5: "+bst.contains(5));
    }
}
