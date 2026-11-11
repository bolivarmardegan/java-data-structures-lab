package dev.learning.dsa.examples;

import dev.learning.dsa.sorting.SortingCatalog;
import java.util.Arrays;
public final class SortingExamples {
    private SortingExamples(){}
    public static void main(String[] args){int[] sample={9,-4,3,9,0,2,Integer.MIN_VALUE,Integer.MAX_VALUE};
        for(var sorter:SortingCatalog.all()) {int[] a=sorter.name().equals("Counting")?new int[]{9,-4,3,9,0,2}:sample.clone();sorter.sort(a);System.out.printf("%-12s %s%n",sorter.name(),Arrays.toString(a));}}
}
