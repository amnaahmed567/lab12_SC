package expressivo;

import java.util.List;

public class BinarySearch {

    // Recursive Binary Search to find the index of the target element
    public static int searchTarget(String[] array, String target, int left, int right) {
        if (left > right) {
            return -1; // Base case: target not found
        }
        
        int mid = left + (right - left) / 2;
        
        if (array[mid].equals(target)) {
            return mid; // Target found
        } else if (array[mid].compareTo(target) > 0) {
            return searchTarget(array, target, left, mid - 1); // Search left half
        } else {
            return searchTarget(array, target, mid + 1, right); // Search right half
        }
    }

    // Recursive Binary Search to find all indices of the target element
    public static List<Integer> findAllOccurrences(String[] array, String target, int left, int right, List<Integer> indices) {
        if (left > right) {
            return indices; // Base case: no more elements to search
        }

        int mid = left + (right - left) / 2;

        if (array[mid].equals(target)) {
            indices.add(mid); // Found the target, add to indices list
            // Search left and right of the mid to find all occurrences
            findAllOccurrences(array, target, left, mid - 1, indices);
            findAllOccurrences(array, target, mid + 1, right, indices);
        } else if (array[mid].compareTo(target) > 0) {
            return findAllOccurrences(array, target, left, mid - 1, indices); // Search left half
        } else {
            return findAllOccurrences(array, target, mid + 1, right, indices); // Search right half
        }

        return indices;
    }
}
