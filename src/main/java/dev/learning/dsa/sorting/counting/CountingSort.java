package dev.learning.dsa.sorting.counting;

import dev.learning.dsa.sorting.IntSorter;
public final class CountingSort implements IntSorter {
    private static final long MAX_RANGE=2_000_000L;
    public String name(){return "Counting";}
    public void sort(int[] a){java.util.Objects.requireNonNull(a);if(a.length<2)return;
        int min=a[0],max=a[0];for(int x:a){min=Math.min(min,x);max=Math.max(max,x);}
        long range=(long)max-min+1;
        if(range>MAX_RANGE)throw new IllegalArgumentException("Counting sort range exceeds 2,000,000; use Merge/Quick instead");
        int[] count=new int[(int)range];for(int x:a)count[(int)((long)x-min)]++;
        int k=0;for(int i=0;i<count.length;i++)for(int n=count[i];n>0;n--)a[k++]=(int)((long)min+i);
    }
}