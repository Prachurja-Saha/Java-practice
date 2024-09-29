package com.information.collection.wrapperclass;

public class WrapperClassTest {

    public static void main(String[] args){

        int num = 7; // primitive
//        Integer num1 = new Integer(num); // -> Deprecated -> called Boxing
        Integer num1 = num; // AutoBoxing (changing primitive -> wrapper)

        Integer num2 = num1.intValue(); // Unboxing
        num2 = num1; //AutoUnboxing (changing wrapper to primitive)

        String s1 = "12";
        int x = Integer.parseInt(s1);
        System.out.println(x*x);

        // ADVANTAGES
        // INTEGER -> provides multiple classes that we can use for operation i.e parseInt,...etc
        // int -> performance improvement
    }
}
