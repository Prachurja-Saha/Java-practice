package com.information.java8.streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtraStreamMethod {

    public static void main(String[] args) {

        /*Collectors in the Stream API is primarily meant for collecting into collections like List, Map, or Set,
         not directly into primitive arrays.*/
        /* Collectors  Method*/

        //1// Counting, GroupingBy
        String name = "aabbbabcadccccddabbb";

        // Single level
        Map<Character, Long> getFrequencyOfCharacter = name.chars() // converting IntStream -> ascii Integer type
                .mapToObj(ascii -> (char) ascii) // converting ascii to character
                //// groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)
                .collect(Collectors.groupingBy(charKey -> charKey, Collectors.counting()));// return map

        System.out.println("Frequency map : "+ getFrequencyOfCharacter);

        Long sizeOfName = name.chars()
                .mapToObj(ascii -> (char) ascii)
                .collect(Collectors.counting());

        System.out.println("Size of Name : " + sizeOfName); // Size of String

        // Multilevel we can provide grouping by inside grouping by
        List<String> fruitList = List.of("apple", "apricot", "banana", "blueberry", "pear", "peach", "plum");
        Map<Character, Map<Integer, List<String>>> multiLevelGrouping
                = fruitList.stream() .collect(Collectors.groupingBy( s -> s.charAt(0),// First-level grouping by first character
                Collectors.groupingBy(String::length)));

        System.out.println("Multi level Grouping :" + multiLevelGrouping);


        //2//  toList(), toSet(), toMap()
        List<Integer> integerList = List.of(1,21,23,14,234,56);
        Set<Integer> integerSet = integerList.stream().collect(Collectors.toSet());
        System.out.println("Set : "+integerSet);
        System.out.println(integerList.stream().collect(Collectors.toMap(key -> key ,
                key -> "this is the key" + key)));


        //3// joining()
        // Type -> static Collector<CharSequence, ?, String> joining()
        // Here T is CharSequence(String,StringBuilder,StringBuffer) and R -> return type String

        List<String> stringList = List.of("1","2","3","4");

        // Here T is String
        System.out.println("String List Joinned" + stringList.stream().collect(Collectors.joining()));

        // Delimiter -> character/symbol that separates Data
        // Prefix -> initial character/symbol
        // Suffix -> end character/symbol
        System.out.println("Using delimiter, prefix, and suffix: " +
                stringList.stream().collect(Collectors.joining(",","[","]")));

        //4//partitioningBy()
        // Partitions the elements into two groups (true/false) based on a predicate. It returns a Map<Boolean, List<T>>.
        Map<Boolean, List<Integer>> partitioned = Stream.of(1, 2, 3, 4)
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Partitioned : "+partitioned);

        //5// summarizingInt() / summarizingLong() / summarizingDouble()
        // Provide overall stats -> count, sum, min, average, and max for primitive types.
        IntSummaryStatistics stats = Stream.of(1, 2, 3)
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Stats :" + stats);

        //6// Reducing
        //Performs a reduction on the elements of the stream, combining them into a single result using an accumulator
        // function. Here 1+2 -> 3 +3 -> 6
        Optional<Integer> sum = Stream.of(1, 2, 3)
                .collect(Collectors.reducing((a, b) -> a + b));
        System.out.println(sum);



    }
}
