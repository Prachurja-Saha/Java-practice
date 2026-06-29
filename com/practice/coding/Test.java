package com.practice.coding;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> number = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(number);

        number.stream().filter(i -> i%2 == 0).forEach(System.out::println);

        //number.stream().m

    }
}
