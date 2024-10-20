package com.information.java8.functionalinterface.methodandconstructorreference;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Method Reference Used mainly -> Consumer, Supplier, Runnable Interface, Function etc
 */
public class MethodAndConstructorReferenceTest {

    public void print(int x) {

        System.out.println(x);
    }

    public int square(int x) {

        return x * x;
    }

    public static void main(String[] args) {

        Set<Integer> integerSet = new HashSet<>();
        MethodAndConstructorReferenceTest methodAndConstructorReferenceTest = new MethodAndConstructorReferenceTest();

        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);

        // Using normal consumer
        integerSet.forEach(x -> System.out.println(x));

        // Using method reference
        integerSet.forEach(methodAndConstructorReferenceTest::print);

        System.out.println("Remove Even No.");
        integerSet.removeIf(x -> x % 2 == 0); // remove even number;
        System.out.println(integerSet);

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        list.replaceAll(x -> x * x);
        System.out.println("square of list" + list);

        list.replaceAll(methodAndConstructorReferenceTest::square); // Method Reference
        System.out.println("Again square of list" + list);

        /* Types */

        //1// Static method reference
/* *        Input Type Mismatch:

        The Function<Integer, Double> interface expects an Integer as input.
        The Math.sqrt(double a) method expects a double as input.
        Auto-Unboxing:

        When you pass an Integer to the Function<Integer, Double>, Java auto-unboxes the Integer to its primitive int.
        Since the Math.sqrt method can accept double, Java automatically converts int to double (widening conversion).
        Return Type Match:

        The Math.sqrt method returns a double.
        The Function<Integer, Double> expects a Double as its return type.
        Java auto-boxes the double result into a Double to satisfy the return type of the Function.*/
        Function<Integer, Double> sqrt = Math::sqrt;

        //2// Reference to an instance method of a particular object
        String str = "Hello";
        Supplier<Integer> stringLength = str::length;

        //3// Sort list of strings by natural order using instance method reference
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.sort(String::compareToIgnoreCase);
        // sort accepts Comparator and abstract method of Comparator is compare (return type is int)
        // here compareToignorecase return type is int
        // arguments for compare method is 2 but provide 1 in comareToIgnoreCase reason below
        // reason -> Implicitly Takes Two Arguments: same as Comparing in that case 1st arguments will be object

        //4//


        /* Constructor refernce  -> ClassName::new */
        // Constructor reference
        Supplier<List<String>> listSupplier = ArrayList::new;

        // Lambda
        Function<String, Integer> stringToLength1 = strr -> strr.length();

        // Method Reference (equivalent to above lambda)
        Function<String, Integer> stringToLength2 = String::length;

        stringToLength2.apply("aa");
    }
}
