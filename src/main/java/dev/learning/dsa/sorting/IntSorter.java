package dev.learning.dsa.sorting;

public interface IntSorter {
    String name();
    /** Sorts in-place, ascending. Null is rejected. */
    void sort(int[] values);
}
