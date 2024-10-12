package com.information.java8.functionalinterface.unaryandbinaryoperator;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperatorTest {

    public static void main(String[] args) {

        /* Unary */
        // extends Function<T, T> -> argument T and Return type is T
        UnaryOperator<Integer> unaryOperator = x -> x+x; // Here Arg is Integer and return also Integer

        System.out.println(unaryOperator.apply(100)); // output - 100+100

        UnaryOperator<String> stringIdentity = UnaryOperator.identity();
        /* return t -> t; here abstract method is implemented */
        String result = stringIdentity.apply("Hello");
        System.out.println(result);  // Output: Hello


        /* Binary */
        // extends BiFunction<T,T,T> arguments -> T and return type -> T
        BinaryOperator<String> binaryOperator = (x,y) -> x+y;

        System.out.println(binaryOperator.apply("a","b"));

    }
}
