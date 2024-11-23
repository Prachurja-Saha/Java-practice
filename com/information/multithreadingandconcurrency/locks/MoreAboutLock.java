package com.information.multithreadingandconcurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * <h4> Topics </h4>
 * <ul style="color:orange">
 *     <li> <span style="color:yellow"> Fairness of locks:</span> <br>
 *          <span style="color:white">Issue:</span> When multiple threads are executing concurrently and trying
 *          to acquire the same lock, it's possible that a thread which requested the lock first might get
 *          delayed or even never acquire the lock because another thread that requested the lock later gets it
 *          first.
 *          This scenario is considered unfair because it can lead to thread <span style="color:white">starvation.</span>
 *          <br>
 *          <span style="color:white">Solution:</span> Using a fair lock
 *          <span style="color:red">(private final Lock fairLock = new ReentrantLock(true); // Fair lock) </span>
 *          ensures that threads acquire the lock in the order they requested it.
 *          This means that if multiple threads are waiting to acquire the lock, the thread that has been
 *          waiting the longest will be the next one to acquire it when the lock becomes available,
 *          thus maintaining fairness.
 *          Operating systems and thread schedulers implement fairness policies to manage thread execution. <br>
 *          <span style="color:white">Fair schedulers: </span>Operating systems and thread schedulers implement
 *          fairness policies to manage thread execution. Fair schedulers try to distribute CPU time evenly
 *          among threads, often using algorithms like round-robin or priority scheduling.<br>
 *          <span style="color:white">Overall Impact:</span>While fairness can improve overall system responsiveness
 *          and prevent starvation, it might come at a cost of reduced throughput, as ensuring fairness can introduce
 *          additional overhead and context switching.
 *     </li>
 *     <li> <span style="color:yellow"> ReadAndWriteLock:</span> <br>
 *          allows multiple threads to read a shared resource simultaneously but restricts access to only one
 *          thread when writing to the shared resource.
 *          Read Threads will wait for the write thread to unlock and then all the Read threads run concurrent
 *     </li>
 *     <li> <span style="color:yellow"> DeadLock:</span> <br> If two threads are depending on each other result->
 *          Created DeadLock. It will Run Infinitely (circular thread). Thread1 is waiting for Thread2 to provides Lock
 *          and Thread2 is waiting for Thread1 to provide Lock
 *     </li>
 *
 * </ul>
 */
public class MoreAboutLock {

    public static void main(String[] args) throws InterruptedException {

        /* Read and Write Lock Test */
        ReadAndWriteTest readAndWriteTest = new ReadAndWriteTest();

        Thread writeThread1 = new Thread(()-> {
            for (int i=0; i<10; i++){
                readAndWriteTest.increment();
            }
        });

        Thread readThread1 = new Thread(()-> {
            for (int i=0; i<10; i++){
             readAndWriteTest.print();
            }
        });

        Thread readThread2 = new Thread(()-> {
            for (int i=0; i<10; i++){
                readAndWriteTest.print();
            }
        });

        writeThread1.start(); readThread2.start(); readThread1.start();

        writeThread1.join();
        readThread1.join();
        readThread2.join(); // main thread will wait to finish all the threads

        System.out.println("Final count: "+readAndWriteTest.count);

    }
}

class ReadAndWriteTest {

    ReadWriteLock lock = new ReentrantReadWriteLock();// Provides 2 lock one for Read and other for Write
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    public int count = 0;

    void increment(){
        writeLock.lock(); // applied lock
        System.out.println(Thread.currentThread().getName() + "writing");
        count++;

        /* write thread unlocked now read threads will run concurrently until again write thread unlocks */
        writeLock.unlock(); // unlocking
    }

    void print(){
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + "reading");
        System.out.println("count:" + count);
        readLock.unlock();
    }

}

/* Dead Lock  Need to understand more*/
class DeadLockTest {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("Method1: Acquired lock1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("Method1: Acquired lock2");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("Method2: Acquired lock2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println("Method2: Acquired lock1");
            }
        }
    }

    /*
    *
    * method1 acquires lock1 and then tries to acquire lock2.
    * method2 acquires lock2 and then tries to acquire lock1.
    * If method1 has acquired lock1 and is waiting for lock2,
    * and method2 has acquired lock2 and is waiting for lock1,
    * they both end up waiting indefinitely, causing a deadlock.
    *
    * */

    public static void main(String[] args){

        /* Dead Lock Test */
        DeadLockTest deadLockTest = new DeadLockTest();
        Thread thread1 = new Thread(deadLockTest::method1);
        Thread thread2 = new Thread(deadLockTest::method2);

        thread1.start(); thread2.start();
    }

}