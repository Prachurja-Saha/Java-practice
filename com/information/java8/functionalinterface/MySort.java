package com.information.java8.functionalinterface;


import java.util.Comparator;

// I created a MySort class with generic type
public class MySort<T extends Comparable<T>> implements Comparator<T> {

    // Here MySort<T extends Comparable<T>> T extends Comparable so we can use compareTo method
    // Bounding that T should be implements the class Comparable
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);  // This works because Integer or any T implements Comparable<Integer>
        // Here extends means Implements need to understand by checking interface or class
    }
}
