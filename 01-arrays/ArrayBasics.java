import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Topic 01 - Arrays
 *
 * An array is a fixed-size row of slots that all hold the same type.
 *   - nums[i] reads or writes one slot in O(1) time.
 *   - Valid indexes are 0 to nums.length - 1.
 *   - Visiting every element with a loop is O(n).
 *
 * How to practice:
 *   1. Pick an exercise and replace its "throw" line with your code.
 *   2. Run:  java 01-arrays/ArrayBasics.java
 *   3. Keep going until every line says PASS.
 */
public class ArrayBasics {

    /**
     * Return the sum of every number.
     *   sum([1, 2, 3]) -> 6
     *   sum([])        -> 0
     */
    public static int sum(int[] nums) {
        // TODO: your code here
        int total = 0;
        for (int n: nums){
            total += n;
        }
        return total;
    }

    /**
     * Return the largest number. Assume nums is not empty.
     *   max([3, 7, 2])    -> 7
     *   max([-5, -2, -9]) -> -2
     * Hint: what should you start "best so far" at? (0 is wrong - why?)
     */
    public static int max(int[] nums) {
        // TODO: your code here
        int maxNum = Integer.MIN_VALUE;
        for (int n : nums){
            maxNum = Math.max(maxNum, n);
        }

        return maxNum;
    }

    /**
     * Return the index of the first occurrence of target, or -1 if it isn't there.
     *   indexOf([4, 8, 15], 8)  -> 1
     *   indexOf([4, 8, 15], 99) -> -1
     */
    public static int indexOf(int[] nums, int target) {
        // TODO: your code here
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                return i;
            }
        }

        return -1;
    }

    /**
     * Count how many numbers are even.
     *   countEvens([1, 2, 4, 5]) -> 2
     *   countEvens([-2, 0, 3])   -> 2
     */
    public static int countEvens(int[] nums) {
        // TODO: your code here
        int count = 0;
        for(int n : nums){
            if (n % 2 == 0){
                count++;
            }
        }
        return count;
    }

    /**
     * Return true if every number is >= the one before it.
     *   isSorted([1, 2, 2, 5]) -> true
     *   isSorted([1, 3, 2])    -> false
     *   isSorted([])           -> true
     */
    public static boolean isSorted(int[] nums) {
        // TODO: your code here
        boolean sorted = true;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i-1]){
                sorted = false;
                break;  
            }
        }
        return sorted;
    }

    /**
     * Reverse the array in place: change nums itself, don't make a new array.
     *   [1, 2, 3] becomes [3, 2, 1]
     * Hint: one index at each end. Swap, then move both toward the middle.
     */
    public static void reverseInPlace(int[] nums) {
        // TODO: your code here
        int[] reversed = new int[nums.length];

        for (int i = 0, j = reversed.length - 1; i < nums.length && j >= 0; i++, j--){
            reversed[j] = nums[i];
        }

        for (int i = 0; i < nums.length; i++){
            nums[i] = reversed[i];
        }
    }

    /**
     * Return the second-largest distinct value. Assume there are at least two distinct values.
     *   secondLargest([5, 1, 5, 3]) -> 3
     *   secondLargest([2, 9])       -> 2
     * Challenge: do it in a single pass, without sorting.
     */
    public static int secondLargest(int[] nums) {
        // TODO: your code here
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int n : nums){
           if (n > largest){
            secondLargest = largest;
            largest = n;
           }

           if (n >secondLargest && n < largest){
            secondLargest = n;
           }
        }
        return secondLargest;
    }

    /**
     * Move every 0 to the end, in place, keeping the other numbers in their original order.
     *   [0, 1, 0, 3, 12] becomes [1, 3, 12, 0, 0]
     * Hint: keep a "write" index for where the next non-zero number goes.
     */
    public static void moveZerosToEnd(int[] nums) {
        // TODO: your code here
        int[] temp = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                count++;
                continue;
            }
            temp[i - count] = nums[i];
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }

    // ---------------------------------------------------------------------
    // Self-check: run this file to see which exercises pass. No need to edit below.
    // ---------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("Topic 01 - Arrays\n");

        check("sum([1, 2, 3])", () -> sum(new int[]{1, 2, 3}), 6);
        check("sum([])", () -> sum(new int[]{}), 0);
        check("sum([-4, 4, 10])", () -> sum(new int[]{-4, 4, 10}), 10);

        check("max([3, 7, 2])", () -> max(new int[]{3, 7, 2}), 7);
        check("max([-5, -2, -9])", () -> max(new int[]{-5, -2, -9}), -2);
        check("max([42])", () -> max(new int[]{42}), 42);

        check("indexOf([4, 8, 15], 8)", () -> indexOf(new int[]{4, 8, 15}, 8), 1);
        check("indexOf([4, 8, 15], 99)", () -> indexOf(new int[]{4, 8, 15}, 99), -1);
        check("indexOf([7, 7, 7], 7)", () -> indexOf(new int[]{7, 7, 7}, 7), 0);

        check("countEvens([1, 2, 4, 5])", () -> countEvens(new int[]{1, 2, 4, 5}), 2);
        check("countEvens([])", () -> countEvens(new int[]{}), 0);
        check("countEvens([-2, 0, 3])", () -> countEvens(new int[]{-2, 0, 3}), 2);

        check("isSorted([1, 2, 2, 5])", () -> isSorted(new int[]{1, 2, 2, 5}), true);
        check("isSorted([1, 3, 2])", () -> isSorted(new int[]{1, 3, 2}), false);
        check("isSorted([])", () -> isSorted(new int[]{}), true);

        check("reverseInPlace([1, 2, 3])", () -> { int[] a = {1, 2, 3}; reverseInPlace(a); return a; }, new int[]{3, 2, 1});
        check("reverseInPlace([1, 2, 3, 4])", () -> { int[] a = {1, 2, 3, 4}; reverseInPlace(a); return a; }, new int[]{4, 3, 2, 1});
        check("reverseInPlace([])", () -> { int[] a = {}; reverseInPlace(a); return a; }, new int[]{});

        check("secondLargest([5, 1, 5, 3])", () -> secondLargest(new int[]{5, 1, 5, 3}), 3);
        check("secondLargest([2, 9])", () -> secondLargest(new int[]{2, 9}), 2);
        check("secondLargest([-1, -7, -3])", () -> secondLargest(new int[]{-1, -7, -3}), -3);

        check("moveZerosToEnd([0, 1, 0, 3, 12])", () -> { int[] a = {0, 1, 0, 3, 12}; moveZerosToEnd(a); return a; }, new int[]{1, 3, 12, 0, 0});
        check("moveZerosToEnd([0, 0, 1])", () -> { int[] a = {0, 0, 1}; moveZerosToEnd(a); return a; }, new int[]{1, 0, 0});
        check("moveZerosToEnd([1, 2])", () -> { int[] a = {1, 2}; moveZerosToEnd(a); return a; }, new int[]{1, 2});

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
