package com.information.generic.typesofgeneric;

/**
 * 1. Generic Class: A generic class is like a regular class but uses type parameters (like <T>).
 *    It can accept one or more types, making the class reusable for different data types.
 *    Such classes are called parameterized classes.
 *   </br>
 * 2. Generic Method: A generic method is a method that can work with different data types using a type parameter.
 * It lets you write one method that works for all types, instead of repeating the same logic.
 *
 */
public class GenericClassAndGenericMethod {

    // A Generic method example
    static <T> void genericDisplay(T element)
    {
        System.out.println(element.getClass().getName()
                + " = " + element);
    }

    public static void main(String[] args)
    {
        // Calling generic method with Integer argument
        genericDisplay(11);

        // Calling generic method with String argument
        genericDisplay("test generic method");


        // instance of Integer type
        Test<Integer> iObj = new Test<Integer>(15);
        System.out.println(iObj.getObject());

        // instance of String type
        Test<String> sObj
                = new Test<String>("Test");
        System.out.println(sObj.getObject());



        MultipleGeneric <String, Integer> obj =
                new MultipleGeneric<String, Integer>("GfG", 15);

        obj.print();
    }
}


// generic default class
class Test<T> { // <--- PARAMETERIZED CLASS

    T obj;
    Test(T obj) {
        this.obj = obj;
    }
    public T getObject() { return this.obj; }
}

//Generic class with multiple type parameter
class MultipleGeneric<T, U>
{
    T obj1;  // An object of type T
    U obj2;  // An object of type U

    MultipleGeneric(T obj1, U obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void print()
    {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}