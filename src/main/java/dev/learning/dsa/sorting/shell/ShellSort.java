package dev.learning.dsa.sorting.shell;

import dev.learning.dsa.sorting.IntSorter;
public final class ShellSort implements IntSorter {
    public String name(){return "Shell";}
    public void sort(int[] a){java.util.Objects.requireNonNull(a);
        for(int gap=a.length/2;gap>0;gap/=2)for(int i=gap;i<a.length;i++){
            int v=a[i],j=i;while(j>=gap&&a[j-gap]>v){a[j]=a[j-gap];j-=gap;}a[j]=v;
        }
    }
}