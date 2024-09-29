package com.practice;

import java.util.*;

public class Practice {

    void genericPractice() {

        GenericWithT<Integer> integerGenericWithT = new GenericWithT<>();

        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);
        integerGenericWithT.printTList(list);
//        integerGenericWithT.printTList(List.of("String")); C.T error b/c -> GenericWithT<Integer>

        integerGenericWithT.printWList(List.of("1",1,12030L));
        integerGenericWithT.printWListRestriction(List.of(1,2,3,1203L,0.123));// will not take String, and other obj
    }

    void collection(){

        Collection<Integer> integerCollection = new ArrayList<>();
        // Here Integer is E -> Element

        //--> Add and Add ALL
        integerCollection.add(1);
        integerCollection.addAll(new ArrayList<>()); // Accepts -> Collection<? extends E> only E and sub class
        // of E is allowed here reference is Collection so all the class which implements Collection by
        // inheritance allowed
        integerCollection.addAll(List.of(1,2,3)); // List.of return -> List<E> E-> Integer
        //integerCollection.addAll(List.of(""));// C.T Error E -> Integer
        integerCollection.addAll(Arrays.asList(100,200,300,200));
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2024);
        integerCollection.addAll(arrayList);

        System.out.println("After Add -> " + integerCollection);

        //--> Remove
        integerCollection.remove(1); //only accept the element index which is closer
        integerCollection.removeAll(arrayList);

        System.out.println("After Removal -> "+integerCollection);

        //--> Retain
        Collection<?> c = new ArrayList<>(Arrays.asList(100,200,200,400));
        integerCollection.retainAll(c);// only accept the element index which is closer.
        System.out.println("After Retain -> " + integerCollection); // Remove everything except


        //Contains & ContainsALL -> IMP AND USEFUL
        integerCollection.addAll(List.of(1,2,3,4,5,6,7,8,9));
        System.out.println("Contains & ContainsAll-->" + integerCollection);
        System.out.println(integerCollection.contains(100));
        System.out.println(integerCollection.contains(500));
        Collection<?> b = new ArrayList<>(Arrays.asList(200,200,100));
        System.out.println(integerCollection.containsAll(b)); // true

        // Is Empty
        System.out.println(!b.isEmpty()); // is not empty


        // public Iterator iterator()
        Iterator<Integer> iterator = integerCollection.iterator();
        while (iterator.hasNext()) { // Return boolean it check next element are present or not
            Integer element = iterator.next();
            System.out.println(iterator.hasNext()+"--->"+element);
        }

        // ArrayList
        //WE CAN MENTION THE SIZE OF ARRAYLIST
        List<Integer> integerList = new ArrayList<>(10); // initial capacity -> 10
        integerList.add(1); integerList.add(10); integerList.add(2);

        //Sort using comparator
        //List<E> extends Collection<E> E -> Element type Here it is Integer
        // Comparator<? super E> accepts E or super Class of E
        integerList.sort(Comparator.naturalOrder());
        System.out.println("Sorted Asc->" + integerList );
        integerList.sort(Comparator.reverseOrder());
        System.out.println("Sorted Dsc->" + integerList );
//        integerList.sort(Comparator.nullsFirst());

        /*
        The syntax Comparator<? super E> represents a generic comparator
        that can compare objects of type E or any of its superclasses.
        This concept is based on contravariance in Java generics,
        where ? super E allows flexibility to pass a comparator that can compare E as well as any of its parent
         classes.

    Example:
For Comparator<? super Integer>, the comparator can compare Integer objects or any of its superclasses like
Number or Object. The super keyword ensures that we can pass a comparator for more general types.
*/

    }

    public static void main(String[] args) {

        Practice practice  = new Practice();
        practice.genericPractice();
        practice.collection();

        CustomLinkedList<Integer> integers = new CustomLinkedList<>();
        integers.add(1);
        System.out.println("-->" + integers.get(0));


    }


}

