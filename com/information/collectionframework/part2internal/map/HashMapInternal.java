package com.information.collectionframework.part2internal.map;

public class HashMapInternal {

    /*
    * HASH FUNCTION generates hashcode(fixed size string of bytes typically numeric value) based on the key or input
    * (there is possibilities of same hashcode for different key, here arrayIndex = hashcode % arraySize)
    * [default size of array is 16, it will resize if the size is >= {capacity * loadFactor(by default 0.75)} which is 12]
    * Means when 12 elements inserted array will resize
    * Here This Array called bucket or HASHTABLE (Order will be depended on hashcode % arraySize)
    * we don't need to worry how hash function generates hash code
    * if hash function is generating same hashcode it's called collision, in that case we will add new node (Linked List)
    *
    * After java 8 there is update, if LinkedList size is large b/c large collision after certain threshold which is
    * 8 by default it will use binary search tree (Red black tree) <-- After java 8
    * b/c if there is large linked list due to collision, it will be difficult to search time complexity -> O(N)
    * where in RED BLACK TREE -> O(logN)
    *
    * When we insert into hashmap it will generate array index with help of hash function.
    * after that ->
    *
    * Scenario 1: If key is not object type
    * It will check the key that are already present int that index (using equals method) if present value will
    * be replaced otherwise it will insert new key and value [In String and Integer equals method override and check
    * only value]
    *
    * Scenario 2: If key is object type there is no replaced b/c every time it will insert new object, equals method
    * will return false always
    *
    * stores data in Array of Nodes
    * */

    public static void main(String[] args) {

    }
}
