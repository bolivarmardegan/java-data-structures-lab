package dev.learning.dsa.sorting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
class SortingAlgorithmsTest {
    @TestFactory Stream<DynamicTest> algorithmsMatchArraysSort(){
        return SortingCatalog.all().stream().map(sorter->DynamicTest.dynamicTest(sorter.name(),()->{
            Random rng=new Random(42);
            for(int n:new int[]{0,1,2,3,50,500,1500}){
                for(int repeat=0;repeat<5;repeat++){
                    int[] data=new int[n];for(int i=0;i<n;i++)data[i]=rng.nextInt(1000)-500;
                    int[] expected=data.clone();Arrays.sort(expected);sorter.sort(data);
                    assertArrayEquals(expected,data,"n="+n);
                }
            }
            int[] extremes=sorter.name().equals("Counting")?new int[]{100,-100,0,-2,-2,-100}:new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0,-2,-2,Integer.MIN_VALUE};
            int[] expected=extremes.clone();Arrays.sort(expected);sorter.sort(extremes);assertArrayEquals(expected,extremes);
            assertThrows(NullPointerException.class,()->sorter.sort(null));
        }));
    }
    @Test void countingSortRejectsExcessiveRange(){
        var count=new dev.learning.dsa.sorting.counting.CountingSort();
        assertThrows(IllegalArgumentException.class,()->count.sort(new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE}));
    }
}
