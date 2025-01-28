package com.information.multithreadingandconcurrency.executorframework;

import java.util.concurrent.*;

public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try{
                System.out.println(Thread.currentThread().getName() + "is running");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "is completed");
            } catch (Exception _){}
            return "OK";
        });

        System.out.println(future.getNow("If thread(still running) is not returning anything then " +
                "this message "));
        System.out.println("Main thread");

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try{
                System.out.println(Thread.currentThread().getName() + "is running");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "is completed");
            } catch (Exception _){}
            return "OK2";
        });

        // We can stop main thread by
        // future2.join(); or  future2.get();

        CompletableFuture<Void> c = CompletableFuture.allOf(future, future2); // invoking all
        c.join(); // stops main thread, basically this becomes synchronous


        // Then apply
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try{
                System.out.println(Thread.currentThread().getName() + "is running");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "is completed");
            } catch (Exception _){}
            return "OK";
        }).thenApply(x -> x + x); // OK OK response after execution complete
        // we can use .timeout to provide the custom execution time

        System.out.println(future3.get());

        /* Using executor service*/
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            try{
                System.out.println(Thread.currentThread().getName() + "is running");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "is completed");
            } catch (Exception _){}
            return "OK3";
        }, executorService).orTimeout(1, TimeUnit.SECONDS).exceptionally(s -> "Timeout");
        System.out.println(future4.get());

        executorService.shutdown(); // without this main thread will not stop
    }
}
