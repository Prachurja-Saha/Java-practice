package com.information.java8.functionalinterface.comparator;

import java.util.Comparator;

public class ComparatorTest implements Comparator {

    @Override
    public int compare(Object o1, Object o2) { // Here instead of Object U have to Provide Generic T or any Class Obj
        // Then we can compare by that
        return 0;
    }

//    compareTo() Method Behavior:
//If the values are equal: compareTo() will return 0.
//If the first value is greater: compareTo() will return a positive number
// (usually 1, but any positive value indicates "greater than").
//If the first value is smaller: compareTo() will return a negative number
// (usually -1, but any negative value indicates "less than").


//    Double.compare(double d1, double d2)
//    Integer.compare...
}
