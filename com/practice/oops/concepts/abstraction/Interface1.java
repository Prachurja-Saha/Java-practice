package com.practice.oops.concepts.abstraction;

/**
 * Interfaces can have abstract methods and variables. It cannot have a method body.
 * <ul>
 *  <li> Java 8, we can have default and static methods in an interface </li>
 *  <li> Java 9, we can have private methods in an interface. </li>
 *  <li> An interface is declared by using the interface keyword. It provides total abstraction
 *       means all the methods in an interface are declared with the empty body, and all the fields are public,
 *       static and final by default. A class that implements an interface must implement all the methods
 *       declared in the interface. </l1>
 *  </ul>
 *
 *  3 Reason to use interface
 *  <li> It is used to achieve total abstraction.</li>
 *  <li> By interface, we can support the functionality of multiple inheritance. </li>
 *  <li> It can be used to achieve loose coupling </li>
 */
public interface Interface1 {

    // In Java 8, Interface fields are public, static and final by default, and the methods are public and abstract.

    int x = 10; // After java 8 means -> public static final int x = 10

    // All are abstract method
    void a(); // means ->public abstract void a()
    void b();
    void c();
    void d();

//  interface can extend other interface
    /*
     * If a class implements multiple interfaces, or an interface extends multiple interfaces, it is known as
     *     multiple inheritance.
     */

    // TODO: VERY IMPORTANT BELOW NOTES [WHY MULTIPLE INHERITANCE IS SUPPORTED FOR INTERFACE]
    /*
     Multiple inheritance is not supported in the case of class because of ambiguity. Ambiguity in Parent class.
     Consider a scenario where A, B, and C are three classes. The C class inherits A and B classes.
     If A and B classes have the same method and you call it from child class object,
     there will be ambiguity to call the method of A or B class.

     However, it is supported in case of an interface because there is no ambiguity.
     It is because Method of parent interface contains abstract methods so there will be no implementation.
     Its implementation is provided by the implementation class. For example:

     interface Printable {
      void print();
      }

     interface Showable {
      void print();
     }

     class TestInterface3 implements Printable, Showable {
       public void print(){System.out.println("Hello");}
       public static void main(String args[]){
       TestInterface3 obj = new TestInterface3();
       obj.print();
     }

     */



}