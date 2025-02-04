package com.information.exceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// Throwable is class
public class UseFulMethods {

    /*Java - 7 Features*/

    /* 1 -> Multiple Catch block*/
//    If you are catching a lot of exceptions in a single try block,
//    you will notice that the catch block code mostly consists of redundant code to log the error.
//    In Java 7, one of the features was an improved catch block where we can catch multiple exceptions
//    in a single catch block. Here is an example of the catch block with this feature:
// Code ->
    public static void main(String[] args) throws Exception {
        try {
            System.out.println(1 / 10);
        } catch (IndexOutOfBoundsException | ArithmeticException ex) { // multiple catch
            throw new Exception(ex.getMessage());
        }

    /*There are some constraints such as the exception object is final,
     and we can’t modify it inside the catch block*/


        /* 2 -> Try With Resource */
//    Try-with-resources in Java is a feature introduced in Java 7 that allows you to automatically close
//    resources like files, database connections, or sockets once you're
//    done using them. It simplifies resource management by ensuring that resources are closed properly,
//    which can help prevent resource leaks.
//    We can do this by finally but Cleaner Code: Reduces boilerplate code and makes resource management
//    easier to read and maintain
        /* We can declare multiple resources in the try block, separated by semicolons.*/
// Code ->

        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*  BufferedReader is automatically closed at the end of the try block, even if an exception occurs.
        You no longer need to manually close the reader in a finally block.*/
    }

}
