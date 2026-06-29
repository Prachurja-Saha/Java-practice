package com.information.basic.imp;


import java.util.ArrayList;
import java.util.List;

/**
 * # final keyword
 * - Final Variable
 * 1) A static final variable that is not initialized at the time of declaration is known as static blank final variable.
 * It can be initialized only in static block.
 *    example->
 *    class A{
 *    static final int data;//static blank final variable
 *    static{ data=50;}
 *    public static void main(String args[]) {
 *    System.out.println(A.data);
 *     }
 *    }
 * 2) Constructor cannot be final
 * <
 * - Final Method
 *   A method declared as final cannot be overridden by subclasses. This is useful when you want to make sure that
 *   the method's implementation remains unchanged in any derived class.
 *
 * - Final Class
 *   A class declared as final cannot be subclassed. This means no other class can extend a final class.
 *   This is used to prevent inheritance, ensuring that the class's implementation cannot be altered through subclassing.
 *
 * - Final Parameters
 *   A method parameter declared as final means that within the method,
 *   the parameter cannot be reassigned to refer to a different object.
 *   public void display(final int age) {
 *   age = 25;  // Compilation error
 *   }
 */
public class FinalTest {

    public final List<Integer> list = new ArrayList<>();

    public static void main(String[] args){

        FinalTest m = new FinalTest();

        m.list.add(1); // we can add the list
        System.out.println(m.list);

        // we cannot change the obj for the list reference
//        m.list = new ArrayList<>();

        m.test();
    }

    void test(){
        final int A = 10;
        System.out.println(A);
    }
}

