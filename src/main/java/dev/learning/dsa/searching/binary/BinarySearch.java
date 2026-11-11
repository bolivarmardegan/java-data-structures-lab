package dev.learning.dsa.searching.binary;

public final class BinarySearch {
    private BinarySearch(){}
    /** Input must already be sorted in ascending order. */
    public static int indexOf(int[] values,int target){java.util.Objects.requireNonNull(values);int lo=0,hi=values.length-1;
        while(lo<=hi){int mid=lo+(hi-lo)/2;if(values[mid]==target)return mid;
            if(values[mid]<target)lo=mid+1;else hi=mid-1;}return -1;}
}
