package com.information.collectionframework.collectioninterface.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Implements List and Deque Interface.
 * Deque extends Queue Interface
 */
public class LinkedListTest {

    // Queue -> First in First Out (FIFO)
    public static void main(String[] args){

        System.out.println("----------------Queue---------------------------");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // It will take queue interface add abstract method
        queue.add(2);
        queue.add(3);
        queue.add(4);

        queue.remove();// After removal Queue (First in will remove First)
        System.out.println("First Element :" + queue.poll());// Retrieve and Remove First element
        System.out.println(queue);
        System.out.println("Head : " + queue.peek());

        System.out.println("---------------List------------------------------");

        List<Integer> list = new LinkedList<>();
        list.add(1); // It will take List interface add method
        list.add(2);
        list.add(3);

//        Integer i = new Integer(100); // Deprecated so cant use
//        list.add(i);
//        list.remove(Object)       // Collection interface method

        list.remove(1); // Here needs to give index parameter

        // After removal List
        System.out.println(list);

        System.out.println("-------------------LinkList--------------------------");

        //////////  Multiple inheritance in linked list b/c it implements 2 Interface List, Queue ///////////
        // and add() abstract method is common for both List and Queue boolean add(E e); same for both so
        // no ambiguity

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove(); // queue method remove first
        linkedList.remove(1); // List method remove index based

        System.out.println(linkedList);
        System.out.println(linkedList.peek());// Head




    }

}
