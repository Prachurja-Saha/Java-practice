package com.practice.oops.concepts.abstraction;

public class Test implements Interface2{
    // Needs to implement all the abstract method

    @Override
    public void show() { System.out.println("show"); }

    @Override
    public void a() { System.out.println("a"); }

    @Override
    public void b() {}

    @Override
    public void c() {}

    @Override
    public void d() {}

    public static void main(String[] args) {

        Interface2 interface2 = new Test();
        interface2.show();
        interface2.a();

        Interface1 interface1 =  new Test();
        interface1.a();
//        interface1.show(); // CT error interface1 does not have show() method
    }
}
