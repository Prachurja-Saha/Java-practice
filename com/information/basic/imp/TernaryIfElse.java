package com.information.basic.imp;

public class TernaryIfElse {

    public static void main(String[] args){

        /* For simple condition we used this*/
       // int result = (condition) ? value1 : value2;

        int age = 21;

        String result = (age>18) ? "Eligible for vote" : "Not eligible for vote";
        System.out.println(result);

    }
}
