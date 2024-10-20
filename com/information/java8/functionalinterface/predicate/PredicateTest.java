package com.information.java8.functionalinterface.predicate;

import java.util.function.Predicate;

public class PredicateTest { // Predicate is a functional interface where Test(x) is abstract method return boolean



    public static void main(String[] args) {

        Predicate<Integer> predicate = (x)-> x%2==0; // implemented Test abstract method -> return x%2==0;

        System.out.println(predicate.test(10)); // here 10%2 ==0 true
        System.out.println(predicate.test(11));

        // There are many other static and default method are there in predicate
        // AND, OR, NEGATE
        Predicate<Integer> divisibleBy5 = (x) -> x%5==0; // if x divisible by 5 -> true
        Predicate<Integer> divisibleBy3 = (x) -> x%3==0; // if x divisible by 3 -> true
        Predicate<String> checkNameSize = (s) -> s.length()<10;

        Predicate<Integer> divisibleBy3And5 = divisibleBy3.and(divisibleBy5); // return true if 2 predicates true
        Predicate<Integer> divisibleBy3OR5 = divisibleBy3.or(divisibleBy5); // if any predicates true then true

       // checkNameSize.and(divisibleBy5) C.T//  divisibleBy5 Not allowed only String allowed

        System.out.println(divisibleBy3And5.test(100)); // return false not divisible by 3
        System.out.println(divisibleBy3And5.test(15));
        System.out.println(divisibleBy3OR5.test(100));

        //Negate means opposite-> !test(x)
        System.out.println(divisibleBy3And5.test(15)); // true
        System.out.println(divisibleBy3And5.negate().test(15)); // false

        //IS EQUAL LATER


    }
}
