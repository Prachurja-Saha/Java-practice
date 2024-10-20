package com.information.collectionframework.collectioninterface.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Set Interface -> Remove duplicate/ unordered object stored based on the hashcode
// HashSet allows storing a single null value. not multiple
public class HashSetTest {

    /*
Feature			HashSet															    List
Duplicates		Does not allow duplicates.											Allows duplicate elements.
Order			Unordered: No guarantee of element order.							Ordered: Elements are ordered based on insertion.
Performance		O(1) for add, remove, and contains (assuming good hash function).	O(n) for contains and remove, O(1) for add at the end in ArrayList.
Null Values		Allows one null element.											Allows multiple null values.
Implementation	Implements the Set interface.										Implements the List interface.
Use Case		Use when you need unique elements and don’t care about order.		Use when you need to maintain order and allow duplicates.
Common Classes	HashSet, LinkedHashSet, TreeSet.									ArrayList, LinkedList.
*
* */
    public static void main(String[] args) {

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(1);
        integerSet.add(2);


        Iterator<Integer> iterator = integerSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<String> hashSet = new HashSet<>();

        // Add elements
        hashSet.add("Apple");
        hashSet.add("Banana");
        if (hashSet.contains("Apple")) {
            System.out.println("Apple is in the set");
        }

        // Remove element
        hashSet.remove("Banana");

        // Size of the set
        System.out.println("Set size: " + hashSet.size());

    }
}

