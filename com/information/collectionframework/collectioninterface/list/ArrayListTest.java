package com.information.collectionframework.collectioninterface.list;


import java.util.*;

/**
 * Dynamic Array Size is not fix double if capacity full initial capacity 10
 */
public class ArrayListTest {

    /*
    *  The time complexity for list.add(1) in an ArrayList is O(1) on average. However,
    * if the internal array needs to be resized (when it reaches its capacity),
    * the time complexity for that specific operation would be O(n) due to copying elements to the new array.
    * But overall, adding an element is typically considered O(1) for average cases.
    *
    * if insertion at beginning or i middle than o(n) b/c of shifting elements
    * */


    public static void main(String[] args) {

        Collection<?> c = new ArrayList<>(); // b/c Collection<E> -> not Collection<?>
//        c.add("Amit"); C.T->  it indicates that the collection can hold elements of an unknown type.
//        The compiler does not know what specific type of elements are valid to add to the collection,
//        so it prevents you from adding anything to it.

        //We Can Add any object
        Collection<Object> c1 = new ArrayList<>();
        c1.add("Amit");
        c1.add(0.1234);
        c1.add(123456739L);
        c1.add(true);

        System.out.println(c1);

        //Scanner.hasNext()--> continues input

        // IMP Methods
        // int indexOf(Object o) -> Return the index
        // remove(int index)
        // protected void removeRange(int fromIndex, int toIndex)
        // E set(int index, E element) // replace element of index
        // void sort(Comparator<? super E> c)
        // List<E> subList(int fromIndex, int toIndex)

        List<String>  listOfString = new ArrayList<>(Arrays.asList("Amit", "Akash"));
        listOfString.addAll(List.of("Rohit","Sana","Antu","a","b","c","d","e","f","g","h"));
        // Immutable b.c we are sending fixed size array and then we type cast to list<E>

        Collections.sort(listOfString);
        listOfString.remove(8);
        System.out.println("sorted->: "  + listOfString);


        System.out.println(listOfString.get(0).charAt(1));

        //-------------List.of()---------Java-9-------------------------------
        List<Integer> integerList = List.of(1,2); // Immutable List
        // When you use List.of(1, 2) in Java, the JVM creates an instance of an internal class that
        // implements the List interface but enforces immutability.
//        Performance Optimization: For small lists, Java can use specific lightweight classes,
//        which are faster than general-purpose lists like ArrayList.
//        This allows efficient memory usage and faster access times.
//        Memory Efficiency: Immutable lists can be optimized to minimize memory footprint,
//        especially for small collections.
//        Thread Safety: Immutable collections are inherently thread-safe because they cannot be modified after creation.



        //-------------------Anonymous inner class------------------------------------
        //Anonymous inner class that implements the List<Integer> interface. custom innerclass
//        List<Integer> integerList1 = new List<Integer>() {
//            ....... here we will implement all abstract method
//        };



        /////////////////////////////////// VERY IMP //////////////////////////
        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(1); integerList2.add(2); integerList2.add(10); integerList2.add(3);
        integerList2.add(1,12); // Act as linked list it will not replace
        /////////////////////////////////// VERY IMP //////////////////////////

        //ANY Element
        List list = new ArrayList<>();
        list.add("a"); list.add(1); list.add(true);
        System.out.println("--->"+ list);
    }

}
