package com.information.collectionframework.javacursor;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Very useful only applicable for list collections i.e -> ArrayList, LinkedList etc
 * extends Iterator
 */
public class ListIteratorTest {

    /*
    *
        Bidirectional Traversal: Can traverse the list in both forward and backward directions.
        Modification Support:    Allows adding and removing elements during iteration.
        Index Access:            Provides methods to get the current index and set elements.
        Enhanced Features:       Supports hasPrevious(), nextIndex(), and previousIndex() methods
                                 for more control over traversal.
        Generics Support:        Like Iterator, it supports generics for type safety.
* */

    // remove(), hasNext(), next() already present just like iterator
    // Extra Methods
    // nextIndex(): Returns the next element index or list size if the list iterator is at the end of the list.
    // Backward direction -> hasPrevious(), previous(), previousIndex()
    // set(Object obj): Replaces the last element returned by next() or previous() with the specified element
    // add(Object obj): Inserts the specified element into the list at the position before the element
    //                  that would be returned by next()

    public static void main(String[] args){

        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Creating a ListIterator
        ListIterator<String> listIterator = list.listIterator();

        // 1. Iterating forward
        System.out.println("Forward iteration:");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // 2. Iterating backward
        System.out.println("\nBackward iteration:");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // Here position changed of iterator so Resetting

        // 3. Adding elements
        listIterator = list.listIterator(); // Resetting the iterator
        listIterator.next(); // Move to "A"
        listIterator.add("D"); // Add "D" after "A"

        // 4. Removing elements
        listIterator.next(); // Move to "B"
        listIterator.remove(); // Remove "B"

        // 5. Setting elements
        listIterator.next(); // Move to "C"
        listIterator.set("E"); // Change "C" to "E"

        // Final List
        System.out.println("\nFinal List:");
        for (String item : list) {
            System.out.println(item);
        }
    }
}

