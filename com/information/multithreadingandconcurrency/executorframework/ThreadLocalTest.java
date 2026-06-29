package com.information.multithreadingandconcurrency.executorframework;

// Not preferred due to memory leak risk
/*
    ThreadLocal<T> is a Java class that provides thread-local storage. Each thread accessing a
    ThreadLocal variable gets its own isolated copy, preventing race conditions in multi-threaded applications.

    Why Use ThreadLocal?
    Avoid Shared State Issues – No race conditions because each thread has its own variable.
    Store Request-Specific Data – Useful in web applications for storing per-request details
    (e.g., user authentication, transaction IDs).
    Thread-Specific Caching – Caches data that is relevant only for a specific thread.


    Each thread has a separate instance of the variable.
    One thread’s value does not affect another thread’s value.
    Useful for maintaining thread-scoped state (e.g., request-specific data in a web app).
*/
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocalCounter = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            int value = threadLocalCounter.get(); // Get thread-local value
            value += 1;
            threadLocalCounter.set(value); // Set new value
            System.out.println(Thread.currentThread().getName() + ": " + threadLocalCounter.get());
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start(); // parallel execution
        thread2.start();
    }
}

/*

        Use Case	                        Best Alternative
        Web request-scoped data	            @RequestScope (Spring)
        Reactive programming	            Reactor Context
        Background tasks (thread pools)	    CompletableFuture
        Need to inherit data in threads	    InheritableThreadLocal (Risky)

*/