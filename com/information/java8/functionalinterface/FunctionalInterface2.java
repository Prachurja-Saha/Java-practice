package com.information.java8.functionalinterface;

public interface FunctionalInterface2 {

    void add();

    default void print(){
        System.out.println("This is FunctionalInterface2");
    }

    static void test() {
        System.out.println("static test f2");
    }

    static void main(String[] args) {
        System.out.println("Hello from interface2");
    }
}
