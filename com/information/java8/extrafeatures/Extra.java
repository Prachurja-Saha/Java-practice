package com.information.java8.extrafeatures;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Extra {

    // VarArgs -> here we can pass multiple arguments
    // Array -> numbers -> int[]
    public int[] varArgsTest(int...numbers){ // Here I can pass any number of arguments(IMP ->consider as Array)

        return numbers;
    }

    // VarArgs -> here we can pass multiple params but not more than 1 var arguments
    public <E> List<E> getList(Boolean wantsMutable, E...elements) { // elements is Array

        List<E> immutableList = Arrays.asList(elements); // return fixed size immutable list
        // Here return type -> List<T> -> new ArrayList<>(elements); //creating array-> ArrayList(E[] array)
        /*
        private final E[] a; --> FINAL

        ArrayList(E[] array) {
            a = Objects.requireNonNull(array);
        }
        */

        // 2 method signature -> 1. new ArrayList<>(Collection<? extends E>) -> return mutable list
        //                       2. new ArrayList<>(E[] array) -> return immutable list
        List<E> mutableList = new ArrayList<>(Arrays.asList(elements)); // wrapping
        // ArrayList(Collection<? extends E> c)

        if(wantsMutable)
            return mutableList;
        else
            return immutableList;

    }



    public static void main(String[] args) {

        Extra extra = new Extra();
        extra.varArgsTest(1,2,3,4,5);
        List<Integer> list2 = extra.getList(false, 11,12);
      //  list2.add(10000); immutable
        System.out.println("checking" + list2);


        //////   var args
        List<Integer> list = extra.getList(true,1,2,3,4,5);
        list.add(1,1); // inserting 1 in index 1
        System.out.println("->"+extra.getList(true, list)); //Here E -> list<E> so return -> List<List<E>>
                              /// Response -> [[1,2...]]

        System.out.println(list);


        /////    var keyword
        // Local scope only: var can only be used for local variables inside methods,
        // constructors, or code blocks. You cannot use var for method parameters, return types,
        // or fields in a class.
        // Java 10
        var num = 10;
        var xyz = "Java 10 features";  // The type of the variable is inferred at compile time
        var varList = new ArrayList<String>();
        varList.add("1");
        // var x;  // Compilation error

        System.out.println("number ->"+ num +"xyz ->"+ xyz+ "varList" + varList  );

    }
}
