package dev.learning.dsa.sorting.insertion;

import dev.learning.dsa.sorting.IntSorter;
public final class InsertionSort implements IntSorter {
    public String name(){return "Insertion";}
    public void sort(int[] a){
        java.util.Objects.requireNonNull(a);
        for(int i=1;i<a.length;i++){int v=a[i],j=i-1;while(j>=0&&a[j]>v){a[j+1]=a[j];j--;}a[j+1]=v;}
    }
}