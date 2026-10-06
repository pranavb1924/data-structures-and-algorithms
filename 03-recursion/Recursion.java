import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Topic 03 - Recursion
 *
 * A recursive method calls itself on a smaller version of the same problem.
 * Every recursive method needs two parts:
 *   1. A base case: the smallest input, answered directly with no recursive call.
 *   2. A recursive step: call yourself on a smaller input that moves toward the base case.
 * Forget the base case and you get a StackOverflowError.
 *
 * Rule for this file: no loops. Every solution should be recursive.
 *
 * Run:  java 03-recursion/Recursion.java
 */
public class Recursion {

    /**
     * Return n! = n * (n-1) * ... * 1, with 0! = 1.
     *   factorial(5) -> 120
     */
    public static long factorial(int n) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the nth Fibonacci number: fib(0) = 0, fib(1) = 1, fib(n) = fib(n-1) + fib(n-2).
     *   fibonacci(10) -> 55
     * Think about it: how many calls does fibonacci(30) make? (You'll fix this later with memoization.)
     */
    public static int fibonacci(int n) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the sum of the digits of a non-negative number.
     *   sumDigits(1234) -> 10
     * Hint: n % 10 is the last digit; n / 10 drops it.
     */
    public static int sumDigits(int n) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return base raised to exp (exp >= 0).
     *   power(2, 10) -> 1024
     *   power(5, 0)  -> 1
     */
    public static long power(int base, int exp) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the sum of nums[start], nums[start + 1], ..., up to the end of the array.
     *   sumArray([1, 2, 3, 4], 0) -> 10
     *   sumArray([1, 2, 3, 4], 2) -> 7
     * The "start" parameter is how the problem gets smaller each call.
     */
    public static int sumArray(int[] nums, int start) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the binary (base 2) form of a non-negative number as a String.
     *   toBinary(5) -> "101"
     *   toBinary(0) -> "0"
     * Hint: the last binary digit is n % 2; the rest is the binary of n / 2.
     */
    public static String toBinary(int n) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the greatest common divisor of a and b (both >= 0, not both 0).
     *   gcd(48, 18) -> 6
     * Euclid's trick: gcd(a, b) == gcd(b, a % b), and gcd(a, 0) == a.
     */
    public static int gcd(int a, int b) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    // ---------------------------------------------------------------------
    // Self-check: run this file to see which exercises pass. No need to edit below.
    // ---------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("Topic 03 - Recursion\n");

        check("factorial(0)", () -> factorial(0), 1L);
        check("factorial(5)", () -> factorial(5), 120L);
        check("factorial(20)", () -> factorial(20), 2432902008176640000L);

        check("fibonacci(0)", () -> fibonacci(0), 0);
        check("fibonacci(1)", () -> fibonacci(1), 1);
        check("fibonacci(10)", () -> fibonacci(10), 55);

        check("sumDigits(1234)", () -> sumDigits(1234), 10);
        check("sumDigits(7)", () -> sumDigits(7), 7);
        check("sumDigits(0)", () -> sumDigits(0), 0);

        check("power(2, 10)", () -> power(2, 10), 1024L);
        check("power(3, 4)", () -> power(3, 4), 81L);
        check("power(5, 0)", () -> power(5, 0), 1L);

        check("sumArray([1, 2, 3, 4], 0)", () -> sumArray(new int[]{1, 2, 3, 4}, 0), 10);
        check("sumArray([1, 2, 3, 4], 2)", () -> sumArray(new int[]{1, 2, 3, 4}, 2), 7);
        check("sumArray([], 0)", () -> sumArray(new int[]{}, 0), 0);

        check("toBinary(5)", () -> toBinary(5), "101");
        check("toBinary(8)", () -> toBinary(8), "1000");
        check("toBinary(1)", () -> toBinary(1), "1");
        check("toBinary(0)", () -> toBinary(0), "0");

        check("gcd(48, 18)", () -> gcd(48, 18), 6);
        check("gcd(7, 13)", () -> gcd(7, 13), 1);
        check("gcd(10, 0)", () -> gcd(10, 0), 10);

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
