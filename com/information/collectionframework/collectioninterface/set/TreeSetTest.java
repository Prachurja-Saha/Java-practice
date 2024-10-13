package com.information.collectionframework.collectioninterface.set;

import java.util.*;

// Implements Set <- extends sorted Set interface<- extends Navigable set interface <- implement
public class TreeSetTest {

    //Natural order set with distinct elements
    public static void main(String[] args){

        Set<Integer> sortedSetCollection = new TreeSet<>();

        sortedSetCollection.add(1);
        sortedSetCollection.add(0);
        sortedSetCollection.add(3);

        //Natural Sorting
        System.out.println(sortedSetCollection);


        /*
        * // Define the interface
            interface Interface1 {
                void abstract1(); // Abstract method
            }

            // Class C implements the interface
            class C implements Interface1 {
                public void abstract1() {
                    System.out.println("Implementation of abstract1 in class C");
                }
            }

            // Class B has a constructor that accepts Interface1
            class B {
                B(Interface1 i) {
                * Like Polymorphism Interface i = new C()-> Upcasting
                    i.abstract1(); // Call the method defined in the interface
                }
            }

            // Main class to test the implementation
            public class Example {
                public static void main(String[] args) {
                    C c = new C();        // Create an instance of class C
                    B b = new B(c);      // Pass the instance of C to class B's constructor
                }
            }

        * */
        // ABOVE EXPLAINED
        // Converting Tree set into List
        List<Integer> list = new ArrayList<>(sortedSetCollection); /* VVIMP*/
        // Here->  public ArrayList(Collection<? extends E> c) means Collection<Integer> x = sortedSetCollection
        // This means Collection<? extends E>-> any sub interface SET, List etc or any Implemented Class
        // Are allowed Here SortedSetCollection is a reference variable of TreeSet Class which is implemented
        // Class of Set



        //using utility class Sort the List in reverse order
        Collections.sort(list, (o1,o2)-> o2.compareTo(o1) );

        System.out.println(list);

        list.add(3); // Adding one duplicate
        // Convert List to Set (duplicates will be removed)
        Set<Integer> set = new TreeSet<>(list);

        Set<Integer> treeSet = new TreeSet<>((o1,o2)-> o1.compareTo(o2)); // Method signature also accepts comparator


    }
}
