package com.information.multithreadingandconcurrency.executorframework;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class VolatileAndAtomic {

    /*
    *  Volatile: Every thread contains local copy or cache of variables, even though if we change the variable in main
    *  memory, thread will show the cache result. This problem solved by volatile keyword
    *  volatile means (data will not be taken from cache it will be retrieved from main memory )
    * */

    private volatile boolean value; // Data will be retrieved from main memory not from cache

    public void setValue(boolean value) throws InterruptedException {

        System.out.println("Started Write Operation");
        Thread.sleep(2000);
        System.out.println("Setting value to " + value);
        this.value = value;
    }

    public boolean getValue() throws InterruptedException {
        System.out.println("Started Read Operation");
        while (!value) { // If value is not volatile then thread will take the cache/old value, it will be infinite loop
        // This loop will continue until value becomes true
        }

        Thread.sleep(1000);
        System.out.println("Value is now " + value);
        return value;
    }

    public static void main(String[] args) throws InterruptedException {

        /* Checking Volatile */
        VolatileAndAtomic volatileAndAtomic = new VolatileAndAtomic();
        Thread writerThread = new Thread(() -> {
            try {
                volatileAndAtomic.setValue(true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread readerThread = new Thread(() -> {
            try {
                volatileAndAtomic.getValue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        writerThread.start();
        readerThread.start();

        /* Atomic */
        VolatileAndAtomic v = new VolatileAndAtomic();

        Thread t1 = new Thread(() -> {
            IntStream.range(0,1000).forEach(i -> v.increment());
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                v.increment();
            }
        });
        t1.start();
        t2.start();

        t2.join(); t1.join();
        System.out.println("Final value :" + v.getAtomicInteger());


    }



    /*
    * Atomic : Alternative of synchronized this will not block or lock any thread, This classes are thread safe
    *  i.e. AtomicInteger, AtomicBoolean ...etc.
    * */

    // Previously we learn synchronized if concurrent thread is modifying same field
    public AtomicInteger atomicInteger = new AtomicInteger();

    public void increment() {
        atomicInteger.incrementAndGet(); // increment by 1
    }

    public int getAtomicInteger() {
        return atomicInteger.get();
    }

}
