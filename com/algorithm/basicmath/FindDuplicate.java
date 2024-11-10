package com.algorithm.basicmath;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindDuplicate {

    public static void main(String[] args) {

        /* Find Duplicate */
        List<Integer> integerList = List.of(1, 2, 1, 2, 3, 4, 4, 5, 0, 10, 0, 1, 3, 11);
        Set<Integer> integerSet = new HashSet<>();


        // Ans
        System.out.println(integerList.stream()
                .filter(i -> !integerSet.add(i))
                .collect(Collectors.toSet()));

        // Alternative Ans
        System.out.println(
                integerList.stream()
                        .collect(Collectors.groupingBy(type -> type, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(entrySet -> entrySet.getValue() > 1)
                        .map(Map.Entry::getKey) // -> .map(entrySet -> entrySet.getKey())
                        .collect(Collectors.toSet())
        );

        /* Palindrome */

        String s = "abcscba";

        /*
        The issue you're encountering with the peek method is due to the fact that stream operations like filter
        and peek are lazy. This means that the stream will not perform any action until a terminal operation
        (such as forEach, collect, or count) is invoked.
        In your code, peek won't print anything because there is no terminal operation that triggers the
        stream processing.*/

        if(IntStream.range(0,(s.length()-1)/2)
                .anyMatch(i -> s.charAt(i) != s.charAt(s.length()-1-i)))
            System.out.println("Not Palindrome");
        else
            System.out.println("Palindrome");


        /* Sum and Average of all*/

        System.out.println(integerList.stream().collect(Collectors.summarizingInt(i -> i)).getSum());
        System.out.println(integerList.stream().collect(Collectors.summarizingInt(i -> i)).getAverage());

                         /*Very Important*/
        // Alternative ** .sum(), .average() -> used only for primitive type
        int sum = integerList.stream()
                .mapToInt(Integer::intValue)  // Convert Integer to int
                .sum();

        Double average = integerList.stream()
                .mapToInt(Integer::intValue)  // Convert Integer to int
                .average() // Optional Double
                .getAsDouble(); // converting Optional Double to double

        System.out.println("Sum : "+sum +", Average : " + average);



        /* Reverse a Integer */
        int simpleInt = 102903;

        String reversedInteger = Stream.iterate(simpleInt, i-> i> 0, i->i/10)
                .map(i -> i%10)
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Reversed Integer: "+reversedInteger);

        /* Reverse a Array*/
        int[] array = {1,2,3};

        System.out.println(Arrays.toString(
                IntStream.range(0, array.length)
                        .map(i -> array[array.length - 1 - i])
                        .toArray()));


        /*Anagram*/       //Not working
//        String a = "abss";
//        String b = "ssba";
//
//
//        IntStream.range(0,a.length()).anyMatch(i -> {
//            if(b.contains(Character.toUpperCase(a.charAt(i))+"")) {
//                b.replace(a.charAt(i)+"","");
//                return true;
//            }
//            return false;
//        });

        Scanner sc=new Scanner(System.in);
        String A= sc.nextLine(); //sc.next();

        boolean result = Stream.iterate(0, i-> i<=(A.length()-1)/2 ,i -> i+1)
                .allMatch(i -> A.charAt(i) == A.charAt(A.length()-1-i));

        System.out.println(result);

    }

}
