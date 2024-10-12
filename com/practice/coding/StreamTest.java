package com.practice.coding;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args){

        /* I will do this later */ // Finding max no. in contiguous sub array-> sliding window

//        List<Integer> integerList = List.of(1,10,-1,9,7,27,11,0,-12,-8,100,2,15);
//
//        Scanner sc = new Scanner(System.in);
//
//        int sizeOfSubArray = sc.nextInt();
//        List<Integer> subArrayList = new ArrayList<>(sizeOfSubArray);
//
//        for(int i=0; i<sizeOfSubArray; i++){
//            subArrayList.add(integerList.get(i));
//        }




//        List<String> listOfNcc = List.of("01", "02", "03");
//        List<String> listOfValue = new ArrayList<>(); listOfValue.add("a");listOfValue.add(null);listOfValue.add("a");
//
//        // This assumes both lists are of the same size & Missed Ncc
//        List<String> missingNcc = IntStream.range(0, listOfValue.size())
//                .filter(i ->  null == listOfValue.get(i))
//                .mapToObj(listOfNcc::get) // Map to the corresponding NCC
//                .toList(); // Collect the results into a list
//        System.out.println(missingNcc);


//       String x = "aabbcca";
//
//       // x.chars() -> IntStream -> ASCII code
//       Map<Object, List<Character>> c = x.chars() //Ascii of type Integer that's why IntStream
//               .mapToObj(ascii -> (char)ascii) // Converting ascii -> Character
//               //(Function<? super T, ? extends K> classifier)
//               .collect(Collectors.groupingBy(ch -> ch)); // grouping by character
//
//
//        // groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)
//        System.out.println(x.chars()
//                .mapToObj(ascii -> (char)ascii)
//                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting())));
//
//
//        System.out.println(c);

       /*Incomplete*/ // Fibonacci
//        int b = 1;
//        int a = 1;
//        int c = 0;

//        IntStream.range(b,10).peek(i -> System.out.println(i)).map( i -> {
//
//
//            return  i+b;
//        });

        // Print the max Count
        System.out.println(List.of(1,2,3,4,5,4,3,1,1,2,1,1).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()));



    }
}
