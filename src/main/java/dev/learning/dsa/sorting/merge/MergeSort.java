package dev.learning.dsa.sorting.merge;

import dev.learning.dsa.sorting.IntSorter;
public final class MergeSort implements IntSorter {
    public String name(){return "Merge";}
    public void sort(int[] a){java.util.Objects.requireNonNull(a);int[] temp=new int[a.length];merge(a,temp,0,a.length);}
    private void merge(int[] a,int[] t,int lo,int hi){
        if(hi-lo<2)return;int mid=lo+(hi-lo)/2;merge(a,t,lo,mid);merge(a,t,mid,hi);
        int i=lo,j=mid,k=lo;
        while(i<mid&&j<hi)t[k++]=a[i]<=a[j]?a[i++]:a[j++];
        while(i<mid)t[k++]=a[i++];while(j<hi)t[k++]=a[j++];
        System.arraycopy(t,lo,a,lo,hi-lo);
    }
}