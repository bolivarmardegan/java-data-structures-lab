package dev.learning.dsa.sorting.quick;

import dev.learning.dsa.sorting.IntSorter;
public final class QuickSort implements IntSorter {
    public String name(){return "Quick";}
    public void sort(int[] a){java.util.Objects.requireNonNull(a);quick(a,0,a.length-1);}
    /** Median-of-three pivot + recurse on smaller half to bound stack depth. */
    private void quick(int[] a,int lo,int hi){
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            int x=a[lo],y=a[mid],z=a[hi];
            int pivot=x<y?(y<z?y:(x<z?z:x)):(x<z?x:(y<z?z:y));
            int i=lo,j=hi;
            while(i<=j){while(a[i]<pivot)i++;while(a[j]>pivot)j--;if(i<=j){int t=a[i];a[i]=a[j];a[j]=t;i++;j--;}}
            if(j-lo<hi-i){if(lo<j)quick(a,lo,j);lo=i;}else{if(i<hi)quick(a,i,hi);hi=j;}
        }
    }
}