package com.information.oops.concepts.polymorphism;

public class OverLoading extends Parent {

    int age;
    int roll;

    OverLoading(int age){
        this.age = age;
    }

    OverLoading(int age, int roll){
        this.roll = roll;
        this.age = age;
    }

    OverLoading(){
    }

    void testOverLoading(String name) {
        System.out.println("testing method Overloading from Overloading Class by" + name);
    }

    // Method Overloading
    void display(String display){
        System.out.println(display);
    }

    // Method Overloading
    void display(int display){
        System.out.println(display);
    }

//        Static Binding (Early Binding)
//        Static binding occurs at compile time. The compiler determines the method to be called based on the
//        method signature and the reference type.
    public static void main(String[] args) {
          Parent p = new OverLoading();// upcasting
          p.testOverLoading(); // static binding -> b/c based on the method signature compiler is deciding which method
                               // to call so no run time is involved here

//        p.testOverLoading("Antu"); -> Compile Time Error b/c compiler will first check with reference
//        p.display(); -> Compile Time Error b/c at compile time compiler will check display method is present
//                        in Parent Class. if not then compile error b/c Parent is reference. then after runtime
//                        object memory will allocate


        OverLoading o = new OverLoading(23, 1);
        o.testOverLoading();// static -> compiler is deciding based on the method signature
        o.testOverLoading("Antu");

        o.display(1);//static
        o.display("2");
//        Key Characteristics of Static Binding:
//        Happens at compile time.
//        Based on the reference type.
//        Used for method overloading, static methods, private methods, and final methods.
    }
}
