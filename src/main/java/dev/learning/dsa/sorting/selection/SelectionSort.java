package dev.learning.dsa.sorting.selection;

import dev.learning.dsa.sorting.IntSorter;
public final class SelectionSort implements IntSorter {
    public String name(){return "Selection";}
    public void sort(int[] a){
        java.util.Objects.requireNonNull(a);
        for(int i=0;i<a.length;i++) {int min=i;for(int j=i+1;j<a.length;j++)if(a[j]<a[min])min=j;
        int t=a[i];a[i]=a[min];a[min]=t;}
    }
}