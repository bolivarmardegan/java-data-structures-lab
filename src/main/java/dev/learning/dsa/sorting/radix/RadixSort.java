package dev.learning.dsa.sorting.radix;

import dev.learning.dsa.sorting.IntSorter;
public final class RadixSort implements IntSorter {
    public String name(){return "Radix";}
    /** Four stable byte passes; sign bit is flipped so signed ints sort correctly. */
    public void sort(int[] a){java.util.Objects.requireNonNull(a);int n=a.length;if(n<2)return;
        int[] tmp=new int[n];
        for(int shift=0;shift<32;shift+=8){
            int[] count=new int[256];
            for(int x:a)count[((x^Integer.MIN_VALUE)>>>shift)&255]++;
            int offset=0;for(int i=0;i<256;i++){int c=count[i];count[i]=offset;offset+=c;}
            for(int x:a){int b=((x^Integer.MIN_VALUE)>>>shift)&255;tmp[count[b]++]=x;}
            System.arraycopy(tmp,0,a,0,n);
        }
    }
}