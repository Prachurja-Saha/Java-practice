package com.information.collection.list;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Java LinkedList class maintains insertion order.
 * Java LinkedList class is non synchronized.
 * In Java LinkedList class, manipulation is fast because no shifting needs to occur.
 */
public class LinkedListTest {

    /*
    Doubly Linked List -> In the case of a doubly linked list, we can add or remove elements from both sides.
    */

    public static void main(String[] args){

        List<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2"); // Here we declare linkedList as List so we cant access the methods of LinkedList

        LinkedList<String> linkedList1 = new LinkedList<>();
        linkedList1.addFirst("1");// Here we can
        linkedList1.add("2");
        linkedList1.addLast("3");
        linkedList1.add("10");
        linkedList1.remove(1); // 1 is index // remove is present in List also but this one is diff
        linkedList1.removeFirst();

        System.out.println(linkedList1);

        Iterator<String> iterator = linkedList1.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // ### LinkedList is better only in addFirst, addLast, RemoveFirst and RemoveLast
        //     b/c  To insert in first in arraylist we need to shift all the elements in Array list
        //     time complexity -> O(n) but for linklist O(1)
        //
        //   LinkList  Insert in middle ->  in linklist need to traverse to the insertion point -> o(n)
        //                                  and then insertion o(1) total time complexity -> o(n) + o(1) = o(n)
        //                                  if i have reference of the node than -> o(1) for insertion
        //   ArrayList Insert in middle -> o(n) due to shifting elements. Insertion point included implicitly
        //   for Insertion in middle both -> o(n)
    }

}
