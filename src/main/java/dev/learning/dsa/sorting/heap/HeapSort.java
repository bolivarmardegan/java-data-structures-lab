package dev.learning.dsa.sorting.heap;

import dev.learning.dsa.sorting.IntSorter;
public final class HeapSort implements IntSorter {
    public String name(){return "Heap";}
    public void sort(int[] a){java.util.Objects.requireNonNull(a);int n=a.length;
        for(int i=n/2-1;i>=0;i--)sift(a,n,i);
        for(int end=n-1;end>0;end--){int t=a[0];a[0]=a[end];a[end]=t;sift(a,end,0);}
    }
    private void sift(int[] a,int n,int i){while(true){int left=2*i+1;if(left>=n)return;int largest=left;
        if(left+1<n&&a[left+1]>a[left])largest=left+1;
        if(a[i]>=a[largest])return;int t=a[i];a[i]=a[largest];a[largest]=t;i=largest;}}
}