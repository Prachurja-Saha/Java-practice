package com.information.multithreadingandconcurrency;

public class ThreadMethods extends Thread {

    public ThreadMethods(String threadName) {
        super(threadName); // Providing thread name, calling Thread Constructor
    }

    @Override
    public void run() {

        try {
            System.out.println(" Custom Thread starts");
            Thread.sleep(5000);
            System.out.println(" Custom Thread running");
            System.out.println("Name : " + Thread.currentThread().getName() + " "
            + "Priority : " + Thread.currentThread().getPriority()); // custom thread

        } catch (InterruptedException e) {

            System.out.println(e);
        }
    }

    /* Methods
    * Join: caller thread will wait for mentioned thread to complete or terminate.
    * Set Priority : Prioritizing the threads*/

    public static void main(String[] args) throws InterruptedException {

        /* Join & start */
        ThreadMethods threadMethods = new ThreadMethods("My Thread ");
        threadMethods.start();
        threadMethods.join(); // Here main method will wait for threadMethods to finish.

        System.out.println(threadMethods.getState().name()); // should be terminated
        System.out.println(Thread.currentThread().getName()); // main thread

        /* Priority */
        ThreadMethods minPriorityThread = new ThreadMethods("minPriorityThread");
        ThreadMethods mediumPriorityThread = new ThreadMethods("mediumPriorityThread");
        ThreadMethods maxPriorityThread = new ThreadMethods("maxPriorityThread");

        minPriorityThread.setPriority(MIN_PRIORITY); // min priority -> 1
        mediumPriorityThread.setPriority(NORM_PRIORITY); // by default norm priority -> 5
        maxPriorityThread.setPriority(MAX_PRIORITY); // max -> 10

        // Starting all
        minPriorityThread.start(); mediumPriorityThread.start(); maxPriorityThread.start();

        /* Interrupted */
        // Thread.interrupted();
        // If threads is performing an operation and in middle if we interrupt that thread using Thread.interrupted()
        // it will throw interrupted exception.
        /*
        Example ->
                    public class ThreadInterruptExample {
                public static void main(String[] args) {
                    Thread sleepingThread = new Thread(() -> {
                        try {
                            // This thread will sleep for 10 seconds
                            System.out.println("Going to sleep...");
                            Thread.sleep(10000);
                            System.out.println("Woke up normally.");
                        } catch (InterruptedException e) {
                            System.out.println("Thread was interrupted during sleep.");
                        }
                    });
                    sleepingThread.start();
                    // Give the thread a moment to start sleeping
                    try {
                        Thread.sleep(2000); // current thread (here it is main thread)
                    } catch (InterruptedException ignored) {

                    }

                    // Now, interrupt the sleeping thread(during this time sleepingThread is still executing
                    sleepingThread.interrupt(); // -> in this line it will throw interrupted exception

                    Main Thread Sleeps: The main thread (from which sleepingThread was started)
                    then sleeps for 2 seconds (Thread.sleep(2000);).
                    This ensures that sleepingThread has started and is in the sleep state.

                    Interrupting the Thread: After the main thread wakes up, it calls sleepingThread.interrupt();
                    to interrupt sleepingThread while it is still sleeping.
                    This will result in InterruptedException being thrown in sleepingThread,
                    causing it to print "Thread was interrupted during sleep."
                }
            }


        */

        /* yield */
        // Thread.yield(); // Giving hint that u can use other threads (more random threads will run)
        // It is just hint to JVM use other threads not necessary it will work 100%

        /* DAEMON THREAD */
        // User Thread : Created by User to perform operation. Main thread is also User thread (need to cnf)
        // If user thread is running JVM will wait to finish User thread
        // Daemon Threads : Runs in background (if Daemon threads is running JVM will not wait to finish
        // Daemon thread.
        // ** We can Set Demon thread
        ThreadMethods DaemonThread = new ThreadMethods("Daemon thread");
        DaemonThread.setDaemon(true); // works background

    }
}
