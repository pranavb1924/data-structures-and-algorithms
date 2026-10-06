import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Topic 04 - Searching
 *
 * Linear search checks every element: O(n). You already wrote one (indexOf in Topic 01).
 *
 * Binary search works only on a SORTED array, and it's O(log n):
 *   - Look at the middle element.
 *   - If it's the target, done. If the target is bigger, throw away the left half;
 *     if smaller, throw away the right half.
 *   - Repeat on what's left. A million elements takes about 20 steps.
 *
 * Classic bug: (lo + hi) / 2 can overflow for huge arrays. Use lo + (hi - lo) / 2.
 *
 * Every exercise here should be O(log n). A linear scan will pass the checks,
 * but it misses the point.
 *
 * Run:  java 04-searching/Searching.java
 */
public class Searching {

    /**
     * Return the index of target in a sorted array, or -1. Use a loop.
     *   binarySearch([1, 3, 5, 7, 9, 11], 7) -> 3
     *   binarySearch([1, 3, 5, 7, 9, 11], 4) -> -1
     */
    public static int binarySearch(int[] sorted, int target) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Same as binarySearch, but recursive. Search only between indexes lo and hi (inclusive).
     *   binarySearchRecursive([1, 3, 5, 7, 9, 11], 7, 0, 5) -> 3
     */
    public static int binarySearchRecursive(int[] sorted, int target, int lo, int hi) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * The sorted array may contain duplicates. Return the index of the FIRST occurrence, or -1.
     *   firstOccurrence([1, 2, 2, 2, 3], 2) -> 1
     * Hint: when you find the target, remember it, but keep searching to the left.
     */
    public static int firstOccurrence(int[] sorted, int target) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the index of target if present; otherwise the index where it would be
     * inserted to keep the array sorted.
     *   searchInsert([1, 3, 5, 6], 5) -> 2
     *   searchInsert([1, 3, 5, 6], 2) -> 1
     *   searchInsert([1, 3, 5, 6], 7) -> 4
     */
    public static int searchInsert(int[] sorted, int target) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the square root of x (x >= 0), rounded down. Don't use Math.sqrt.
     *   floorSqrt(16) -> 4
     *   floorSqrt(17) -> 4
     * Binary search over the possible ANSWERS 0..x, not over an array.
     * Watch out: mid * mid can overflow an int. Use long.
     */
    public static int floorSqrt(int x) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    // ---------------------------------------------------------------------
    // Self-check: run this file to see which exercises pass. No need to edit below.
    // ---------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("Topic 04 - Searching\n");

        int[] odds = {1, 3, 5, 7, 9, 11};

        check("binarySearch([1, 3, 5, 7, 9, 11], 7)", () -> binarySearch(odds, 7), 3);
        check("binarySearch([1, 3, 5, 7, 9, 11], 1)", () -> binarySearch(odds, 1), 0);
        check("binarySearch([1, 3, 5, 7, 9, 11], 11)", () -> binarySearch(odds, 11), 5);
        check("binarySearch([1, 3, 5, 7, 9, 11], 4)", () -> binarySearch(odds, 4), -1);
        check("binarySearch([], 3)", () -> binarySearch(new int[]{}, 3), -1);

        check("binarySearchRecursive([1, 3, 5, 7, 9, 11], 7, 0, 5)", () -> binarySearchRecursive(odds, 7, 0, 5), 3);
        check("binarySearchRecursive([1, 3, 5, 7, 9, 11], 11, 0, 5)", () -> binarySearchRecursive(odds, 11, 0, 5), 5);
        check("binarySearchRecursive([1, 3, 5, 7, 9, 11], 4, 0, 5)", () -> binarySearchRecursive(odds, 4, 0, 5), -1);

        check("firstOccurrence([1, 2, 2, 2, 3], 2)", () -> firstOccurrence(new int[]{1, 2, 2, 2, 3}, 2), 1);
        check("firstOccurrence([5, 5, 5], 5)", () -> firstOccurrence(new int[]{5, 5, 5}, 5), 0);
        check("firstOccurrence([1, 2, 2, 2, 3], 4)", () -> firstOccurrence(new int[]{1, 2, 2, 2, 3}, 4), -1);

        check("searchInsert([1, 3, 5, 6], 5)", () -> searchInsert(new int[]{1, 3, 5, 6}, 5), 2);
        check("searchInsert([1, 3, 5, 6], 2)", () -> searchInsert(new int[]{1, 3, 5, 6}, 2), 1);
        check("searchInsert([1, 3, 5, 6], 7)", () -> searchInsert(new int[]{1, 3, 5, 6}, 7), 4);
        check("searchInsert([1, 3, 5, 6], 0)", () -> searchInsert(new int[]{1, 3, 5, 6}, 0), 0);

        check("floorSqrt(16)", () -> floorSqrt(16), 4);
        check("floorSqrt(17)", () -> floorSqrt(17), 4);
        check("floorSqrt(0)", () -> floorSqrt(0), 0);
        check("floorSqrt(1)", () -> floorSqrt(1), 1);
        check("floorSqrt(2147395599)", () -> floorSqrt(2147395599), 46339);

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
