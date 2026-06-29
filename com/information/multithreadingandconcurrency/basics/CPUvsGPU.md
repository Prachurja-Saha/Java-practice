# Important
If a CPU has 8 cores and developer create 800 java threads, the OS will schedule them using context switching
Each Core has 2 CPU threads, Total hardware threads is 8*2 -> 16 CPU threads
1. `Only 16 java threads run truly in parallel (2 per core) the rest 784 threads wait in the queue`
2. The OS switches between threads in a round-robin or priority-based manner. This means it runs 16 threads at a time,
   then another 16, then another 16, repeating 50 times(800/16 =50)
3. Context switching is expensive(takes CPU time). More threads -> More switching -> More overhead
4. [Virtual threads increase the number of concurrent threads but do not make individual threads execute faster. The speed 
   of execution remains limited by the CPU cores and context switching overhead]
   Java virtual threads improves -> Higher Concurrency, Lower Thread Overhead, Better I/O handling


# Java thread before project loop or virtual thread use OS Thread (Traditional way)
JVM ask the OS to create OS thread, The OS creates a  new OS thread and maps it to a CPU thread so in traditional Java 
a java thread = OS thread (If a CPU core is free, the OS assigns the OS thread to a CPU thread if more OS threads exist
than the CPU threads, the OS switches between them) [OS handles/manages everything]

# After Virtual thread
JVM creates the thread, but does not ask the OS for an OS thread, instead it reuses a few OS threads to run 
thousands/millions of java threads. JVM acts like mini thread scheduler. Java Virtual thread != OS Threads
 
