package com.information.basic;

public class DataTypeAndVariables {

  // Variables
  /*
    3 types of variables
    local : A variable defined within a block, method, or constructor is referred to as a local variable.
            Local variable is created at the time of declaration and destroyed when the function completes its execution.

    Instance: Instance variables are known as non-static variables and are declared in a class outside of any method,
    constructor, or block. Instance variables are created when an object is instantiated and destroyed when the object
    is destroyed.

     Primitive data types (Size Fix)- includes byte , short , int , long , float , double , boolean and char.
     They’re stored directly on the stack This is the only part in java which is not object type so java is not
     fully 100% OOP this will not extend object class

     Non-primitive data types - such as String , Arrays and Classes(all object type)
     Non-Primitive -> Size not fix. -> Object type stores in heap memory String, Classes, Interfaces, and Arrays.

     ### -> == compares object reference only allowed for primitive and String literal
*/

    // how memory store
    /*
       1. [Class loading]:  when jvm loads the class -> Static variables and class metadata stored in Method area
                            then reference variable stored in stack and object stored in Heap. If object instance variables
                            than aga
    */

    public  static  void main(String[] args){

        int x = 2;
        int largeNumber = 10_1_11121; // we can provide underscore it will act as ` , ` for large numver
        double y = 5; // 5.0
        String s = "abc";
        String m = ""+1+2+""; // ans is 12 not 3 we have to provide ()
        System.out.println(m);
        m = ""+(1+2)+"";
        System.out.println(m); // now 3
        // <variable type> <variable name> = <object type> => here right side will evaluate first and assign to left side

        switch (x){
            case 1,2,3,4:
                System.out.println("found");
                break;

            case 6,7:
                System.out.println("-");
                break;
            default:
                System.out.println('l');
                break;
        }

    }
}
