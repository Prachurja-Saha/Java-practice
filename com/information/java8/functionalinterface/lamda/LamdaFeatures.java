package com.information.java8.functionalinterface.lamda;

import com.information.java8.functionalinterface.FunctionalInterface1;

public class LamdaFeatures {

    int c = 1;
    public static void main(String[] args) {

        int a = 10; // Variable declare outside the lamda is final or effectively final
        FunctionalInterface1 functionalInterface = () -> {

//            c = 2; Allowed Instnace variable in lamda function . here it is not allowed b/c of static method
            int b = 11;// local variable
            b =12;
           // a = 11; // Not Allowed to change a->final or effictvly final
            System.out.println(a);
        };
    }
}

/*
* Points ->
* Static variables can be used in both static and non-static methods.
* However, non-static (instance) variables cannot be accessed in a static context (like static methods)
* without an instance of the class.
* */

