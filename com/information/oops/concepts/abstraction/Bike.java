package com.information.oops.concepts.abstraction;

/**
 * An abstract class can have a data member, abstract method, method body (non-abstract method),
 * constructor, and even main() method.
 * <p>
 * The abstract class can also be used to provide some implementation of the interface.
 * In such case, the end user may not be forced to override all the methods of the interface.
 */
abstract class Bike implements Interface1 { // abstract class must contain one abstract method

   // A method which is declared as abstract and does not have implementation is known as an abstract method.
    abstract void run();

    Bike(){
        System.out.println("bike is created");
    }

    void changeGear(){
        System.out.println("gear changed");
    }

    // Only Implementing abstract method c
    public void c(){
        System.out.println("I am c");
    }
}
