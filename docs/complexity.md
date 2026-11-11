# Sorting algorithms — theoretical comparison

| Algorithm | Best | Average | Worst | Additional space | Stable? |
|---|---|---|---|---|---|
| Bubble (early exit) | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Cocktail | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Shell (halving gaps) | depends on gaps | depends on gaps | O(n²) | O(1) | No |
| Merge | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick (median-of-three pivot) | O(n log n) | O(n log n) | O(n²) | O(log n) typical recursion | No |
| Heap | O(n log n) | O(n log n) | O(n log n) | O(1) | No |
| Counting (range k) | O(n+k) | O(n+k) | O(n+k) | O(k) | No (implementation) |
| Radix (4 byte passes) | O(4n) | O(4n) | O(4n) | O(n+256) | Yes |

`CountingSort` explicitly rejects value ranges larger than 2,000,000 for safety; it is not general-purpose.

## Collections

| Custom collection | Main characteristic | Typical operations |
|---|---|---|
| `MyArrayList` | dynamic array | get O(1), append amortized O(1), insert O(n) |
| `MyLinkedList` | doubly linked list | access O(n), add/remove at ends O(1) |
| `MyHashSet` | separate chaining | average add/contains O(1), worst O(n) |
| `MyHashMap` | separate chaining | average put/get O(1), worst O(n) |
| `MyArrayDeque` | circular array | add/remove at ends amortized O(1) |
| `MyStack` | LIFO via own array list | push/pop amortized O(1) |
| `MyQueue` | FIFO via own deque | enqueue/dequeue amortized O(1) |
| `MyBinarySearchTree` | **unbalanced** BST | avg O(log n), worst O(n) |

Educational implementations do **not** implement all `java.util` contracts (fail-fast iterators, sublists, spliterators, thread safety, tree balancing, iterator.remove, serialization). They are intentionally simplified.
