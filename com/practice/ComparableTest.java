package com.practice;

public class ComparableTest<T> implements Comparable<T>{

    public int age;
    public String name;

    @Override
    public int compareTo(T o) {
        return 0;
    } // it takes one object parameter
}
