package com.practice.practicecomparable;

import com.practice.Employee;

import java.util.Comparator;

//public class ComparatorTest<T> implements Comparator<T> {
 public class ComparatorTest implements Comparator<Employee> {

     @Override
    public int compare(Employee o1, Employee o2) { // For different sort we have to write different class
                                                   // so we can use lambda function / anonymous function
        //Here Employee dont implement Comparable
        return o1.getName().compareTo(o2.getName());// geName return String which implements Comparable
    }

    //If we mention Generic then like this now here to use compareTo we need -> T extend Comparable
//    @Override
//    public int compare(T o1, T o2) {
//        return 0;
//    }

    // If we do no mention T -> type then it will take as Object
//    @Override
//    public int compare(Object o1, Object o2) {
//        return o1.;
//    }

}
