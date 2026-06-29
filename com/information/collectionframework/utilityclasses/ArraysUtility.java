package com.information.collectionframework.utilityclasses;

import java.util.*;

public class ArraysUtility {

    public static void main(String[] args) {

        // To convert the elements as List
        int intArr[] = { 10, 20, 15, 22, 35 };
        System.out.println("Integer Array as List: " + Arrays.asList(intArr));

        // To compare both arrays
        int intArr2[] = { 10, 20, 15, 22, 35 };   int intArr1[] = { 10, 15, 22 };
        System.out.println("Integer Arrays on comparison: " + Arrays.equals(intArr2, intArr1));

        // Convert List to Array
        List<Integer> list = Arrays.asList(1, 2, 3);
        Integer[] array = list.toArray(new Integer[0]);

        // binary search
        int[] arr = {1, 3, 5, 8};
        int index = Arrays.binarySearch(arr, 5);

        //copy
        int[] original = {1, 2, 3};
        int[] copy = Arrays.copyOf(original, original.length);

        //Copy Range
        int[] arr3 = {10, 20, 30, 40, 50};
        int[] newArr = Arrays.copyOfRange(arr3, 1, 4);
        System.out.println(Arrays.toString(newArr)); // Output: [20, 30, 40]
    }
}
