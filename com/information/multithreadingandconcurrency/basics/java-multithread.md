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