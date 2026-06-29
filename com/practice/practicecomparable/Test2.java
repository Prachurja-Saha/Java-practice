package com.practice.practicecomparable;

public class Test2 {

    public static void main(String[] args) {

        Thread thread = new Thread (()-> System.out.println("Hello World"));
        thread.start();
    }
}
