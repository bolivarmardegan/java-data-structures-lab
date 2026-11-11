package dev.learning.dsa.collections;
import dev.learning.dsa.collections.arraylist.MyArrayList;
import dev.learning.dsa.collections.linkedlist.MyLinkedList;
import dev.learning.dsa.collections.hashset.MyHashSet;
import dev.learning.dsa.collections.hashmap.MyHashMap;
import dev.learning.dsa.collections.arraydeque.MyArrayDeque;
import dev.learning.dsa.collections.stack.MyStack;
import dev.learning.dsa.collections.queue.MyQueue;
import dev.learning.dsa.collections.binarysearchtree.MyBinarySearchTree;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;
class CollectionsTest {
    @Test void arrayListIndicesAndNulls(){var a=new MyArrayList<String>();a.add(null);a.add("z");a.add(1,"b");
        assertEquals(3,a.size());assertTrue(a.contains(null));assertNull(a.removeAt(0));assertEquals("b",a.get(0));
        assertThrows(IndexOutOfBoundsException.class,()->a.get(3));a.clear();assertTrue(a.isEmpty());}
    @Test void linkedListHeadAndTail(){var a=new MyLinkedList<Integer>();a.add(1);a.add(0,0);a.add(2);
        assertEquals(0,a.removeAt(0));assertEquals(2,a.removeAt(1));assertEquals(1,a.get(0));assertTrue(a.remove(1));assertTrue(a.isEmpty());}
    @Test void hashSetResizesAndDeduplicates(){var s=new MyHashSet<Integer>();for(int i=0;i<200;i++)assertTrue(s.add(i));
        assertFalse(s.add(42));assertEquals(200,s.size());assertTrue(s.remove(99));assertFalse(s.contains(99));}
    @Test void hashMapSupportsNullKeyAndResize(){var m=new MyHashMap<String,Integer>();m.put(null,7);
        for(int i=0;i<100;i++)m.put("k"+i,i);assertEquals(7,m.get(null));assertEquals(2,m.put("k2",2));
        assertTrue(m.containsKey("k2"));assertEquals(99,m.remove("k99"));assertFalse(m.containsKey("k99"));}
    @Test void dequeWraparound(){var d=new MyArrayDeque<Integer>();for(int i=0;i<100;i++)d.addLast(i);
        for(int i=0;i<50;i++)assertEquals(i,d.removeFirst());for(int i=100;i<150;i++)d.addLast(i);
        for(int i=149;i>=50;i--)assertEquals(i,d.removeLast());assertTrue(d.isEmpty());
        assertThrows(NoSuchElementException.class,d::removeFirst);}
    @Test void stackAndQueue(){var st=new MyStack<Integer>();st.push(1);st.push(2);assertEquals(2,st.pop());
        var q=new MyQueue<Integer>();q.enqueue(1);q.enqueue(2);assertEquals(1,q.dequeue());}
    @Test void binaryTreeInOrder(){var t=new MyBinarySearchTree<Integer>();for(int x:new int[]{5,3,7,1,4,6,9})assertTrue(t.add(x));
        assertFalse(t.add(5));int last=Integer.MIN_VALUE;for(Integer x:t.inOrder()){assertTrue(x>=last);last=x;}}
}
