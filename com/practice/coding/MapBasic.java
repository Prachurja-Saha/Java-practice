package com.practice.coding;

import java.util.Map;
import java.util.Set;

public class MapBasic {

    public static void main(String[] args) {

        Map<Integer,String> stringMap = Map.of(1,"A",2,"B",3,"C");

        stringMap.entrySet().stream().forEach(i -> System.out.println("Key:"+i.getKey()+" Value"+i.getValue()));

        Set<Map.Entry<Integer,String>> entrySet =  stringMap.entrySet();
        System.out.println(entrySet);
    }
}
