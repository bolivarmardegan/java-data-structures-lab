package dev.learning.dsa.benchmarks;

import dev.learning.dsa.sorting.SortingCatalog;
import java.util.Arrays;
import java.util.Random;
/** Educational microbenchmark, not JMH. Median of repeated runs after JVM warm-up.
 *  To compare production-grade numbers, use JMH and isolate system load. */
public final class SortingBenchmarks {
    private SortingBenchmarks(){}
    public static void main(String[] args){
        int[] sizes={100,500,1_000,2_000,5_000,10_000};
        System.out.println("algorithm,n,median_ms");
        for(var sorter:SortingCatalog.all())for(int n:sizes){
            if(n>2_000&&(sorter.name().equals("Bubble")||sorter.name().equals("Selection")||sorter.name().equals("Cocktail")))continue;
            if(n>5_000&&sorter.name().equals("Insertion"))continue;
            int[] data=new int[n];Random r=new Random(20261111L+n);for(int i=0;i<n;i++)data[i]=r.nextInt(100_000)-50_000;
            for(int warm=0;warm<4;warm++){int[] a=data.clone();sorter.sort(a);}
            double[] times=new double[7];
            for(int iteration=0;iteration<times.length;iteration++){
                int[] a=data.clone();long start=System.nanoTime();sorter.sort(a);
                times[iteration]=(System.nanoTime()-start)/1_000_000.0;
                for(int i=1;i<a.length;i++)if(a[i-1]>a[i])throw new IllegalStateException(sorter.name());
            }
            Arrays.sort(times);System.out.printf(java.util.Locale.ROOT,"%s,%d,%.6f%n",sorter.name(),n,times[3]);
        }
    }
}
