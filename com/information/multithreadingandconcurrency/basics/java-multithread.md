# Java Supports multithreading, allows dev to create app to performs multiple tasks simultaneously
- maximize the CPU utilization. for multiple core
- part of java.lang package makes easy implementation of concurrent execution.
- for single thread JVM and OS manages threads (switching and time slicing concept illusion) 
- Java supports multithreading through `java.lang.thread Class & java.lang.runnable interface`
- [When Java programs runs one threads begins immediately called main thread `Responsible for executing main 
  method Program` ]

# In most modern web applications, each user request typically corresponds to a separate thread, 
# especially in a multithreaded server environment. Thread Pools are commonly used to manage and optimize 
# the use of threads, ensuring efficient handling of multiple concurrent user requests.

Web servers use thread pools to manage incoming requests. 
Not every user needs a dedicated thread for their entire session; 
instead, each request from a user is handled by a thread from the pool.
Threads are reused for multiple requests, allowing the server to handle many users efficiently.

Asynchronous Processing:
Many web applications use asynchronous processing to handle I/O operations without blocking threads. 
This allows a single thread to handle multiple tasks concurrently, increasing the overall capacity.

# Need to know How Async operation is better for concurrent threads 
# ( my personal reason may be -> it does not stops the threads

[ Very Imp ]
##### If all threads are in running (active) mode — not waiting, not blocked — how many can truly run concurrently on 
##### an 8-core CPU? -> Exactly 8 threads can run concurrently on an 8-core CPU.

# If all threads are in not running (active) some are waiting or paused or etc.. than we can use more thread than cpu core
1. Many threads are often waiting (blocked)
- In a web app, threads spend a lot of time waiting for I/O: database responses, file reads, network calls.
- While a thread is waiting, it’s not using the CPU — it's just paused.
- This frees up the CPU to run other threads that are ready to do actual work.
2. Thread pools manage execution
- Spring Boot (via Tomcat/Jetty) uses a thread pool to handle requests.
- Even if you have 200 threads in the pool, only the ones that are ready to run will be scheduled on available cores.
- The rest are idle or waiting for I/O.
3. OS and JVM are optimized for this
- The JVM and OS kernel are designed to handle many threads efficiently.
- They manage which threads are ready to run and which are waiting, without needing all of them to be active simultaneously.



