package com.information.multithreadingandconcurrency;

/* Thread Safety -> If multiple threads accessing single block of code result unexpected data/error then that part of
*  code is not thread safe. Here we are tyring to achieve thread safety by performing java multithreading concept*/
class Count{
    private int num = 0;

    public void increment(){
        for(int i =0 ; i<100000 ; i++){
            this.num++;
        }
    }

    // Terminology -> if we use synchronization then that section is Critical Section/ Mutual exclusion
    // If we don't use synchronization & that section is used by multiple thread concurrently is called Race condition
    public synchronized void  incrementWithSynchronization(){
        for(int i =0 ; i<100000 ; i++){
            this.num++;
        }

        // alternative solution we can use synchronize in block of code
//        synchronized(this) {
//            for(int i =0 ; i<100000 ; i++){
//                this.num++;
//            }
//        }
    }

    public int getNum() {
        return num;
    }
}

/**
 * when there is 2 or more threads calling a method/block or reading a variable same time with same value
 * i.e. count 102 in both the thread count is 102 using common object
 * results problem error in operation this is fixed by synchronization.
 * If we apply  synchronization keyword in method or block inside method
 */
public class SynchronizationTest extends Thread {

    private Count count;

    SynchronizationTest (Count count){
        this.count = count;
    }

    @Override
    public void run() {
      count.increment();
    }

    public static void main(String[] args){
        Count count1 = new Count();
        SynchronizationTest synchronizationTest = new SynchronizationTest(count1);
        // same count1 obj calling same increment method simultaneously so not proper response will come b/c
        // sometimes method is calling by threads taking same variable value
        // i.e. count 123 both the threads  same time reading same value so proper response is not coming
        SynchronizationTest synchronizationTest2 = new SynchronizationTest(count1);
        synchronizationTest.start();
        synchronizationTest2.start();

        try{
            synchronizationTest2.join();
            synchronizationTest.join(); // main thread will wait to finish

        } catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println("Final result should be 200000 (100000+100000) but without synchronization result "
                + count1.getNum());
    }

    /*
    * synchronized keyword in Java is used to control access to critical sections of code,
    * ensuring that only one thread can execute a block of code or access a shared resource at a time.
    * This helps prevent concurrent modification issues, such as race conditions and inconsistent data states.
    *
    * It uses Lock concepts if one thread use synchronized block then that thread use lock to prevent other thread
    * to use synchronized block
    * */

}
