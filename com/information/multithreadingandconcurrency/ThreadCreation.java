package com.information.multithreadingandconcurrency;

/*
* We can create new Thread by 2 ways
* 1. By extending Thread Class
* 2. By Implementing runnable interface
*/
/* Thread implements Runnable */

// Extending thread class
class NewThread extends Thread{

    @Override
    public void run() {
        // Infinite loop
//        while (true){
//            System.out.println(Thread.currentThread().getName());
//        }
    }
}

// Implementing Runnable interface
class NewThread2 implements Runnable {

    @Override
    public void run() {
//        while (true){
//            System.out.println(Thread.currentThread().getName());
//        }
    }
}

public class ThreadCreation {

    public static void main(String[] args) throws InterruptedException {

        // Thread creation using Extending thread class
        NewThread newThread = new NewThread();
        newThread.start();

       /* Here below mention Thread life cycle */
        // Thread creation using Implementing Runnable interface
        NewThread2 newThread2 = new NewThread2();
        Thread thread = new Thread(newThread2); // 1st state [NEW]: Thread is created but not started
        thread.start(); // 2nd state [Runnable]: After start method called now thread is ready to run waiting for
                        //                       CPU time

        // 3rd state [Running]: When CPU gets time now thread will be running mode[In java running are part of runnable
        //                      there is no running in java state enum].
        // 4rt state [Time Waiting]: Sometimes thread is blocked or waiting for other threads to execute
                                         Thread.sleep(100); // now main thread stops for 100 milli sec
        // 5th state [Terminated]: When Thread stops.


        // thread.join(); -> means caller method will wait for thread to finish here caller is main thread.

        /* Execution will be random order */
//        while (true){
//            System.out.println(Thread.currentThread().getName());
//        }

    }
}
