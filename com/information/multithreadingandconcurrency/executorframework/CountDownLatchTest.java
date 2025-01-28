package com.information.multithreadingandconcurrency.executorframework;

import java.util.concurrent.*;

public class CountDownLatchTest implements Callable<Integer> {

    private CountDownLatch countDownLatch;

    CountDownLatchTest(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public CountDownLatchTest() {}

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Without CountDown Latch approach
        int threadCount = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        Future<Integer> thread1 = executorService.submit(new CountDownLatchTest());
        Future<Integer> thread2 = executorService.submit(new CountDownLatchTest());
        Future<Integer> thread3 = executorService.submit(new CountDownLatchTest());

        thread1.get();
        thread2.get(); // main thread will wait to finish this thread
        thread3.get();

        System.out.println("Main thread started");

        // With CountDown Latch Alternative Approach
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        executorService.submit(new CountDownLatchTest(countDownLatch));
        executorService.submit(new CountDownLatchTest(countDownLatch));
        executorService.submit(new CountDownLatchTest(countDownLatch));

        countDownLatch.wait(); // block the current thread
        // We can provide custom time for blocking other thread
        //countDownLatch.await(5, TimeUnit.SECONDS);

        System.out.println("Main thread started again");
        executorService.shutdown(); // in background thread is still running
        // if I want to stop all the background threads
        // --> executorService.shutdownNow();
    }

    @Override
    public Integer call() throws Exception {

        try {
            System.out.println("test " + Thread.currentThread().getName());
            return 0;
        } finally {
            countDownLatch.countDown(); // Decrement the count of the latch, releasing all waiting thread here it is
            // main thread if count reaches the 0
        }
    }
}
