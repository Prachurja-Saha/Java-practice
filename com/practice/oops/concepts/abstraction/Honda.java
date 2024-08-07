package com.practice.oops.concepts.abstraction;

/**
 * An abstract class can have a data member, abstract method,
 * method body (non-abstract method), constructor, and even main() method.
 * <p>
 * If Honda extends Bike then Honda class needs to implement all abstract method of Bike.
 */
public class Honda extends Bike {

    //In real scenario, implementation is provided by others i.e. unknown by end user
    @Override
    void run() {
        System.out.println("running safely");
    }

    public static void main(String args[]) {
//        Mostly, we don't know about the implementation class (which is hidden to the end user),
//        and an object of the implementation class is provided by the factory method.
//        A factory method is a method that returns the instance of the class
        Bike obj = new Honda();


        // hiding the implementation of run method
        obj.run();
        //In real scenario, method is called by programmer or user
    }
}
