package dev.learning.dsa.verification;

import dev.learning.dsa.sorting.SortingCatalog;
import dev.learning.dsa.collections.arraylist.MyArrayList;
import dev.learning.dsa.collections.linkedlist.MyLinkedList;
import dev.learning.dsa.collections.hashset.MyHashSet;
import dev.learning.dsa.collections.hashmap.MyHashMap;
import dev.learning.dsa.collections.arraydeque.MyArrayDeque;
import dev.learning.dsa.collections.queue.MyQueue;
import dev.learning.dsa.collections.stack.MyStack;
import dev.learning.dsa.collections.binarysearchtree.MyBinarySearchTree;
import dev.learning.dsa.searching.binary.BinarySearch;
import dev.learning.dsa.searching.linear.LinearSearch;
import java.util.Arrays;
import java.util.Random;
public final class SmokeTests {
    private SmokeTests(){}
    public static void main(String[] args){
        Random random=new Random(20261111);
        for(var sorter:SortingCatalog.all()){
            for(int n:new int[]{0,1,2,3,10,100,500})for(int iteration=0;iteration<6;iteration++){
                int[] a=new int[n];for(int i=0;i<n;i++)a[i]=random.nextInt(500)-250;
                int[] expected=a.clone();Arrays.sort(expected);sorter.sort(a);
                if(!Arrays.equals(expected,a))throw new AssertionError(sorter.name()+" n="+n);
            }
            int[] edge=sorter.name().equals("Counting")?new int[]{-100,200,0,-1,1,-100}:new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0,-1,1,Integer.MIN_VALUE};int[] expected=edge.clone();Arrays.sort(expected);sorter.sort(edge);
            if(!Arrays.equals(expected,edge))throw new AssertionError(sorter.name()+" signed extremes");
        }
        var a=new MyArrayList<String>();a.add("a");a.add(null);a.add(1,"b");if(a.size()!=3||!a.remove(null)||!a.get(1).equals("b"))throw new AssertionError("arraylist");
        var l=new MyLinkedList<Integer>();l.add(2);l.add(0,1);l.add(3);if(l.removeAt(1)!=2||l.size()!=2)throw new AssertionError("linkedlist");
        var s=new MyHashSet<Integer>();for(int i=0;i<100;i++)s.add(i);if(s.size()!=100||s.add(10)||!s.remove(20)||s.contains(20))throw new AssertionError("hashset");
        var m=new MyHashMap<String,Integer>();m.put(null,1);m.put("x",2);if(m.get(null)!=1||m.put("x",3)!=2||m.get("x")!=3)throw new AssertionError("hashmap");
        var d=new MyArrayDeque<Integer>();for(int i=0;i<100;i++)d.addLast(i);for(int i=0;i<100;i++)if(d.removeFirst()!=i)throw new AssertionError("deque");
        var q=new MyQueue<Integer>();q.enqueue(9);if(q.dequeue()!=9)throw new AssertionError("queue");
        var stack=new MyStack<Integer>();stack.push(1);stack.push(2);if(stack.pop()!=2)throw new AssertionError("stack");
        var tree=new MyBinarySearchTree<Integer>();tree.add(3);tree.add(1);tree.add(2);if(!tree.contains(2)||tree.size()!=3||tree.add(2))throw new AssertionError("bst");
        if(BinarySearch.indexOf(new int[]{1,2,4,7},4)!=2||LinearSearch.indexOf(new int[]{3,2,1},2)!=1)throw new AssertionError("search");
        System.out.println("PASS: all sorting algorithms and collection smoke checks");
    }
}
