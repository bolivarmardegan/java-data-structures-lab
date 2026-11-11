package dev.learning.dsa.sorting.bubble;

import dev.learning.dsa.sorting.IntSorter;
public final class BubbleSort implements IntSorter {
    public String name() { return "Bubble"; }
    public void sort(int[] a) {
        java.util.Objects.requireNonNull(a);
        for (int end=a.length-1; end>0; end--) {
            boolean swapped=false;
            for (int i=0;i<end;i++) if(a[i]>a[i+1]) { int t=a[i];a[i]=a[i+1];a[i+1]=t;swapped=true; }
            if (!swapped) break;
        }
    }
}