package com.information.multithreadingandconcurrency.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  <div style= "color: yellow">2 Types of lock</div>
 * <ol>
 *     <li>
 *         <div style = "font-weight: bold">Intrinsic Lock: </div> These are build into every object in java,
 *         when we are using synchronized keyword we are using these automatic locks
 *         <span style="color: red; font-weight: bold;"> [AUTOMATIC]</span>
 *     </li>
 *     <li>
 *         <div style = "font-weight: bold">Explicit Lock : </div> Advance locks we can control this locks using
 *         Lock class from java.util.concurrent.locks.
 *         We have more control in this Lock we explicitly mention where to lock where to unlock
 *         <span style="font-weight:bold; color:red;"> Here we learn about Explicit Lock</span>
 *      </li>
 * </ol>
 */
public class LockTest {

    public static void main(String[] args){

     Bank sbi = new Bank();
     Runnable runnable = () -> sbi.withdraw(20); // Implemented runnable function interface method using lambda

     Thread thread1 = new Thread(runnable, "thread1");
     Thread thread2 = new Thread(runnable, "thread2");

     thread1.start();
     thread2.start();

    }
}

// 2 threads simultaneously will call Bank withdraw method using lock we can
class Bank {

    Lock lock = new ReentrantLock(); // Lock is an interface and ReentrantLock is the implementation class

    public int bankBalance = 100;

    public void withdraw(int amount){

        try {
            // Here pls assume Lock as key
            // new thread will wait till 1 sec to get the lock, if old thread is taking time more than 1 sec to perform
            // operation and could not deliver lock with in 1 sec then new thread will not enter inside if condition.
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){

                System.out.println("Current Thread : "+Thread.currentThread().getName()+" is Processing...");
                bankBalance -= amount;
                Thread.sleep(1000); // let's suppose old thread takes times more than 1 sec then new thread
                                         // will go to else condition

                System.out.println("Current Thread : "+Thread.currentThread().getName()+" Processing Completed ");


                // After all the operation is done unlocking the block now newThread can access
                lock.unlock(); /* better to write in finally or try with resources*/

                // lock.lock(); -> same as synchronization new thread will wait till the operations not completed

            } else {
                System.out.println("Current Thread : "+Thread.currentThread().getName()+"could not acquire the lock");
            }
        } catch (InterruptedException e) {

            // If we are monitoring code we will get the information that this thread is interrupted and
            // could not perform its operations
            Thread.currentThread().interrupt(); // Restoring the state
            throw new RuntimeException(e);
        }

        /* Thread which is interrupted line:74 we can perform operation here */
        if(Thread.currentThread().isInterrupted()){
            System.out.println("This thread was interrupted ");
        }
    }

}
