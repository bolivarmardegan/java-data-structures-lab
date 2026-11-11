package dev.learning.dsa.searching.linear;

public final class LinearSearch {
    private LinearSearch(){}
    public static int indexOf(int[] values,int target){java.util.Objects.requireNonNull(values);
        for(int i=0;i<values.length;i++)if(values[i]==target)return i;return -1;}
}
