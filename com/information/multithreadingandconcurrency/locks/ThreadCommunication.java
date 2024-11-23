package com.information.multithreadingandconcurrency.locks;

class SharedResource {
    private int value;
    private boolean hasValue = false;

    public synchronized void produce(int newValue) throws InterruptedException {
        while (hasValue) {
            System.out.println(Thread.currentThread().getName()+": is waiting");
            wait();
        }
        value = newValue;
        hasValue = true;
        System.out.println(Thread.currentThread().getName()+": is Notifying other threads to start");
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (!hasValue) {
            System.out.println(Thread.currentThread().getName()+": is waiting");
            wait();
        }
        hasValue = false;
        System.out.println(Thread.currentThread().getName()+": is Notifying other threads to start");
        notifyAll();
        return value;
    }
}

/**
 * <h3> Methods </h3>
 *  <span style="color:red">All this method should Be Inside synchronized block </span>
 * <ol style= "color: orange">
 *     <li><span style="color:white"> wait():</span>  Purpose is the current thread to wait until another thread invokes
 *     notify() or notifyAll() on the same object. lock.wait();
 *     </li>
 *     <li><span style="color:white">notify()</span></li> Wakes up a single thread that is waiting on the object's
 *     monitor (the lock). If multiple threads are waiting, one of them is chosen arbitrarily.
 *     <li><span style="color:white">notifyAll()</span></li> Wakes up all threads that are waiting on the object's monitor.
 * </ol>
 */
public class ThreadCommunication {

        public static void main(String[] args) {
            SharedResource resource = new SharedResource();

            Thread producer = new Thread(() -> {
                try {
                    for (int i = 0; i < 5; i++) {
                        resource.produce(i);
                        System.out.println("Produced: " + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "ProducerThread");

            Thread consumer = new Thread(() -> {
                try {
                    for (int i = 0; i < 5; i++) {
                        int value = resource.consume();
                        System.out.println("Consumed: " + value);
                        Thread.sleep(1500);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "ConsumerThread");

            producer.start();
            consumer.start();
        }
}
