package com.practice;


public class GenericTest {

    public String name;
    public int id;

    public <T> void print(T[] array){ // T here is a method-level generic type parameter
        for(T i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public <T> T[] returnArray(T[] array){ // T here is a method-level generic type parameter

        return array;
    }

    public static void main(String[] args){

        GenericTest g = new GenericTest();

        Integer[] arr = {1,2,3,4};
        Object[] arr2 = {"a",10,true};

        g.print(arr);
        g.print(arr2);

        Integer[] arrr = g.returnArray(arr);
        for(Integer i : arrr){
            System.out.print(i + " ");
        }

    }

}
