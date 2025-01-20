# CallBack
In Java, a callback is a technique where you pass a piece of executable code(typically as an object or a lambda function) 
to be executed at a later time. Callbacks are widely used for asynchronous programming, event handling, 
and designing flexible and reusable code.
generally callback methods are called after async operation done or completed

How Callbacks Work:
Definition: A callback is a reference to a method or function that is passed as an argument to another method. 
When the method receiving the callback completes its task, it calls (or executes) the callback method.

Asynchronous Operations: Callbacks are commonly used in asynchronous operations, 
allowing a program to continue executing other tasks while waiting for an operation to complete.


Example :
// Define a callback interface
interface Callback {
    void onComplete(String result);
}

// A class that uses the callback
class Task {
    void performTask(Callback callback) {
        // Simulate a long-running task
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulating a delay
                callback.onComplete("Task Completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

// Main class to test the callback
public class CallbackExample {
    public static void main(String[] args) {
        Task task = new Task();
        task.performTask(new Callback() {
        @Override
        public void onComplete(String result) {
        System.out.println(result);
        }
        });
        
                System.out.println("Task started...");
    }
}
