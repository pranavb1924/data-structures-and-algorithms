import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Topic 08 - Queue
 *
 * A queue is First In, First Out (FIFO), like a line at a coffee shop.
 *   enqueue(x) joins the back. dequeue() leaves from the front. peek() looks at the front.
 * All three should be O(1).
 *
 * You're building it from linked nodes, keeping pointers to BOTH ends:
 *
 *   head -> [1] -> [2] -> [3] <- tail
 *   dequeue here           enqueue here
 *
 * The tail pointer is what makes enqueue O(1). Compare with addLast in Topic 06, which
 * had to walk the whole list.
 *
 * Watch the edge cases: enqueue into an empty queue, and dequeue the last item
 * (both head AND tail must become null).
 *
 * Run:  java 08-queue/LinkedQueue.java
 */
public class LinkedQueue {

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    /** Add value at the back. */
    public void enqueue(int value) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove and return the front value.
     * If the queue is empty: throw new IllegalStateException("queue is empty");
     */
    public int dequeue() {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the front value without removing it.
     * If the queue is empty: throw new IllegalStateException("queue is empty");
     */
    public int peek() {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /** Return true if the queue has no items. */
    public boolean isEmpty() {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    // ---------------------------------------------------------------------
    // Self-check: run this file to see which exercises pass. No need to edit below.
    // ---------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("Topic 08 - Queue\n");

        check("enqueue 1, 2, 3 then dequeue", () -> {
            LinkedQueue q = new LinkedQueue();
            q.enqueue(1);
            q.enqueue(2);
            q.enqueue(3);
            return q.dequeue();
        }, 1);
        check("enqueue 1..5 then dequeue all (FIFO order)", () -> {
            LinkedQueue q = new LinkedQueue();
            for (int i = 1; i <= 5; i++) q.enqueue(i);
            int[] out = new int[5];
            for (int i = 0; i < 5; i++) out[i] = q.dequeue();
            return out;
        }, new int[]{1, 2, 3, 4, 5});
        check("enqueue 1, 2 then peek (size stays 2)", () -> {
            LinkedQueue q = new LinkedQueue();
            q.enqueue(1);
            q.enqueue(2);
            return q.peek() + " size " + q.size();
        }, "1 size 2");
        check("new queue isEmpty()", () -> new LinkedQueue().isEmpty(), true);
        check("enqueue 1 then isEmpty()", () -> {
            LinkedQueue q = new LinkedQueue();
            q.enqueue(1);
            return q.isEmpty();
        }, false);
        check("enqueue 1, dequeue, then isEmpty()", () -> {
            LinkedQueue q = new LinkedQueue();
            q.enqueue(1);
            q.dequeue();
            return q.isEmpty();
        }, true);
        check("empty it out, then use it again", () -> {
            LinkedQueue q = new LinkedQueue();
            q.enqueue(1);
            q.dequeue();
            q.enqueue(2);
            q.enqueue(3);
            return q.dequeue() + " then " + q.dequeue();
        }, "2 then 3");
        checkThrows("dequeue() on empty queue", () -> new LinkedQueue().dequeue(), IllegalStateException.class);
        checkThrows("peek() on empty queue", () -> new LinkedQueue().peek(), IllegalStateException.class);

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
