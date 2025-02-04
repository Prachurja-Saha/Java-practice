package com.information.designpattern.creational;

/**
 * It is used when we want to make copy or clone from existing object
 */
public class PrototypeDesignPattern {

    public static void main(String[] args) {

        Employee employee = new Employee("Amit", 29);
        Employee employee2 = employee.geClone();
    }
}

// Class is responsible for cloning logic
class Employee implements Prototype<Employee> {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Employee geClone() {
        return new Employee(name, age);
    }
}

interface Prototype<E> {  // Prototype interface is created b/c of method name consistency for all class

    E geClone();
}