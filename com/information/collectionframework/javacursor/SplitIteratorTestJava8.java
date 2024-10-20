package com.information.collectionframework.javacursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SplitIteratorTestJava8 {

    /*
    * Features

       Splitting: A Spliterator can split itself into two parts, allowing for parallel processing.
       This means you can divide a collection into smaller parts and process them concurrently.

       Traversal: It allows for both sequential and parallel traversal of elements,
       making it suitable for use with the Java Streams API.

       Estimate Size: The Spliterator can provide an estimate of the number of elements it will traverse,
       which can help optimize performance in certain scenarios.

       Characteristics: It includes methods to determine characteristics such as whether the elements are ordered,
       sorted, or distinct.
    * */

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        Spliterator<String> spliterator = list.spliterator();

        // Traverse elements using tryAdvance
        spliterator.forEachRemaining(System.out::println);

        /*
        You need to reset the Spliterator because once you traverse a Spliterator,
        its state changes, and it cannot be reused for a new traversal unless it's reset.
        */
        // Resetting the spliterator for splitting demonstration
        spliterator = list.spliterator();

        // Splitting the spliterator
        Spliterator<String> splitSpliterator = spliterator.trySplit();

        System.out.println("\nProcessing elements in two parts:");

        // Processing the first part
        if (splitSpliterator != null) {
            splitSpliterator.forEachRemaining(System.out::println);
        }

        System.out.println("2nd part");
        // Processing the second part
        spliterator.forEachRemaining(System.out::println);

    }
}
