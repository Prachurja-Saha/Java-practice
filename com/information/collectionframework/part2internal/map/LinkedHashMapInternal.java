package com.information.collectionframework.part2internal.map;

import java.util.LinkedHashMap;

public class LinkedHashMapInternal {

    public static void main(String[] args) {

        // extends hashmap
        // Used double linked list internally and hashmap
        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();

        /*
        * By setting access order = true we can activate least recently used (LRU) // Alternative of caching
        * by default access order is false
        * Least Recently Used : This will change the list according to the element which is not used recently
        * i.e. element1 is not used recent so it will be at top of the data structure
        * */

    }
}
