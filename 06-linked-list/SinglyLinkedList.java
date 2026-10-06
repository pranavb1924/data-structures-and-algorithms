import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Topic 06 - Linked List
 *
 * A linked list is a chain of nodes. Each node holds a value and a pointer to the next node.
 *
 *   head -> [1] -> [2] -> [3] -> null
 *
 * Compared to an array:
 *   - Adding/removing at the front is O(1), with no shifting.
 *   - Getting the element at index i is O(n): you have to walk from head.
 *
 * You're building the list yourself. Node, head, size, size() and toString() are done.
 * Read toString() first: it shows the standard way to walk a list. Then implement
 * addFirst and addLast, because the other checks use them to build test lists.
 *
 * Remember to keep "size" correct whenever you add or remove a node.
 *
 * Run:  java 06-linked-list/SinglyLinkedList.java
 */
public class SinglyLinkedList {

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    public int size() {
        return size;
    }

    /** Prints like [1, 2, 3]. This is the standard "walk the list" loop. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    /** Add value at the front. Should be O(1). */
    public void addFirst(int value) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /** Add value at the end. Walk to the last node and link the new one after it. */
    public void addLast(int value) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove the first node and return its value.
     * If the list is empty: throw new IllegalStateException("list is empty");
     */
    public int removeFirst() {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Return the value at the given index (0 = head).
     * If index is out of range: throw new IndexOutOfBoundsException("index " + index);
     */
    public int get(int index) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /** Return true if any node holds value. */
    public boolean contains(int value) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove the first node holding value. Return true if one was removed, false otherwise.
     * Hint: you need a pointer to the node BEFORE the one you remove. Removing the head
     * is a special case.
     */
    public boolean removeValue(int value) {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Reverse the list in place by re-pointing the "next" links. Don't create new nodes.
     *   [1, 2, 3] becomes [3, 2, 1]
     * Hint: three pointers: previous, current, next. Draw it on paper first.
     */
    public void reverse() {
        // TODO: your code here
        throw new UnsupportedOperationException("TODO");
    }

    // ---------------------------------------------------------------------
    // Self-check: run this file to see which exercises pass. No need to edit below.
    // ---------------------------------------------------------------------

    private static SinglyLinkedList of(int... values) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int v : values) {
            list.addLast(v);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("Topic 06 - Linked List\n");

        check("addFirst 3, 2, 1", () -> {
            SinglyLinkedList list = new SinglyLinkedList();
            list.addFirst(3);
            list.addFirst(2);
            list.addFirst(1);
            return list.toString() + " size " + list.size();
        }, "[1, 2, 3] size 3");
        check("addLast 1, 2, 3", () -> {
            SinglyLinkedList list = new SinglyLinkedList();
            list.addLast(1);
            list.addLast(2);
            list.addLast(3);
            return list.toString() + " size " + list.size();
        }, "[1, 2, 3] size 3");
        check("addLast 2, addFirst 1, addLast 3", () -> {
            SinglyLinkedList list = new SinglyLinkedList();
            list.addLast(2);
            list.addFirst(1);
            list.addLast(3);
            return list.toString();
        }, "[1, 2, 3]");

        check("[1, 2, 3].removeFirst() returns", () -> of(1, 2, 3).removeFirst(), 1);
        check("[1, 2, 3].removeFirst() leaves", () -> {
            SinglyLinkedList list = of(1, 2, 3);
            list.removeFirst();
            return list.toString() + " size " + list.size();
        }, "[2, 3] size 2");
        checkThrows("[].removeFirst()", () -> new SinglyLinkedList().removeFirst(), IllegalStateException.class);

        check("[10, 20, 30].get(0)", () -> of(10, 20, 30).get(0), 10);
        check("[10, 20, 30].get(2)", () -> of(10, 20, 30).get(2), 30);
        checkThrows("[10, 20, 30].get(3)", () -> of(10, 20, 30).get(3), IndexOutOfBoundsException.class);
        checkThrows("[10, 20, 30].get(-1)", () -> of(10, 20, 30).get(-1), IndexOutOfBoundsException.class);

        check("[1, 2, 3].contains(2)", () -> of(1, 2, 3).contains(2), true);
        check("[1, 2, 3].contains(5)", () -> of(1, 2, 3).contains(5), false);
        check("[].contains(1)", () -> new SinglyLinkedList().contains(1), false);

        check("[1, 2, 3, 2].removeValue(2)", () -> {
            SinglyLinkedList list = of(1, 2, 3, 2);
            boolean removed = list.removeValue(2);
            return removed + " " + list + " size " + list.size();
        }, "true [1, 3, 2] size 3");
        check("[1, 2].removeValue(1)", () -> {
            SinglyLinkedList list = of(1, 2);
            boolean removed = list.removeValue(1);
            return removed + " " + list;
        }, "true [2]");
        check("[1, 2].removeValue(9)", () -> {
            SinglyLinkedList list = of(1, 2);
            boolean removed = list.removeValue(9);
            return removed + " " + list;
        }, "false [1, 2]");
        check("[].removeValue(1)", () -> new SinglyLinkedList().removeValue(1), false);

        check("[1, 2, 3, 4].reverse()", () -> {
            SinglyLinkedList list = of(1, 2, 3, 4);
            list.reverse();
            return list.toString();
        }, "[4, 3, 2, 1]");
        check("[7].reverse()", () -> {
            SinglyLinkedList list = of(7);
            list.reverse();
            return list.toString();
        }, "[7]");
        check("[].reverse()", () -> {
            SinglyLinkedList list = new SinglyLinkedList();
            list.reverse();
            return list.toString();
        }, "[]");

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
