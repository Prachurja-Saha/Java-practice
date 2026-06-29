# Memory Leak
When an application allocates memory (e.g., creates objects) but does not free it even after the objects are no 
longer needed, it leads to a memory leak. This means the garbage collector cannot reclaim the memory, 
causing gradual memory consumption until the system runs out of RAM.

# Memory Leak Code
public class MemoryLeakExample { `Example of static collection memoy leaks`

// static variables are not garbage collected as long as the class is loaded. Static variables are stored in the 
// Method Area (or Metaspace in Java 8+), not the heap. Garbage Collection only works on heap memory
private static List<String> cache = new ArrayList<>();
    public static void addData() {
        for (int i = 0; i < 1000000; i++) {
           // Static variables prevent objects inside them from being garbage collected.
            cache.add("Data-" + i);  // Adding objects but never removing them
        }
    }

    public static void main(String[] args) {
        while (true) {  // Infinite loop, keeps consuming memory
            addData();
        }
    }
}

# 🛠️ Common Causes of Memory Leaks
1. Unclosed Resources (File, DB, Network connections) [Fix: Use try-with-resources]
   `In moder App we use In Spring Data JPA, database connections are automatically managed using connection pooling, 
   so you don't need to explicitly open or close connections. The EntityManager and DataSource handle it internally.`
2. Static Collections Holding Objects [ Fix: Use WeakReference, Clear Lists, or Concurrent Maps.]
3. ThreadLocal Not Cleared in Thread Pools [Fix: Call threadLocal.remove(); after use.]

# Class Loading and Unloading
In Java, class loading refers to the process where the JVM loads class definitions into memory(running application),
while class unloading is the process where the JVM removes classes from memory when they are no longer needed.(stop app)
