package com.information.exceptionhandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Java Exception handling framework is used to handle runtime errors only. keywords: throw,throws,try-catch,finally
 * The compile-time errors have to be fixed by the developer writing the code else the program won’t execute.
 */
public class ExceptionTest {

    /**
     * Important Point : Whenever there is an exception in any method it will transfer the exception to caller
     * if no appropriate handler is found. We can write custom exception handler to handle
     * the exception otherwise it will transfer the exception to caller method.
     * Method and if we don't handle that exception then it will reach to main method from there JVM will handle
     * that exception
     * <p>
     * Checked and Unchecked Exception :
     * Unchecked Exception -> Exception which are not checked by compile time
     * i.e. Arithmetic , index out of bound, Null Pointer etc. -> exception thrown at runtime
     * <p>
     * Checked Exception -> Exception which are checked by compile time
     * i.e -> Java.io.fileNotFoundException
     */


    public static void main(String[] args) {

        //1
        testStacktrace();

        //2
        testTryCatchFinally();

        //3
        throwThrows();

        // Generics is not allowed in exception b/c most exception occurs at runtime for generic compiler will
        // remove the type ++ -> Need to learn more Half Knowledge
        /* Custom Exception -> extends at Runtime to handle runtime exception and called the super constructor*/
    }


    /*  Stack Trace  Test */
    public static void level1() {
        level2();
    }   // same here also exception

    public static void level2() {
        level3();
    }   // then here also exception

    public static void level3() {
        System.out.println(10 / 0);
    } // should throw arithmetic exception

    public static void testStacktrace() {

        /* Stack trace method called */ // pass the exception to caller method
        try {
            level1();
        } catch (ArithmeticException a) {

            // detail view where exception thrown in which method
            StackTraceElement[] stackTrace = a.getStackTrace();

            Arrays.stream(stackTrace).forEach(System.out::println); // detail view of method and exception
        }
    }

    /* Try catch Finally */
    /**
     * Internal Working of try-catch Block:
     * JVM executes code inside the try block.
     * If an exception occurs, remaining try code is skipped and JVM searches for a matching catch block.
     * If found, the catch block executes.
     * Control then moves to the finally block (if present).
     * If no matching catch is found, the exception is handled by JVM’s default handler.
     * The finally block always executes, whether an exception occurs or not.
     * Note: When an exception occurs and is not handled, the program terminates abruptly and the code after it,
     * will never execute.
     */
    public static void testTryCatchFinally() {

        /* Multiple Catch Block Parent Exception class should be after child exception class */
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);

        } catch (ArithmeticException a) {
            System.out.println("Imaginary number"); // output : Imaginary number
            // if I throw here any exception than it will go to next catch block
            // i.e throw RuntimeException();
        } catch (Exception e) {
            System.out.println("Unknown Exception"); // this will not print
        } finally {

            /* The finally block always executed whether an exception is thrown or not.
            The finally is used for closing resources like db connections, open files and network connections,
            It is used after a try-catch block to execute code that must run.*/
            System.out.println("Finally");
            // alternative approach is try with resource
        }

    }

    /* throw and throws */
    /**
     * 1. throw: Used to explicitly throw a single exception <br>
     * 2. throws: Declares exceptions that a method might throw, informing the caller to handle them.
     * It is mainly used with checked exceptions (explained below). If a method calls another method that
     * throws a checked exception, and it doesn’t catch it, it must declare that exception in its throws'
     * clause. Either handle or JVM will handle internally -> method2();
     * V.I -> Even without throws method exception will pass the caller method if we do not handle it or we rethrow with
     * some custom or any exception i.e. -> throw new CustomException("Test");
     * In Springboot there is different case there we have different way to handle exception
     *  @RestControllerAdvice -> These annotations mark a class as a global handler for exceptions across multiple
     *                           controllers. class level
     *  @ExceptionHandler -> handler which handle any specific exception, method level.
     *
     *  @RestControllerAdvice
     * public class GlobalExceptionHandler {
     *
     *     @ExceptionHandler(NoSuchElementException.class)
     *     public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
     *         return new ResponseEntity<>("Resource not found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
     *     }
     *
     *     @ExceptionHandler(Exception.class)
     *     public ResponseEntity<String> handleGenericException(Exception ex) {
     *         return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
     *     }
     * }
     */
    public static void throwThrows() {

        try {
            method2();
        } catch (Exception e) {
            System.out.println("Handled this file not found exceptionexception");
        }
    }


    //VVIMP// If we throw exception than we can inform caller method using Throws to handle it properly
    public static void method1() throws FileNotFoundException { // It means informing caller method that this method
        // could throw exception FileNotFoundException so handle it in caller method
        FileReader fileReader = new FileReader("a.txt");
    }

    public static void method2() throws FileNotFoundException {
        method1();
    }

}
