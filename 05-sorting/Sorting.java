import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Topic 05 - Sorting
 *
 * The three classic O(n^2) sorts. Each sorts the array in place (smallest first).
 * Don't call Arrays.sort here. The point is to write the sort yourself.
 *
 *   Bubble sort:    sweep left to right, swapping neighbours that are out of order.
 *                   After each sweep the largest remaining value has "bubbled" to the end.
 *   Selection sort: find the smallest value in the unsorted part, swap it to the front
 *                   of the unsorted part. Repeat.
 *   Insertion sort: grow a sorted section on the left. Take the next value and slide it
 *                   left until it's in the right spot (like sorting cards in your hand).
 *
 * Try tracing each one by hand on [5, 2, 9, 1] before you code it.
 *
 * Run:  java 05-sorting/Sorting.java
 */
public class Sorting {

    /** Sort nums in place using bubble sort. */
    public static void bubbleSort(int[] nums) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /** Sort nums in place using selection sort. */
    public static void selectionSort(int[] nums) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /** Sort nums in place using insertion sort. */
    public static void insertionSort(int[] nums) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Given two sorted arrays, return a NEW sorted array containing all their elements.
     *   mergeSortedArrays([1, 4, 7], [2, 3, 8, 9]) -> [1, 2, 3, 4, 7, 8, 9]
     * Hint: one index into each array; always take the smaller front element.
     * This is the heart of merge sort, which you'll build on later.
     */
    public static int[] mergeSortedArrays(int[] a, int[] b) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    // ---------------------------------------------------------------------
    // Self-check: run this file to see which exercises pass. No need to edit below.
    // ---------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("Topic 05 - Sorting\n");

        Map<String, Consumer<int[]>> sorts = new LinkedHashMap<>();
        sorts.put("bubbleSort", Sorting::bubbleSort);
        sorts.put("selectionSort", Sorting::selectionSort);
        sorts.put("insertionSort", Sorting::insertionSort);

        int[][] inputs = {{5, 2, 9, 1, 5, 6}, {3, 2, 1}, {1, 2, 3}, {-3, 10, 0, -3}, {7}, {}};

        for (Map.Entry<String, Consumer<int[]>> sort : sorts.entrySet()) {
            for (int[] input : inputs) {
                int[] expected = input.clone();
                Arrays.sort(expected);
                check(sort.getKey() + "(" + Arrays.toString(input) + ")",
                        () -> { int[] a = input.clone(); sort.getValue().accept(a); return a; },
                        expected);
            }
        }

        check("mergeSortedArrays([1, 4, 7], [2, 3, 8, 9])",
                () -> mergeSortedArrays(new int[]{1, 4, 7}, new int[]{2, 3, 8, 9}), new int[]{1, 2, 3, 4, 7, 8, 9});
        check("mergeSortedArrays([1, 2], [1, 2])",
                () -> mergeSortedArrays(new int[]{1, 2}, new int[]{1, 2}), new int[]{1, 1, 2, 2});
        check("mergeSortedArrays([], [1, 2])",
                () -> mergeSortedArrays(new int[]{}, new int[]{1, 2}), new int[]{1, 2});
        check("mergeSortedArrays([5], [])",
                () -> mergeSortedArrays(new int[]{5}, new int[]{}), new int[]{5});

        summary();
    }

    private static int passed, failed, todo;

    private static void check(String name, Supplier<Object> actual, Object expected) {
        try {
            Object got = actual.get();
            if (Objects.deepEquals(got, expected)) {
                passed++;
                System.out.println("  PASS  " + name);
            } else {
                failed++;
                System.out.println("  FAIL  " + name + "  expected " + show(expected) + ", got " + show(got));
            }
        } catch (UnsupportedOperationException e) {
            todo++;
            System.out.println("  TODO  " + name);
        } catch (Exception | StackOverflowError e) {
            failed++;
            System.out.println("  FAIL  " + name + "  threw " + e);
        }
    }

    private static String show(Object o) {
        if (o instanceof int[] a) return Arrays.toString(a);
        if (o instanceof String s) return "\"" + s + "\"";
        return String.valueOf(o);
    }

    private static void summary() {
        System.out.printf("%n%d passed, %d failed, %d todo%n", passed, failed, todo);
    }
}
