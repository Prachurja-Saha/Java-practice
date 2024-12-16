package com.practice.coding;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapBasic {

    public static void main(String[] args) {

        Map<Integer,String> stringMap = Map.of(1,"A",2,"B",3,"C");

        stringMap.entrySet().stream().forEach(i -> System.out.println("Key:"+i.getKey()+" Value"+i.getValue()));

        Set<Map.Entry<Integer,String>> entrySet =  stringMap.entrySet();
        System.out.println(entrySet);

        // List
        List<Integer> integerList = new ArrayList<>(List.of(2,2,1,4,4,4,3,55,12));
        integerList.sort(Integer::compareTo);
        System.out.println("Sorted" + integerList);
        System.out.println("Reverse Sorted" + integerList.stream().sorted(Comparator.reverseOrder()).toList());
        List<Integer> l = integerList.stream().sorted(Integer::compareTo).toList();
        List<User> u = List.of(new User("N",1, LocalDate.of(2000,2,3)),
                new User("M",2, LocalDate.of(2000,12,3)),
                new User("N",3, LocalDate.of(2000,2,3)));

        System.out.println(u.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getRoll,
                Comparator.reverseOrder())).toList());

        // Function<Integer, String> --> (k) -> "a" no need (k,v) it means bi function
        System.out.println("Single level :" + integerList.stream().collect(Collectors.groupingBy(k-> k)));
        System.out.println("Test: "+integerList.stream().collect(Collectors.groupingBy(k -> k, Collectors.counting())));
//        System.out.println("Test 2:" + integerList.stream().collect(Collectors.groupingBy(k -> "Key is " + k,
//                Collectors.)));

        // Multilevel Grouping
        List<String> stringList = List.of("apple", "apricot", "banana", "blueberry", "pear", "peach", "plum");
        Map<Character, Map<Integer, List<String>>> multiLevelGrouping
                = stringList.stream() .collect(Collectors.groupingBy( s -> s.charAt(0),// First-level grouping by first character
                Collectors.groupingBy(String::length)));

        System.out.println("Multi level Grouping :" + multiLevelGrouping);

        if(integerList.stream().anyMatch(i -> i==2)) System.out.println("yes");

        //integerList.

        System.out.println(l);
    }
}

