package com.information.collectionframework.collectioninterface.queue;

import java.util.*;

/**
 * The Deque supports the addition as well as the removal of elements from both ends of the data structure.
 * Therefore, a deque can be used as a stack or a queue.
 * <p>
 * ArrayDeque is faster than LinkedList and Stack.
 */
public class ArrayDequeTest {

    public static void main(String[] args) {

        Deque<String> deque = new ArrayDeque<>();
        deque.offer("arvind"); // It is used to insert the specified element into this deque.
        deque.offer("vimal"); // It is used to insert the specified element into this deque.
        deque.add("mukul");
        deque.add("rohit");
        deque.offerFirst("jai"); // Inserts the element e at the front of the queue. If the insertion is successful,
        // true is returned; otherwise, false.

        deque.offerLast("Raj");

        System.out.println("After offerFirst Traversal...");

        // Offer element will execute first
        for (String s : deque) {
            System.out.println(s);
        }

        //deque.poll();
        //deque.pollFirst();//it is same as poll()
        deque.pollLast();

        System.out.println("After pollLast() Traversal...");
        System.out.println(deque);

        deque.remove(); // FIFO remove first/head element
        System.out.println(deque);

        // Remove and return first same as removeFirst()
        System.out.println(deque.pop());

        System.out.println("Traversing backwards");
        Deque<Integer> newDeque = new ArrayDeque<>();
        newDeque.add(1);
        newDeque.add(2);
        newDeque.add(3);
        System.out.println("First element (Does not remove)"+newDeque.getFirst() + "Last element (Does not remove)"  + newDeque.getLast()) ;

        // Traversing backwards
        Iterator<Integer> iterator = newDeque.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // AddFirst AddLast RemoveFirst RemoveLast


    }
}
