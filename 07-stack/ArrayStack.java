import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Topic 07 - Stack
 *
 * A stack is Last In, First Out (LIFO), like a stack of plates.
 *   push(x) puts x on top. pop() removes the top. peek() looks at the top.
 * All three should be O(1).
 *
 * You're building it on top of an array. "size" is both the number of items and the
 * index where the next push goes:
 *
 *   push 1, push 2, push 3  ->  data = [1, 2, 3, _]   size = 3   (top is data[size - 1])
 *
 * When the array is full, make a bigger one (double it) and copy everything over.
 * Arrays.copyOf(data, newLength) does the copy for you.
 *
 * Run:  java 07-stack/ArrayStack.java
 */
public class ArrayStack {

    private int[] data = new int[4];
    private int size;

    public int size() {
        return size;
    }

    /** Push value on top. If the array is full, grow it first. */
    public void push(int value) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove and return the top value.
     * If the stack is empty: throw new IllegalStateException("stack is empty");
     */
    public int pop() {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the top value without removing it.
     * If the stack is empty: throw new IllegalStateException("stack is empty");
     */
    public int peek() {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /** Return true if there's nothing on the stack. */
    public boolean isEmpty() {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Stack problem: return true if every bracket in s is closed by the matching
     * bracket, in the right order. Brackets are ( ) [ ] { }. Ignore any other characters.
     *   isBalanced("([]{})") -> true
     *   isBalanced("(]")     -> false
     *   isBalanced("((")     -> false
     * Hint: push openers. On a closer, the top of the stack must be its matching opener.
     * You can use your own ArrayStack here (a char is just an int), or java.util.ArrayDeque.
     */
    public static boolean isBalanced(String s) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    // ---------------------------------------------------------------------
    // Self-check: run this file to see which exercises pass. No need to edit below.
    // ---------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("Topic 07 - Stack\n");

        check("push 1, 2, 3 then pop", () -> {
            ArrayStack s = new ArrayStack();
            s.push(1);
            s.push(2);
            s.push(3);
            return s.pop();
        }, 3);
        check("push 1..5 then pop all (LIFO order)", () -> {
            ArrayStack s = new ArrayStack();
            for (int i = 1; i <= 5; i++) s.push(i);
            int[] out = new int[5];
            for (int i = 0; i < 5; i++) out[i] = s.pop();
            return out;
        }, new int[]{5, 4, 3, 2, 1});
        check("push 1, 2 then peek (size stays 2)", () -> {
            ArrayStack s = new ArrayStack();
            s.push(1);
            s.push(2);
            return s.peek() + " size " + s.size();
        }, "2 size 2");
        check("new stack isEmpty()", () -> new ArrayStack().isEmpty(), true);
        check("push 1 then isEmpty()", () -> {
            ArrayStack s = new ArrayStack();
            s.push(1);
            return s.isEmpty();
        }, false);
        check("push 1, pop, then isEmpty()", () -> {
            ArrayStack s = new ArrayStack();
            s.push(1);
            s.pop();
            return s.isEmpty();
        }, true);
        check("push 1..100 (needs to grow) then pop", () -> {
            ArrayStack s = new ArrayStack();
            for (int i = 1; i <= 100; i++) s.push(i);
            return s.pop() + " size " + s.size();
        }, "100 size 99");
        checkThrows("pop() on empty stack", () -> new ArrayStack().pop(), IllegalStateException.class);
        checkThrows("peek() on empty stack", () -> new ArrayStack().peek(), IllegalStateException.class);

        check("isBalanced(\"()[]{}\")", () -> isBalanced("()[]{}"), true);
        check("isBalanced(\"([{}])\")", () -> isBalanced("([{}])"), true);
        check("isBalanced(\"a(b)c\")", () -> isBalanced("a(b)c"), true);
        check("isBalanced(\"\")", () -> isBalanced(""), true);
        check("isBalanced(\"(]\")", () -> isBalanced("(]"), false);
        check("isBalanced(\"([)]\")", () -> isBalanced("([)]"), false);
        check("isBalanced(\"((\")", () -> isBalanced("(("), false);
        check("isBalanced(\")(\")", () -> isBalanced(")("), false);

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

    private static void checkThrows(String name, Runnable action, Class<? extends Exception> expected) {
        try {
            action.run();
            failed++;
            System.out.println("  FAIL  " + name + "  expected " + expected.getSimpleName() + ", but nothing was thrown");
        } catch (UnsupportedOperationException e) {
            todo++;
            System.out.println("  TODO  " + name);
        } catch (Exception e) {
            if (expected.isInstance(e)) {
                passed++;
                System.out.println("  PASS  " + name + " throws " + expected.getSimpleName());
            } else {
                failed++;
                System.out.println("  FAIL  " + name + "  expected " + expected.getSimpleName() + ", got " + e);
            }
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
