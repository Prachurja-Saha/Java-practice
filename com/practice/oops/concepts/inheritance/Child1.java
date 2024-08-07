package com.practice.oops.concepts.inheritance;

public class Child1 extends Super1 {

    Child1() {
        super();
    }
    Child1(int x) {
        super(x);
    }
    public void method1() {
        System.out.println(super.getNumber());
        System.out.println(super.square());
    }


    public static void main(String[] args){

        Child1 child1 = new Child1();
        System.out.println(child1.square());
        child1.method1();

        System.out.println("----------------");

        Child1 child2 = new Child1(10);
        System.out.println(child2.square());
        child2.method1();
    }
}

