package com.information.java8;

import com.information.java8.functionalinterface.FunctionalInterface1;
import com.information.java8.functionalinterface.FunctionalInterface2;
import com.information.java8.functionalinterface.MySort;
import com.information.java8.functionalinterface.comparable.ComparableTest;
import com.information.java8.functionalinterface.comparator.ComparatorTest;

import java.util.*;

public class Main implements FunctionalInterface1, FunctionalInterface2 {

    static void test() {
        System.out.println("static test main");
    }

    // Main Method
    public static void main(String[] args) {

        Main.test();
        FunctionalInterface2.test();
        FunctionalInterface1.test();

        //Using lambda Expression
        FunctionalInterface1 lambdaTest  = () -> System.out.println("Amit"); // Here Data type of lambda
                                              // expression is functional interface -> FunctionalInterface1
        lambdaTest.add(); // In above line we already implemented

        List<Integer> integerList = new ArrayList<>(Arrays.asList(20,10,1,90,-11));

        // sort(List<T> list, Comparator<? super T> c) -> ? b/c if type is List then inside can be any thing
        Collections.sort(integerList, new MySort<Integer>());// mysort implements comparator
        // Upcasting  Comparator<? super Integer> xyz = new MySort<>() // internally ths happened

        System.out.println(integerList);

        //USING LAMBDA b/c COMPARATOR IS FUNCTIONAL INTERFACE - Comparator<Integer> comparatorLambdaTest = (Integer o1, Integer o2)-> o1-o2;
        integerList.sort((o1,o2) -> o2 - o1); // reverse
        System.out.println("reverse using lambda :"+integerList);

        integerList.sort(((o1, o2) -> o1.compareTo(o2)));//again orginal
        System.out.println("lambda using compareTo->"+integerList);



        /////////////// Using Comparator
        List<ComparableTest> comparatorTest = new ArrayList<>(5);
        comparatorTest.add(new ComparableTest(1,"Amit"));
        comparatorTest.add(new ComparableTest(20,"Akash"));
        comparatorTest.add(new ComparableTest(11,"Amit"));
        comparatorTest.add(new ComparableTest(19,"Ajay"));
        comparatorTest.add(new ComparableTest(18,"Amit"));
        comparatorTest.add(new ComparableTest(18,"Amit"));
        System.out.println(comparatorTest);
//        comparatorTest.sort((o1,o2) -> o1.roll- o2.roll);
        // TODO:------------------------------------------------
//        comparatorTest.sort(Comparator.comparing()); // Here comparing is static method

        comparatorTest.sort(Comparator.comparing(ComparableTest::getName).thenComparing(ComparableTest::getRoll));
        // Function<T,U> T -> ComparableTest U -> Return type (String)
        // Implicitly T -> ComparableTest





    }



    @Override
    public void add() {
        // Here No Ambiguity b/c add() -> abstract method so no implementation in both interface
    }

    @Override
    public void print() {
        // Here Ambiguity b/c print() -> different implementation. so we have to mention which method to call
        FunctionalInterface1.super.print();
        FunctionalInterface2.super.print();
    }
}
