# Java Collections Framework & Streams
- 📚 [Collection Framework](#collection-framework)
- 📝 [List Interface](#list-interface)
  - 📦 [Internal Working of ArrayList](#internal-working-of-arraylist)
- ⚖️ [Comparator](#comparator)
- 🧵 [Vector](#vector)
- 🧱 [Stack](#stack)
- 🌳 [Tree](#tree)



## Collection Framework
A Collection Framework is a unified architecture in programming (notably Java, but the concept applies broadly) that provides a set of interfaces, classes, and algorithms to store, retrieve, and manipulate groups of objects efficiently.

### Key Points:
- Consists of interfaces (e.g., List, Set, Queue, Map) that define contracts for collection types.
- Includes classes (e.g., ArrayList, HashSet, PriorityQueue, HashMap) that implement these interfaces.
- Comes with algorithms (e.g., sorting, searching) that work across different types of collections.
- Promotes reusability and interoperability since all collection classes follow a standard API.
- Reduces coding effort — no need to reinvent data structures from scratch.
Example (Java):
```java
import java.util.*;

public class Main {
public static void main(String[] args) {
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Cherry");

        Collections.sort(list); // Sorting using built-in algorithm
        System.out.println(list); // [Apple, Banana, Cherry]
    }
}
```
### Use cases:
- Storing data with dynamic size.
- Performing complex operations (search, sort, shuffle) with minimal code.
- Switching between different data structures without rewriting business logic.

![alt text](StaticFiles/img.png)
![alt text](StaticFiles/img_1.png)
## List Interface

- Definition:
  The List Interface in the Collection Framework is an ordered collection (also known as a sequence) that allows duplicate elements and provides positional (index-based) access to elements.
- Key Points:
  - Maintains insertion order.
  - Allows duplicate elements.
  - Elements can be accessed by their index (starting at 0).
  - Supports iteration in both forward and backward directions (via ListIterator).
  - Common implementations:
    - Java: ArrayList, LinkedList, Vector, Stack.
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // duplicates allowed

        System.out.println(fruits.get(1)); // Banana
    }
}
```
- Use cases:
  - When you need an ordered collection with possible duplicates.
  - For positional access and modification.
  - Useful in scenarios like task lists, ordered playlists, and sequence-based operations.

## Internal Working of ArrayList

### Definition:
  ArrayList is a resizable array implementation of the List interface in Java. Internally, it uses a dynamic array to store elements and automatically manages its capacity.

Key Points (How it works internally)
- Underlying Data Structure:
  - Backed by a Object[] array.
- Default Capacity:
  - Starts with a default size (Java 8: 10).
- Resizing Mechanism:
  - When the array is full and a new element is added, ArrayList creates a new array with 1.5× the old capacity (newCapacity = oldCapacity + oldCapacity/2) and copies old elements into it.
- Index-Based Access:
  - Allows O(1) time complexity for get() and set() because it uses direct index access on the underlying array.
- Insertion:
  - Adding at the end: Amortized O(1).
  - Adding in the middle: O(n) because elements after the position must be shifted.
- Removal:
  - After removing an element, all subsequent elements are shifted left to fill the gap. This is O(n).
- Null Elements:
  - Can store null values.
- Thread Safety:
  - Not synchronized — must be manually synchronized for multi-threaded environments using Collections.synchronizedList().

## Comparator

#### Definition:
  Comparator is an interface in Java used to define custom ordering logic for objects. It allows sorting based on fields/properties without changing the object’s natural ordering defined by Comparable.
- Key Points:
  - Found in java.util package.
  - Functional interface → can be implemented with lambda expressions (Java 8+).
  - Has one main method:
    ```java  
    int compare(T o1, T o2);
    ```
- Returns:
  - Negative → o1 is “less than” o2
  - Zero → equal
  - Positive → o1 is “greater than” o2
- Allows multiple sorting strategies without modifying the class.
- Works with sorting methods like Collections.sort() and List.sort().
```java
import java.util.*;

class Student {
    String name;
    int marks;
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public String toString() {
        return name + " - " + marks;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Amit", 85),
            new Student("Bhavna", 92),
            new Student("Charan", 78)
        );

        // Sorting by marks (descending)
        Comparator<Student> byMarksDesc = (s1, s2) -> Integer.compare(s2.marks, s1.marks);
        students.sort(byMarksDesc);

        System.out.println(students);
    }
}
```


-   Use cases:
    - Sorting by different criteria without altering model classes.
    - Multi-level sorting (e.g., sort by name, then by marks).
    - Situations where natural ordering (Comparable) isn’t suitable.

## Vector
Definition:

Vector is a legacy class in Java that implements a growable array of objects, similar to ArrayList, but with built-in synchronization for thread safety.

### Key Points
- Part of  package.
- Implements , , , and .
- Thread-safe → all methods are synchronized.
- Slower than  in single-threaded environments due to locking overhead.
- Automatically resizes when capacity is exceeded (like ).
- Default growth: doubles capacity when full (vs.  which grows by 50%).

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        System.out.println(vector); // [Apple, Banana, Cherry]
    }
}
```
Use Cases
- When you need a thread-safe dynamic array and don’t want to manually synchronize an ArrayList.
- Legacy systems or APIs that still use Vector.
- Rarely used in modern code — prefer ArrayList + Collections.synchronizedList() or CopyOnWriteArrayList.

### ⏱️ Time Complexities

| Operation         | Time Complexity |
|------------------|-----------------|
| Access by index  | O(1)            |
| Insert at end    | Amortized O(1)  |
| Insert at middle | O(n)            |
| Delete by index  | O(n)            |
| Search           | O(n)            |

## Stack
- Definition:
  A Stack is a linear data structure that follows the LIFO (Last In, First Out) principle  the last element added is the first one to be removed.

Key Points
  - Java provides a Stack class in java.util (extends Vector).
- Common operations:
  - push() → add element to top
  - pop() → remove and return top element
  - peek() → view top element without removing
  - isEmpty() → check if stack is empty
  - search() → find position of element from top (1-based index)
- Can also implement stack using Deque (ArrayDeque) for better performance.

Example (Java)
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.peek()); // C
        System.out.println(stack.pop());  // C
        System.out.println(stack);        // [A, B]
    }
}
```



⏱️ Time Complexities

| Operation   | Time Complexity |
|-------------|-----------------|
| push        | O(1)            |
| pop         | O(1)            |
| peek        | O(1)            |
| search      | O(n)            |
| isEmpty     | O(1)            |



Use Cases
- Undo functionality in editors.
- Expression evaluation (infix → postfix).
- Backtracking algorithms (DFS, recursion).
- Browser history navigation.


## Tree

- Definition:
  A Tree is a hierarchical data structure consisting of nodes, where each node has a value and references to child nodes. It starts from a root node and branches out into subtrees.

Key Points
- Terminology:
  - Root: Topmost node.
  - Leaf: Node with no children.
  - Parent/Child: Relationship between connected nodes.
  - Subtree: Tree formed by a node and its descendants.
  - Height: Longest path from root to leaf.
  - Depth: Distance from root to a node.
- Types of Trees:
  - Binary Tree: Each node has ≤ 2 children.
  - Binary Search Tree (BST): Left child < root < right child.
  - Balanced Tree (e.g., AVL, Red-Black): Maintains height balance.
  - Heap: Complete binary tree with heap property.
  - Trie: Tree for prefix-based string storage.
  - N-ary Tree: Node can have N children.
- Traversal Techniques:
  - Inorder (LNR): Left → Node → Right
  - Preorder (NLR): Node → Left → Right
  - Postorder (LRN): Left → Right → Node
  - Level Order: Breadth-first using queue

Example (Binary Tree Node in Java)

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
```


⏱️ Time Complexities (Binary Search Tree)

| Operation   | Average Case | Worst Case |
|-------------|--------------|------------|
| Search      | O(log n)     | O(n)       |
| Insert      | O(log n)     | O(n)       |
| Delete      | O(log n)     | O(n)       |
| Traversal   | O(n)         | O(n)       |


Worst case occurs when the tree becomes skewed (like a linked list).


Use Cases
- Hierarchical data (e.g., file systems, org charts).
- Efficient searching and sorting (BST, AVL).
- Expression parsing (syntax trees).
- Auto-complete and dictionary (Trie).
- Priority queues (Heap).
