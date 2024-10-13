package com.information.basic;

class A{
    static {
        System.out.println("static block A");
    }
}
public class StaticClassTest { // static class should be Inner class or nested class
    // like static method no instance member can be accessed only static member

    static int x = 100;

    static private class InnerClass {

        void display(){
            System.out.println("static inner class");
        }
        static void staticDisplay(){
            System.out.println("static inner class" + x);
        }

    }

    static {
        System.out.println("static block");
    }

    /*
    * Since the static nested class doesn’t depend on an instance of the outer class,
    * you can instantiate it directly using the outer class name without creating an outer class object.
    *
    * OuterClass.StaticNestedClass nestedObj = new OuterClass.StaticNestedClass();
    * Here we are creating static class obj.
    */
    public static void main(String[] args){

        // Here we did not create outer class obj
        InnerClass innerClass = new InnerClass(); // if class is not private
        InnerClass.staticDisplay();

        // if private
        StaticClassTest.InnerClass innerClass1 = new StaticClassTest.InnerClass();

        // Static member stored in method area

        // Static nested class -> at the time of definition it stored in method area but when we create instance
        // It stored in heap area
        // so question is what extra with this static class ?
        // Ans : can be accessed without a instance of its outer class

        /* when we create a object of A static block A will run First*/
        A a = new A();

    }


}
