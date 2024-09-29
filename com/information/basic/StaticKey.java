package com.information.basic;

/**
 * static can be:
 * <li> 1) Variable (also known as a class variable) </li>
 * <li> 2) Method (also known as a class method) </li>
 * <li> 3) Block </li>
 * <li> 4) Nested class </li>
 */
public class StaticKey {

    // Variables
    int rollNo;// instance variable
    String name;
    String college = "ITS"; // instance data members will get memory each time when the object is created.
    static String college2 = "ITS";//static variable


    // Method
    // A static method can be invoked without the need for creating an instance of a class.
    // The static method can not use non-static data member or call non-static method directly.
    // this and super cannot be used in static context.
    static void change() {
        // college = "BBDIT"; C.T Error non-static variable cannot access through static method
        college2 = "xyz"; // Static variable can be changed in static method
    }

    // Block
    // Is used to initialize the static data member.
    // It is executed before the main method at the time of classloading.
    static{System.out.println("static block is invoked");}

    public static void main(String[] args) {

        int y; // local variable

        StaticKey x = new StaticKey();

    }

}
