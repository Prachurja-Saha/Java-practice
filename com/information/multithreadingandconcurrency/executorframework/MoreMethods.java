package com.information.multithreadingandconcurrency.executorframework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MoreMethods {

    public static void main(String[] args) throws InterruptedException {

        /* We Can Create Multiple Callable/ Runnable */
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        /* Without invoke all */
        // 1 thread using callable
        Future<Integer> integerFuture1 =  executorService.submit(() -> {
            System.out.println("Task 1");
            return 1;
        }); // returning 1

        // 2 thread creating explicitly callable and then storing executorService
        Callable<Integer> integerCallable = () -> {
            Thread.sleep(5000);
            System.out.println("Task 2");
            return 2;
        };
        Future<Integer> integerFuture2 = executorService.submit(integerCallable);

        List<Future<Integer>> futuresWithoutUsingCallable = List.of(integerFuture1, integerFuture2);


        /* Using Invoke All we can Invoke multiple Threads */
        /* VVIMP : invokeAll blocks the current thread (main thread) until all tasks are completed, inside invoke all
        ensuring that when it returns, all tasks have finished.*/
        Callable<Integer> newIntegerCallable1 = () -> {
            System.out.println("Task 3");
            return 3;
        }; // Every callable has their own implementation
        Callable<Integer> newIntegerCallable2 = () -> 4;

        // In Invoke all method signature we can provide max time for thread completion
        List<Future<Integer>> futuresUsingCallable
                = executorService.invokeAll(List.of(newIntegerCallable1, newIntegerCallable2));

        futuresUsingCallable.forEach(e -> {
            try {
                System.out.println(e.get()); // Prints Return statement
            } catch (InterruptedException | ExecutionException ex) {
                Thread.currentThread().interrupt();
                System.out.println(ex);
            }
        });

        executorService.shutdown(); // Now No New Submit/task will be executed

        System.out.println("---- END-----");

        /*
        * Independent Execution: Threads in a thread pool (ExecutorService) run independently of the main thread.
        *
        * They will continue to run even if the main thread finishes execution.Shutdown Mechanism:
        * To stop the threads in the thread pool, you need to explicitly call shutdown() or shutdownNow()
        * on the ExecutorService.
        * */

        /*
        * shutdownNow() on an ExecutorService will attempt to force shutdown all running threads managed by the executor.
        * */



        /*
        *  Executes the given tasks, returning the result of one that has completed successfully
        *  Integer/String i = executorService.invokeAny(listOfCallable)
        *  Returns the first thread which executed successfully
        * */

        /*
        *  integerFuture1.cancel(true); -> Cancel the task
        * */

        /*
            Executors.newCachedThreadPool(); // Dynamic in size can increase and decrease depending on the task\
            Used When There is large data and the task is short period of time (means task will take short time to finish)
            // Risky -> Size can be large
        */


    }
}
