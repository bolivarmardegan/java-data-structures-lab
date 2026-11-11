package dev.learning.dsa.sorting.cocktail;

import dev.learning.dsa.sorting.IntSorter;
public final class CocktailSort implements IntSorter {
    public String name(){return "Cocktail";}
    public void sort(int[] a){java.util.Objects.requireNonNull(a);
        int left=0,right=a.length-1;boolean swapped=true;
        while(swapped&&left<right){swapped=false;
            for(int i=left;i<right;i++)if(a[i]>a[i+1]){int t=a[i];a[i]=a[i+1];a[i+1]=t;swapped=true;}
            if(!swapped)break;right--;swapped=false;
            for(int i=right;i>left;i--)if(a[i-1]>a[i]){int t=a[i];a[i]=a[i-1];a[i-1]=t;swapped=true;}
            left++;
        }
    }
}