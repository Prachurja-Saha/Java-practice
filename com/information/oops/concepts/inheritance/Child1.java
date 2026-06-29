package com.information.oops.concepts.inheritance;

public class Child1 extends Super1 {

    Child1() {}

    Child1(int x) {
        super(x);
    }

    public void method1() {
        System.out.println(super.getNumber());
        System.out.println(super.square());
    }


    public static void main(String[] args){

        Child1 child1 = new Child1(); // When we create an object of child it will call the Super class constructor
                                      // Here default constructor of super class will be called

        System.out.println(child1.square());
        child1.method1();

        System.out.println("----------------");

        Child1 child2 = new Child1(10);// Here in child class i mention super(x) means parametrized constructor of
                                          // super class will be called

        System.out.println(child2.square());
        child2.method1();
    }
}
/*
   Types of Inheritance in Java
   Below are the different types of inheritance which are supported by Java.
   Single Inheritance : a sub-class is derived from only one super class.

   Multilevel Inheritance : a derived class will be inheriting a base class and as well as the derived class also acts
   as the base class for other classes.

   Hierarchical Inheritance : In hierarchical inheritance, more than one subclass is inherited from a single base class.
   i.e. more than one derived class is created from a single base class.

   Multiple Inheritance : one class can have more than one superclass and inherit features from all parent classes.
   Note: that Java does not support multiple inheritances with classes. In Java, we can achieve multiple inheritances only through Interfaces.

   Hybrid Inheritance
*/
