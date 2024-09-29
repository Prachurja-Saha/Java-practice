package com.information.java8.functionalinterface;

@FunctionalInterface
public interface FunctionalInterface1 {

    void add();

    default void print(){
        System.out.println("This is FunctionalInterface1");
    }

    static void test() {
        System.out.println("static test f1");
    }

    static void main(String[] args) {
        System.out.println("Hello from interface1");
    }
}
