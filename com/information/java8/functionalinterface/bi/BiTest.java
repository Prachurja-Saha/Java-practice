package com.information.java8.functionalinterface.bi;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class BiTest {

    public static void main(String[] args){

        // Bi Predicate
        // BiPredicate<T, U>
        // abstract method -> boolean test(T t, U u);
        BiPredicate<Integer, String> testStringSize = (x,y) -> y.length()<x;
        System.out.println(testStringSize.test(10,"Amit")); // Amit length is less than 10
        System.out.println(testStringSize.test(10,"Akash Kumar Singh")); // false

        // Bi Function
        // BiFunction<T, U, R>
        // abstract method -> R apply(T t, U u);  R is return type
        BiFunction<String, String, Integer> finalLengthOf2String = (x,y) -> (x+y).length();

        System.out.println(finalLengthOf2String.apply("Amit", "Akash"));

        // Bi Consumer
        // BiConsumer<T, U>
        // void accept(T t, U u);
        BiConsumer<Integer, Integer> sumOf2No = (x,y) -> System.out.println(x+y);
        BiConsumer<Integer, Integer> multiplicationOf2No = (x,y) -> System.out.println(x*y);
        sumOf2No.accept(10,20);

        System.out.println("Using and then (bi consumer)");
        sumOf2No.andThen(multiplicationOf2No).accept(10,20);

        System.out.println("Using and then (bi function)");
        Function<Integer, Integer> square = (y) -> y*y;
        System.out.println(finalLengthOf2String.andThen(square).apply("ABC", "EF"));
        // Here finalLengthOf2String will return concatenate of 2 String length  and then the square of that no.
        // ABC+EF -> ABCEF = size 5 -> 5*5 -> 25
    }
}
