package dev.learning.dsa.searching;
import dev.learning.dsa.searching.binary.BinarySearch;
import dev.learning.dsa.searching.linear.LinearSearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class SearchTest {
    @Test void matchesSearchExpectations(){assertEquals(2,BinarySearch.indexOf(new int[]{1,3,5,9},5));
        assertEquals(-1,BinarySearch.indexOf(new int[]{1,3,5,9},6));
        assertEquals(1,LinearSearch.indexOf(new int[]{10,20,30},20));
        assertEquals(-1,LinearSearch.indexOf(new int[]{10,20},1));}
}
