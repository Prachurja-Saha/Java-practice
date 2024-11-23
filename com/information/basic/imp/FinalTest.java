package com.information.basic.imp;


import java.util.ArrayList;
import java.util.List;

public class FinalTest {

    public final List<Integer> list = new ArrayList<>();

    public static void main(String[] args){

        FinalTest m = new FinalTest();

        m.list.add(1); // we can add the list
        System.out.println(m.list);

        // we cannot change the obj for the list reference
//        m.list = new ArrayList<>();
    }
}
