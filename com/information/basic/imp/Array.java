package com.information.basic.imp;

import java.util.Iterator;
import java.util.Scanner;

// Object
public class Array {

    public static void main(String[] args) {

        /* Difference b/w Array and Collection */

        // Diff1
        int[] a = {1,2,3,4}; // Not part of collection can store primitive and non-primitive
        // But collection framework only store non primitive data

        /* Very imp concept */
        int[] primitiveArray = {10,20,30}; // primitive array
        // For arrays of primitive types (like int, char, double, etc.), each element of the array directly contains
        // the value, not a reference. Here primitiveArray[0] directly contains the value 10.

        String[] objectArray = {"Abc", "Xyz"}; // object array
        // For arrays of objects, each element of the array holds a reference to the object, not the object itself.
        // objectArray[0] contains a reference to the String object "Abc".
        // objectArray is array that contains references
        /* Above info is very imp */

        int[] a2 = new int[10];

        // If we do list.add(1) // here 1 is int type (Auto boxing-> converting int to Integer)
        // not int type


        //Diff2
        // Array size is fix
        // Collection framework size can be increase and decrease the size of collection at runtime

        /* Dynaimc Array*/
        int[] dynamicArray;
        Scanner sc = new Scanner(System.in);
        dynamicArray = (sc.hasNext())? new int[sc.nextInt()] : new int[5]; // 5 is default size
        for(int i = 0; i < dynamicArray.length ; i++){
            dynamicArray[i] = (int)Math.pow(i,i);
        }
        System.out.println(" Address value : "+dynamicArray);
        for(int i=0; i<dynamicArray.length; i++){
            System.out.println(dynamicArray[i]);
        }


        Integer[] i = {1,2,3};
        System.out.println(i); // address value of array (default toString() representation)

        //i[1] is a reference to the Integer object at index 1.
        System.out.println(i[1]); // Here it should print the address value b/c Integer is obj type
        // but here toString() is override, check below Integer class
        /*
        public final class Integer extends Number implements Comparable<Integer> {
            private final int value;

            public Integer(int value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return Integer.toString(value);
            }

            public static String toString(int i) {
                return String.valueOf(i);
                }
            }
        */

    }
}
