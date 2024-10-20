package com.information.collectionframework.javacursor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Uni-Directional Iterator. -> forward direction only
 * HashMap in Java does not maintain any specific order of its entries
 * Enumeration -> legacy interface not required iterator is better in every way
 * ListIterator
 * Like Pointer
 */
public class IteratorInterfaceTest {

    /*
      You can use List methods for certain tasks, but Iterator provides:

        1) Safe element removal during iteration.
            When you use a List interface method like a for loop
            (e.g., for (int i = 0; i < list.size(); i++)) to iterate over a list,
            and you remove elements during the loop, you'll run into ConcurrentModificationException
            because modifying the collection while iterating it is unsafe.

        2) Uniform traversal across different collection types.
           common mechanism to traverse for List, Set, Queue

        3) Performance benefits in certain collections like LinkedList.
        // Inefficient for LinkedList (O(n) -> Linklist.get(i)) b/c Linked list is not INDEX BASED
        // for ArrayList list.get(i) -> o(1)
            for (int i = 0; i < linkedList.size(); i++) {
                System.out.println(linkedList.get(i));
            }

            // More efficient with Iterator
            Iterator<String> iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        4) Abstraction of traversal logic, making the code more flexible.

        ** for-each loop internally use iterator
        Thus, Iterator is useful when you need more control or when you're working with collections that
        don't support index-based access, like Set or Queue.
    */
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1); integerList.add(2); integerList.add(3);

        Iterator iterator = integerList.iterator();

        // Here iterator() -> abstract method return type Iterator
        // Define in Iterable Interface implemented by ArrayList class

        while (iterator.hasNext()){

            /*
                When you use the == operator to compare the Integer object from the iterator
                with the primitive int (in this case, 1), Java automatically performs unboxing.
                Unboxing converts the Integer object to its corresponding primitive type (int).
            */
            if((Integer) iterator.next()==1){
                System.out.println("a");
                iterator.remove();
            }
        }




    }

}
