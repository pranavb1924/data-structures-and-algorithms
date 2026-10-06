import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Topic 09 - Hash Maps and Hash Sets
 *
 * A HashMap stores key -> value pairs. A HashSet stores unique values.
 * Looking up, adding and removing are all O(1) on average. That's the superpower:
 * many O(n^2) "compare every pair" problems become O(n) with a map or set.
 *
 * Here you USE Java's built-in versions (how they work inside is a later topic).
 *   Map<Integer, Integer> counts = new HashMap<>();
 *   counts.put(key, counts.getOrDefault(key, 0) + 1);   // count something
 *   counts.containsKey(key);   counts.get(key);
 *
 *   Set<Integer> seen = new HashSet<>();
 *   seen.add(x);   seen.contains(x);
 *
 * Run:  java 09-hash-maps/HashMapBasics.java
 */
public class HashMapBasics {

    /**
     * Return a map from each number to how many times it appears.
     *   countFrequencies([1, 2, 2, 3, 3, 3]) -> {1=1, 2=2, 3=3}
     */
    public static Map<Integer, Integer> countFrequencies(int[] nums) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return true if any number appears more than once. Aim for O(n).
     *   hasDuplicate([1, 2, 3, 1]) -> true
     *   hasDuplicate([1, 2, 3])    -> false
     */
    public static boolean hasDuplicate(int[] nums) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the value that appears most often. Assume there's exactly one such value.
     *   mostFrequent([1, 3, 3, 2, 3, 1]) -> 3
     */
    public static int mostFrequent(int[] nums) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the set of values that appear in both arrays.
     *   commonElements([1, 2, 2, 3], [2, 3, 4]) -> {2, 3}
     */
    public static Set<Integer> commonElements(int[] a, int[] b) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the indexes [i, j] (i < j) of the two numbers that add up to target,
     * or an empty array if no pair does. Use each element at most once.
     *   twoSum([2, 7, 11, 15], 9) -> [0, 1]
     *   twoSum([3, 2, 4], 6)      -> [1, 2]
     * The O(n^2) way checks every pair. Can you do it in one pass with a map?
     * Hint: for each number, the partner you need is (target - number). Have you seen it?
     */
    public static int[] twoSum(int[] nums, int target) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    // ---------------------------------------------------------------------
    // Self-check: run this file to see which exercises pass. No need to edit below.
    // ---------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("Topic 09 - Hash Maps and Hash Sets\n");

        check("countFrequencies([1, 2, 2, 3, 3, 3])", () -> countFrequencies(new int[]{1, 2, 2, 3, 3, 3}), Map.of(1, 1, 2, 2, 3, 3));
        check("countFrequencies([4])", () -> countFrequencies(new int[]{4}), Map.of(4, 1));
        check("countFrequencies([])", () -> countFrequencies(new int[]{}), Map.of());

        check("hasDuplicate([1, 2, 3, 1])", () -> hasDuplicate(new int[]{1, 2, 3, 1}), true);
        check("hasDuplicate([1, 2, 3])", () -> hasDuplicate(new int[]{1, 2, 3}), false);
        check("hasDuplicate([])", () -> hasDuplicate(new int[]{}), false);

        check("mostFrequent([1, 3, 3, 2, 3, 1])", () -> mostFrequent(new int[]{1, 3, 3, 2, 3, 1}), 3);
        check("mostFrequent([7])", () -> mostFrequent(new int[]{7}), 7);
        check("mostFrequent([-1, -1, 2])", () -> mostFrequent(new int[]{-1, -1, 2}), -1);

        check("commonElements([1, 2, 2, 3], [2, 3, 4])", () -> commonElements(new int[]{1, 2, 2, 3}, new int[]{2, 3, 4}), Set.of(2, 3));
        check("commonElements([1], [2])", () -> commonElements(new int[]{1}, new int[]{2}), Set.of());

        check("twoSum([2, 7, 11, 15], 9)", () -> twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        check("twoSum([3, 2, 4], 6)", () -> twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        check("twoSum([3, 3], 6)", () -> twoSum(new int[]{3, 3}, 6), new int[]{0, 1});
        check("twoSum([1, 2], 7)", () -> twoSum(new int[]{1, 2}, 7), new int[]{});

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
