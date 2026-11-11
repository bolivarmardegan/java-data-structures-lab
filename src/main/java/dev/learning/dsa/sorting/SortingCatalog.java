package dev.learning.dsa.sorting;

import dev.learning.dsa.sorting.bubble.BubbleSort;
import dev.learning.dsa.sorting.selection.SelectionSort;
import dev.learning.dsa.sorting.insertion.InsertionSort;
import dev.learning.dsa.sorting.merge.MergeSort;
import dev.learning.dsa.sorting.quick.QuickSort;
import dev.learning.dsa.sorting.heap.HeapSort;
import dev.learning.dsa.sorting.shell.ShellSort;
import dev.learning.dsa.sorting.counting.CountingSort;
import dev.learning.dsa.sorting.radix.RadixSort;
import dev.learning.dsa.sorting.cocktail.CocktailSort;
import java.util.List;
public final class SortingCatalog {
    private SortingCatalog(){}
    public static List<IntSorter> all(){return List.of(new BubbleSort(),new SelectionSort(),new InsertionSort(),new MergeSort(),new QuickSort(),new HeapSort(),new ShellSort(),new CountingSort(),new RadixSort(),new CocktailSort());}
}
