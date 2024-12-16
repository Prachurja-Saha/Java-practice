package com.information.multithreadingandconcurrency.executorframework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *  Fixed Rate ( we can provide Sequentially time to execute also we can provide delay for first execution)
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args){

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.schedule(()-> System.out.println(" Delay 1 sec "), 1000, TimeUnit.MILLISECONDS);

        executorService.shutdown();

        ScheduledExecutorService newExecutorService = Executors.newScheduledThreadPool(1);
        newExecutorService.scheduleAtFixedRate(()-> System.out.println(" Delay 1 sec at first and then 2 sec periodically "),
                1000, 2000, TimeUnit.MILLISECONDS);

        /* VIMP */
        // If I do immediate shutdown than new Threads are not able to enter inside thread pool
        // what shutdown does is restrict new threads to go inside thread pool so due to periodic delay of 2 sec
        // only 1 thread will enter inside thread pool (to prevent this we can provide delay for shutdown) so that some
        // threads can enter inside thread pool

        // Providing 10 sec delay to shut down so newly periodic threads can enter inside thread pool
        //  approx 5 threads can enter b/c I provided 2 sec periodic delay ( 5*2 = 10 sec )
        //  and here I provided time for sut down is 10 sec
        newExecutorService.schedule(newExecutorService::shutdown, 10, TimeUnit.SECONDS);


    }
}
