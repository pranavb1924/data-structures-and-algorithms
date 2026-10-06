# Data Structures and Algorithms (Java)

Practice for the fundamentals, written from scratch in plain Java. There's no build tool or framework: each topic is one file you can run directly.

## How it works

Every topic file contains exercises written as method stubs. Each stub has a problem description, examples, and sometimes a hint:

```java
public static int sum(int[] nums) {
    // TODO: your code here
    throw new UnsupportedOperationException("TODO");
}
```

Replace the `throw` line with your solution, then run the file:

```bash
java 01-arrays/ArrayBasics.java
```

Each file checks itself and prints a line for every test case:

```
  PASS  sum([1, 2, 3])
  FAIL  max([-5, -2, -9])  expected -2, got 0
  TODO  indexOf([4, 8, 15], 8)

1 passed, 1 failed, 1 todo
```

To run every topic at once:

```bash
for f in */*.java; do java "$f"; done
```

Requires JDK 17 or newer.

## Roadmap

Work through the topics in order. Later ones build on earlier ones.

| #  | Topic | File | What you'll practice |
|----|-------|------|----------------------|
| 01 | Arrays | [ArrayBasics.java](01-arrays/ArrayBasics.java) | loops, indexes, two pointers, in-place changes |
| 02 | Strings | [StringBasics.java](02-strings/StringBasics.java) | `charAt`, `StringBuilder`, counting with `int[26]` |
| 03 | Recursion | [Recursion.java](03-recursion/Recursion.java) | base case + recursive step, no loops allowed |
| 04 | Searching | [Searching.java](04-searching/Searching.java) | binary search (iterative and recursive), O(log n) |
| 05 | Sorting | [Sorting.java](05-sorting/Sorting.java) | bubble, selection, insertion sort, merging |
| 06 | Linked List | [SinglyLinkedList.java](06-linked-list/SinglyLinkedList.java) | build your own: nodes, pointers, reversal |
| 07 | Stack | [ArrayStack.java](07-stack/ArrayStack.java) | build your own on a resizing array; bracket matching |
| 08 | Queue | [LinkedQueue.java](08-queue/LinkedQueue.java) | build your own with head and tail pointers |
| 09 | Hash Maps | [HashMapBasics.java](09-hash-maps/HashMapBasics.java) | `HashMap` and `HashSet`; turning O(n²) into O(n) |

### Progress

- [x] 01 Arrays
- [ ] 02 Strings
- [ ] 03 Recursion
- [ ] 04 Searching
- [ ] 05 Sorting
- [ ] 06 Linked List
- [ ] 07 Stack
- [ ] 08 Queue
- [ ] 09 Hash Maps

### Up next, after the basics

Merge sort and quick sort · binary trees and traversals · binary search trees · heaps / priority queues · graphs (BFS, DFS) · dynamic programming

## Big-O cheat sheet

Big-O describes how the running time grows as the input size `n` grows.

| Big-O | Name | Example |
|-------|------|---------|
| O(1) | constant | `nums[i]`, `map.get(key)`, stack push/pop |
| O(log n) | logarithmic | binary search |
| O(n) | linear | one loop over the array |
| O(n log n) | linearithmic | merge sort, `Arrays.sort` |
| O(n²) | quadratic | a loop inside a loop, bubble sort |
| O(2ⁿ) | exponential | naive recursive Fibonacci |

## Tips

- **Try it on paper first.** Trace the example by hand, then code it.
- **Read the FAIL line.** It tells you the input, what was expected, and what you returned.
- **Think about edge cases:** empty input, one element, negatives, duplicates.
- **Commit each solved exercise,** for example `git commit -am "arrays: solve reverseInPlace"`. Small commits make your progress easy to review later.
