package com.information.java8.functionalinterface.function;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionInterfaceTest {

    // R apply (T t) R -> return type Function<T, R>

    public static void main(String[] args){

        List<Integer> list = List.of(1,2,3,4,5);

        Function<List<Integer>, Integer> getSum = (x) -> {
            int sum = 0;
            for(Integer y : x) {

                sum += y;
            }
            return sum;
        };

        Function<Integer, Integer> getSquare = x -> x*x;


        ToIntFunction<List<Integer>> getSumUsingToInt = (x) -> {
            int sum = 0;
            for(Integer y : x) {

                sum += y;
            }
            return sum;
        };

        System.out.println(getSum.apply(list));
        System.out.println(getSumUsingToInt.applyAsInt(list));

        //Using And then
        System.out.println("using and then");
        System.out.println(getSum.andThen(getSquare).apply(list));
        /* Very Important here getsum return Integer so in andThen method only accept <? super Integer>
        *  after getting sum -> and then we get square
        * */


        /* One more imp concept -> when we are using stream or some other case we dont need to provide
        * return type always i.e-> (T,R)->R same we can write T->R */

    }

}
