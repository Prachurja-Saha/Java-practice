package com.information.multithreadingandconcurrency.executorframework;

import java.util.concurrent.*;

/**
 * A thread pool is a collection of pre-initialized threads that stand ready to perform tasks. <br>
 * <span style="color:white"> Without ThreadPool thread will create and destroy for every task,
 * Creating and destroying thread for every task can be expensive/ overhead and here
 * in executor I have control over thread count (I can decide max no. thread to be created to perform task </span> <br>
 * Thread pools help manage the number of threads that are concurrently executed,
 * improving performance and resource management, especially in scenarios where multiple short-lived tasks need to be executed.
 * <br>
 * <span style="color:white">Executor framework introduce in java 5 (Simplifies development of concurrent application)</span>
 * <br>
 * <span style ="color:red"> When there is no executor developer manually mange thread which we are doing before
 * in locks and other thread methods </span>
 */
public class ThreadPoolTest {

    // Thread Operation using Executor
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        /* Runnable */

        Long startTime = System.currentTimeMillis();

         /* If u create multiple thread but operation requires single thread then only one thread will execute */

        /*
        * Creates a thread pool with a fixed number of threads (3 in this case).
        * Task Submission: The for loop submits 10 tasks to the thread pool.
        * Task Execution: The thread pool contains 3 threads. These threads will pick up tasks from the queue and execute them.
        * Concurrency: At most, 3 tasks will be executed concurrently because the thread pool size is 3.
        * */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            // Number of submit method is equivalent to Number of task
            executorService.submit(() -> {
                // Operation
                try {
                    System.out.println(Thread.currentThread().getName() + "is performing operation");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "operation completed");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        /*
        *
        * Initiates Shutdown: When you call shutdown(), the ExecutorService stops accepting new tasks.
        * Any tasks that have already been submitted[executorService.submit] will continue to execute until completion.
        *
        * No New Tasks:
        * Any attempts to submit new tasks after shutdown() has been called will result in a RejectedExecutionException.
        *
        * Graceful Termination:
        * The method allows the system to gracefully terminate all running and queued tasks before actually shutting
        * down the executor.
        *
        * Polling for Termination:
        * You can use [awaitTermination] to block until all tasks have completed execution or the timeout occurs.
        * */
        executorService.shutdown();

        // It waits till 10 sec max if all threads operation completed within 10 sec then main thread will continue
        // Wait for all tasks to complete or timeout after 10 seconds
        /* It blocks the main threads for all the executor to be completed, if thread is taking more
        * than 10 sec it will go inside if condition, than main threads unblocked. If threads completed before
        * 10 sec i.e 5 sec all the thread execution completed than after 5 sec it unblocks main thread */
        if(!executorService.awaitTermination(10, TimeUnit.SECONDS)){
            System.out.println("Operation is taking more that 10 sec ");

            // Will attempt to force shutdown all running threads managed by the executor.
            executorService.shutdownNow();
        }

        System.out.println("Total Time taken to peform operation : " + (System.currentTimeMillis()-startTime));

        /* Callable */

        // Creating New Executer Servive
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);

        /* If we want to return something we can use callable The only difference b/w callable and runnable  */
        Future<?> future = executorService2.submit(() -> 50); // Implementing Callable Interface not Runnable

        System.out.println(future.get()); // main thread will wait to finish the task [Returns: the computed result]
        if(future.isDone()){
            /*
            * This method : Returns true if this task completed. Completion may be due to normal termination,
            * an exception, or cancellation -- in all of these cases, this method will return true
            * main thread will not wait
            * */
            System.out.println("Done");
        }

        if(executorService2.isTerminated()){
            System.out.println("This method return true if all the executorService2 task is completed");
        }

    }


}
