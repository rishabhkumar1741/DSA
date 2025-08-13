# Java Collections Framework & Streams
- 📚 [Collection Framework](#collection-framework)
- 📝 [List Interface](#list-interface)
  - 📦 [Internal Working of ArrayList](#internal-working-of-arraylist)
- ⚖️ [Comparator](#comparator)


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

If you want, I can now retrofit emoji icons for the previous topics too:
- 📚 Collection Framework
- 📝 List Interface
- 📦 Internal Working of ArrayList
- ⚖️ Comparator
  This way your README’s Table of Contents becomes both clickable and visually scannable.
  Shall I go ahead and give you that updated, emoji‑powered master TOC?

