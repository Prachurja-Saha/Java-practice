package com.information.exceptionhandling;

/**
 * C.T errors are not part of Java's Error class hierarchy
 *
 */
public class JavaExceptionHierarchy {

    /*
    * Throwable is the parent class of Java Exceptions Hierarchy,
    * and it has two child objects – Error and Exception.
    * Exceptions are further divided into Checked Exceptions and Runtime Exceptions
    * */

    // Errors
    /*
    * Are exceptional scenarios that are out of the scope of application,
    * and it’s not possible to anticipate and recover from them.
    * For example, hardware failure, Java virtual machine (JVM) crash, or out-of-memory error.
    * That’s why we have a separate hierarchy of Errors and we should not try to handle these situations.
    * Some of the common Errors are OutOfMemoryError and StackOverflowError.
    *
    **** C.T errors are not part of Java's Error class hierarchy
    * It's not the part of Java Class hierarchy, these are detected by the Java compiler
    * */

    // Checked Exceptions ---> Compile time Exception
    /*
    * Checked Exceptions are exceptional scenarios that we can anticipate in a program and try to recover
    * from it. For example, FileNotFoundException.
    * We should catch this exception and provide a useful message to the user and log it properly for
    * debugging purposes.
    * The Exception is the parent class of all Checked Exceptions. If we are throwing a Checked Exception,
    * we must catch it in the same method, or we have to propagate it to the caller using the throws keyword.
    * */

    // RunTime Exception or unchecked exception
    /*
    * We Already Know
    * */

}
