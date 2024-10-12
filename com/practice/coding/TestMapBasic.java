package com.practice.coding;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMapBasic {
    public static void main(String[] args) {

        Set<String> setOfKey = Set.of("001","002","003","004","005");

        Map<String, String> stringMap  =  new HashMap<>();

        setOfKey.forEach((key) -> stringMap.computeIfAbsent(key, (v)-> "1")); // key is absent value will be null;
        // if Function interface return nulls it will not insert keys and value

        System.out.println(stringMap);

        // Use put() to directly insert keys with null values
        setOfKey.forEach(key -> stringMap.put(key, null));

       stringMap.forEach((k,v) -> System.out.println("key :"+k + " value :" + v));

    }
}
