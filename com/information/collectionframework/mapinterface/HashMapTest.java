package com.information.collectionframework.mapinterface;

// HashMap implements Map Interface

import java.util.*;
import java.util.stream.Collectors;

class User {

    public String name;
    public int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

/**
 * Allows Null Keys  and does not have duplicate keys
 * DOES NOT MAINTAIN INSERTION ORDER LIKE HASHSET
 */
public class HashMapTest {

    public static void main(String[] args) {

        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> newHashMap = Map.of(4, "Nikhil", 7, "Purna");

        hashMap.put(1, "Amit");
        hashMap.put(1, "Akash"); // Override ( before key 1 value Amit after key 1 value Akash)
        hashMap.put(2, "Akash");
        hashMap.put(3, "Rohit");
        hashMap.put(6, null);
        hashMap.put(4, null);

        // Methods
        hashMap.get("Amit"); // only get values not key so we need Map.Entry
        hashMap.putAll(newHashMap);
        hashMap.putIfAbsent(8, "Ram");


        /* Overall difference computeIfPresent, computeIfAbsent, Merge
         *
         * 1) computeIfAbsent() -> only works if key is not present and if Function interface return  non-null
         *    than it will insert key and value. value will be the return statement of Function interface.
         *    ad if it returns null than it will not insert new key.
         *    Function<K, V>
         *
         * 2) computeIfPresent() -> update the value if key is present.
         *    Removes the entry if the function returns null.
         *    BiFunction<K, V, V>
         *
         * 3) Merge() -> Merges the existing value with a new value, or inserts if absent.
         *    Removes the entry if the merge function returns null.
         *    BiFunction<V, V, V>
         *
         * */

        //ComputeIf - used Function interface [V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)]
        // Same work for Bi Functional interface with 2 parameters
        //                    -> (K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        hashMap.computeIfPresent(2, (k, v) -> "Updated Name");
        hashMap.computeIfPresent(6, (k, v) -> v + "Empty Result"); // this will not work b/c key-6 value is null
        hashMap.computeIfAbsent(4, (k) -> {
            if (k < 10) return "Empty Result";
            else return "keySize is greater than 10";
        }); // it will work b/c value is null


        System.out.println(hashMap);


        // contains
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.containsValue("Ram"));

        // forEach using bi consumer
        //void forEach(BiConsumer<? super K,? super V> action) consumer only receives arguments
        hashMap.forEach((k, v) -> System.out.println("Key is->" + k + "value is" + v));



        /* MERGE */
        System.out.println("Merge Method");
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 5);
        map.put("Banana", 10);

        // Merging a new value with an existing key
        map.merge("Apple", 3, (oldValue, newValue) -> oldValue + newValue); // Adds 5 + 3
        System.out.println("Apple: " + map.get("Apple")); // Output: 8

        // Merging with a key not present, so the value is simply added
        map.merge("Cherry", 15, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("Cherry: " + map.get("Cherry")); // Output: 15

        // Merging a value where the remapping function returns null, removing the entry
        map.merge("Banana", 5, (oldValue, newValue) -> null); // Removes "Banana" from the map
        System.out.println("Banana: " + map.get("Banana")); // Output: null

        // Final map contents
        System.out.println("Map contents: " + map); // Output: {Apple=8, Cherry=15}


        /*
         * Map.Entry Interface
         * Map.Entry is needed whenever you're working with a Map and want to access
         * both the key and the value simultaneously.
         */

        Map<Integer, String> mapEntry = new HashMap<>();
        mapEntry.put(100, "Amit");
        mapEntry.put(101, "Vijay");
        mapEntry.put(102, "Rahul");

        Map<Integer, User> mapUser = new HashMap<>();
        mapUser.put(100, new User("Amit", 1));
        mapUser.put(101, new User("Vijay", 2));
        mapUser.put(102, new User("Rahul", 0));

        //Elements can traverse in any order
        for (Map.Entry m : mapEntry.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        // List<Map.Entry<K,V>> b/c HashMap and Set will not maintain Order alternative is LinkedHashMap
        System.out.println(mapEntry.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()));

        // Using LinkedHashMap

        LinkedHashMap<Integer, User> sortedLinkedHashMap = mapUser.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.name.compareTo(v1.name)))
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue(),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("sorted map :" + sortedLinkedHashMap);

        // It is not collection so only one value can be added
        Map.Entry<Integer,String> newSetOfEntry = new AbstractMap.SimpleEntry<>(1,"Amit");
        // so we need both map-> creation and map.entry-> operation(get key , get value, usage of stream api)

        Set<Map.Entry<Integer, String>> setOfMapEntry = mapEntry.entrySet();
        setOfMapEntry.add(newSetOfEntry);

    }

}

