package com.information.collectionframework.part2internal.set;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

// Similar to hashmap key will be element and value will be dummy ad constant only key will be there

/**
 * Hash Set Internally uses a HashMap (values are dummy).
 * When you call add(element):
 * It calls element.hashCode() → finds a bucket.
 * If bucket is empty → adds it.
 * If something already exists → calls equals() to check for duplicate. check the value if it is wrapper (b/c wrapper
 *                                                    overrides equals method) for other obj it will check address value
 * If equals() returns true, it does not add (duplicate prevented).
 * <p>
 * Primitive Not allowed if added it will auto boxed
 */
public class HashSetInternal {

    /*
    * Before adding an element, the HashSet checks if key(for set its value) is already present by comparing the
    * hash value and using then equals() method. If an element with the same hash value and equal content exists,
    * the new element is not added.
    *
    * Not thread Safe
    *
    * */
    public static void main(String[] args) {

        // ConcurrentSkipListMap -> Thread Safe
        // ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<>();
    }
}
/*
  Initialization: When a HashSet is created, a HashMap is created internally to store the data.

  Adding an element: When an element is added using the add() method, the following happens:
  1. The hashCode() method of the element is called to get its hash code.
  2. This hash code is used to determine the "bucket" or position in the internal HashMap where the element should be stored.
  3. The add() method internally calls the put() method of the HashMap with the element as the key and a dummy value
     (like the PRESENT constant).
  4. Ensuring uniqueness: Because HashMap keys must be unique, this process automatically prevents duplicate elements
     from being added to the HashSet. If you try to add an element that is already present, the put() method will simply
     overwrite the existing value (which is the same dummy value), and the HashSet will not change.
*/