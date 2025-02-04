package com.information.collectionframework.part2internal.set;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

// Similar to hashmap key will be element and value will be dummy ad constant only key will be there
public class HashSetInternal {

    /*
    * Before adding an element, the HashSet checks if it is already present by comparing the hash value and using the
    * equals() method. If an element with the same hash value and equal content exists, the new element is not added.
    *
    * Not thread Safe
    *
    * */
    public static void main(String[] args) {

        // ConcurrentSkipListMap -> Thread Safe
        // ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<>();
    }
}
