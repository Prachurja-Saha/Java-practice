package com.information.java8.functionalinterface.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest implements Comparable<ComparableTest> {

    public int roll;
    public String name;

    public ComparableTest(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    // In comparable there is compare to method needs to override
    // Because of this we can only sort by roll means we cannot sort by name or other fields
    // for that we need comparator -> compare method
    @Override
    public int compareTo(ComparableTest o) {

        return Integer.compare(this.roll, o.roll); // Compare by roll;
//        return  this.compareTo(o);

    }

    @Override
    public String toString() {
        return "ComparableTest{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<ComparableTest> list = new ArrayList<>();
        list.add(new ComparableTest(10,"j"));
        list.add(new ComparableTest(1,"l"));
        list.add(new ComparableTest(2,"a"));

        Collections.sort(list);// -> it will automatically call the compareTo method on the objects in the list
                              // to determine their order.
        // <T extends Comparable<? super T>> void sort(List<T> list)
        // T should implement comparable Class-> Here ComparableTest is doing that

        //(typically a modified mergesort) uses the compareTo method to compare elements in the list.
        //It repeatedly calls compareTo for pairs of objects until it has sorted the entire list.


        //
        //How Your Implementation Is Taken
        //Dynamic Dispatch: When the sorting algorithm calls compareTo,
        // it uses dynamic dispatch to call the appropriate method based on the actual object type.
        // Since your class implements Comparable, the algorithm will always call your compareTo method.
        //No Other Implementations: There’s no other implementation of compareTo that the sorting algorithm will
        // call, as long as your objects are of type ComparableTest.
        // If you create a different class that also implements Comparable,
        // it will have its own compareTo method.
    }
}
