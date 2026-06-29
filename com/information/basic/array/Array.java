package com.information.basic.array;

import java.util.Scanner;

// Object
public class Array {

    public static void main(String[] args) {

        int[] primitiveArray = {10,20,30}; // Each element of the array directly contains the value, not a reference.
        //  Here primitiveArray[0] directly contains the value 10.

        String[] objectArray = {"Abc", "Xyz"}; // Each element of the array holds a reference to the object,
        // not the object itself. objectArray[0] contains a reference to the String object "Abc".
        // objectArray is array that contains references

        int[] a2 = new int[10];

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

/*
        i  --->  [ Integer@a1 | Integer@a2 | Integer@a3 ]
        add1            (0)           (1)           (2)
*/


        //i[1] is a reference to the Integer object at index 1.
        System.out.println(i[1]); // Here it should print the address value b/c Integer is obj type
        // but here toString() is override, check below Integer class

    }
}


/*
   Array -> 1. not part of collection (arrays are object, int [] a -> a is reference (holds address value/ location)
            2. can store primitive and non-primitive (in collection only non-primitive)
               If we do list.add(1) here 1 is int type (Auto boxing-> converting int to Integer) not int type
            3. Array size is fix. Collection framework size can be increase and decrease at runtime (except dynamic array)
*/