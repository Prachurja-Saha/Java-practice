package com.practice.oops.concepts.polymorphism;

/**
 *
 *  NOTE 2 (OVERRIDE)
 * * Important notes -> override
 * class A{
 * protected void msg(){System.out.println("Hello java");}
 * }
 * public class Simple extends A{
 * void msg(){System.out.println("Hello java");}//C.T.Error
 * public static void main(String args[]){
 * Simple obj=new Simple();
 * obj.msg();
 * }
 * }
 */
public class Overriding extends Parent {


    @Override
    void testOverriding() {
        System.out.println("test method from Overriding Class");
    }
    void callParentClassOverridingMethod(){
        super.testOverriding();
    }

    void testOverriding(int x) {
        System.out.println(x);
    }

    void display(int x) {
        System.out.println(x);
    }
    void display(String x) {
        System.out.println(x);
    }

    public static void  main(String[] args){
        Parent p = new Overriding(); // Upcasting

//        Dynamic binding occurs at runtime. The method to be called is determined based on the actual object type,
//        not the reference type. Key Characteristics of Dynamic Binding:
//        Happens at runtime.
//        Based on the actual object type.
//        Used for method overriding.
        p.testOverriding();// dynamic binding


        //  p.testOverLoading(10); CT Error
        //  compiler will check the reference variable type and check the method is present if not CT Error
        // # So at compile time compiler is checking based on the reference variable. if it is present then
        // new keyword allocates memory on the heap and initializes the object.
        // At runtime, the JVM uses dynamic binding (or late binding) to determine the actual method to invoke
        // based on the object's type (the actual class of the object that the reference variable points to).


        Overriding o = new Overriding();
        o.testOverriding(); // Also Dynamic binding
        o.callParentClassOverridingMethod(); // Static binding
        o.display(1); o.display("2");// static binding

//        Overriding o2 = (Overriding) new Parent(); CT Error

    }
}



