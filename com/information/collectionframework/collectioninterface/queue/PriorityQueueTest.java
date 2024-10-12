package com.information.collectionframework.collectioninterface.queue;

import com.practice.Employee;

import java.util.PriorityQueue;
import java.util.Queue;

// Only maintain the highest priority Natural Order Sort
// Does not maintain the overall sort
public class PriorityQueueTest {

    /*  VERY IMP
    * PriorityQueue might look unordered because a PriorityQueue only ensures that the head of the queue
    * has the highest-priority element.
    * It does not maintain a globally sorted order for all elements when you print the queue directly.
    * This is due to how PriorityQueue works internally;
      * it's structured as a binary heap where only the head is guaranteed to be the highest priority,
      * not the entire collection.
    * */
    public static void main(String[] args){

        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Queue<Employee> employees = new PriorityQueue<>();

        priorityQueue.add(2);
        priorityQueue.add(1);

        System.out.println(priorityQueue);

        // Reverse Order
        // Method Signature -> PriorityQueue(Comparator<? super E> comparator)
        Queue<Integer> priorityQueue2 = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
        // or -> using static method -> Comparator.reverseOrder()

        priorityQueue2.add(10);
        priorityQueue2.add(20);

        System.out.println(priorityQueue2);

    }
}
