package com.practice.practicecomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest implements Comparable { // Natural ordering

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(100);
        integerList.add(12);
        integerList.add(30);
        integerList.add(4);
                                        // ONLY ONE FIELD CAN SORT
        Collections.sort(integerList); // Integer class implements comparable interface and override
                                      // compareTo(Integer)

        // So if i want to change sort by descending or any other than i need to use comparator
        // b/c in comparable compareTo method is already implemented for Integer class.
        // for Custom i can change the implementation by overriding for Integer I can't change.

        // So we need comparator


    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
