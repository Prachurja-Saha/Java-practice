package com.information.exceptionhandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Java Exception handling framework is used to handle runtime errors only. keywords: throw,throws,try-catch
 * The compile-time errors have to be fixed by the developer writing the code else the program won’t execute.
 */
public class ExceptionTest {

    /*
         Important Point : Whenever there is an exception in any method it will transfer the exception to caller
                           if no appropriate handler is found. We can write custom exception handler to handle
                           the exception otherwise it will transfer the exception to caller method.
    *    Method and if we don't handle that exception then it will reach to main method from there JVM will handle
    *    that exception
    */

    /* Stack Trace */
    public static void level1() {
        level2();             // same here also exception
    }

    public static void level2() {
        level3();               // then here also exception
    }

    public static void level3() {
        System.out.println(10 / 0); // should throw arithmetic exception
    }

    public static void main(String[] args) {

        /* Multiple Catch Block Parent Exception class should be after child exception class*/
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);

        } catch (ArithmeticException a) {
            System.out.println("Imaginary number");
        } catch (Exception e) {
            System.out.println("Unknown Exception");
        }

        /* Stack trace method called*/
        try {
            level1();
        } catch (ArithmeticException a) {
            // detail view where exception thrown in which method
            StackTraceElement[] stackTrace = a.getStackTrace();

            Arrays.stream(stackTrace).forEach(System.out::println); // detail view of method and exception
        }

        /* Checked and Unchecked Exception*/
        // Unchecked Exception -> Exception which are not checked by compile time
        // i.e Arithmetic , index out of bound, Null Pointer etc. -> exception thrown at runtime

        // Checked Exception -> Exception which are checked by compile time
        // i.e -> Java.io.fileNotFoundException


        /* Throws */
        // Informed caller method that called method can throw exception
        // Either handle or JVM will handle internally -> method2();
        try {
            method2();
        } catch (Exception e) {
            System.out.println("Handled this file not found exceptionexception");
        }


        // Generics is not allowed in exception b/c most exception occurs at runtime for generic compiler will
        // remove the type ++ -> Need to learn more Half Knowledge
        /* Custom Exception -> extends at Runtime to handle runtime exception and called the super constructor*/
    }

    /* Throws */ //VVIMP// If we use throw than also we have to use Throws to inform the method caller
    public static void method1() throws FileNotFoundException { // It means informing caller method that this method
        // could throw exception FileNotFoundException so handle it in caller method
        FileReader fileReader = new FileReader("a.txt");
    }

    public static void method2() throws FileNotFoundException { // It means informing caller method that this method
        // could throw exception FileNotFoundException so handle it in caller method
        method1();
    }
}
