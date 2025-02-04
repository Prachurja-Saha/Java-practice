package com.information.multithreadingandconcurrency.executorframework;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// In CountDownLatch we cannot reuse the threads but in cyclic we can reuse
// Useful when we ensure that certain threads reach at certain points before certain task to start
public class CyclicBarrierTest implements Callable<String> {

    private final CyclicBarrier cyclicBarrier;

    public CyclicBarrierTest(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    /*
    * Allows a set of threads to wait for each-other
    * */

    public static void main(String[] args) {

        int threadCount = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        // Simple way
        //CyclicBarrier barrier = new CyclicBarrier(threadCount);

        // Better way
        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> { // Tracking all thread
            System.out.println("All parties have arrived at the barrier, resetting...");
        });
        executorService.submit(new CyclicBarrierTest(barrier));
        executorService.submit(new CyclicBarrierTest(barrier));
        executorService.submit(new CyclicBarrierTest(barrier));

        System.out.println("Cyclic Barrier does not stop main thread");

        /*
        * Due to the fast execution of reset(), it prints before the threads have a chance to reach the barrier and
        * execute the barrier action.
        * As for not seeing the exception and needing to manually stop the threads,
        * this is likely happening because the barrier resets before the threads get a chance to reach the barrier
        * the first time. Hence, they don't encounter a BrokenBarrierException.
        * */

        /*
        * address this by introducing a delay or some form of synchronization to ensure that the main thread waits until
        * all threads have reached the barrier before calling barrier.reset(). reason for below code
        * */
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        barrier.reset(); // Re setting barrier to its initial state
        // The barrier.reset() method is meant to reset the CyclicBarrier to its initial state only
        // if no threads are currently waiting at the barrier. If any parties currently waiting in the barrier
        // they will return with broken barrier exception

        System.out.println("resetting...");

        executorService.submit(new CyclicBarrierTest(barrier));
        executorService.submit(new CyclicBarrierTest(barrier)); // Reusing


        executorService.shutdown();// If we don't do this than main thread will not stop

    }

    @Override
    public String  call() throws Exception {

        System.out.println(Thread.currentThread().getName() + "Started"); // All thread will print this first
        Thread.sleep(2000);
        cyclicBarrier.await(); // Here threads will wait for other threads
        System.out.println(Thread.currentThread().getName() + "Finished");

        return "Ok";
    }
}
