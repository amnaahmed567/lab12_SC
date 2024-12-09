package expressivo;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class BinarySearchTest {

    @Test
    public void testSearchTargetFound() {
        String[] array = {"apple", "banana", "cherry", "date", "elderberry"};
        int result = BinarySearch.searchTarget(array, "cherry", 0, array.length - 1);
        assertEquals("Expected 'cherry' to be found at index 2", 2, result);
    }

    @Test
    public void testSearchTargetNotFound() {
        String[] array = {"apple", "banana", "cherry", "date", "elderberry"};
        int result = BinarySearch.searchTarget(array, "fig", 0, array.length - 1);
        assertEquals("Expected 'fig' to not be found, returning -1", -1, result);
    }

    @Test
    public void testFindAllOccurrencesTargetPresent() {
        String[] array = {"apple", "banana", "cherry", "cherry", "elderberry"};
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);

        List<Integer> actual = BinarySearch.findAllOccurrences(array, "cherry", 0, array.length - 1, new ArrayList<>());
        assertEquals("Expected all indices of 'cherry' to be [2, 3]", expected, actual);
    }

    @Test
    public void testFindAllOccurrencesTargetAbsent() {
        String[] array = {"apple", "banana", "cherry", "date", "elderberry"};
        List<Integer> actual = BinarySearch.findAllOccurrences(array, "fig", 0, array.length - 1, new ArrayList<>());
        assertTrue("Expected no occurrences of 'fig' in the array", actual.isEmpty());
    }
}
