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

