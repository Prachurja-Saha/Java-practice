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

/*
*
* what i know static has only one memory?
You're right that static fields and methods in a class have only one instance in memory,
*  which is shared among all instances of that class. However, when it comes to static inner classes, it's a bit different.

Static Inner Classes:
static inner classes are nested classes that do not have a reference to an instance of their enclosing class.
They can have their own instances and do not share state like static fields/methods do.

When you create instances of a static inner class, each instance is independent. For example:
*
* public class OuterClass {
    public static class StaticInnerClass {
        private String value;

        public StaticInnerClass(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        StaticInnerClass instance1 = new StaticInnerClass("Value1");
        StaticInnerClass instance2 = new StaticInnerClass("Value2");

        System.out.println(instance1.getValue()); // Output: Value1
        System.out.println(instance2.getValue()); // Output: Value2
    }
}

* */