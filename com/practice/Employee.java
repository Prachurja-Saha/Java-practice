package com.practice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private int age;
    private int id;
    private LocalDate date;

    public Employee(String name, int age, int id, LocalDate date) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // VVVIMP
/*
    By default, every class in Java inherits the toString() method from the Object class,
     which returns a string in the format ClassName@HashCode, as you're seeing.
     To print meaningful information about the Employee objects,
     you need to override the toString() method in your Employee class.
    When you print a List<Integer>,
     it prints correctly because the Integer class already overrides the toString() method.
     All Java wrapper classes like Integer, Double, Boolean, etc., override the toString() method to provide
     meaningful output. For instance, Integer’s toString() returns the string representation of the integer
     value.
     Override toString() method to display meaningful information*/
    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", id=" + id + ", date=" + date + '}';
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Amit", 22, 1, LocalDate.of(2000, 1, 21)));
        employees.add(new Employee("Akash", 22, 4, LocalDate.of(2000, 1, 22)));
        employees.add(new Employee("Rohit", 21, 2, LocalDate.of(2001, 3, 21)));
        employees.add(new Employee("Nitesh", 32, 11, LocalDate.of(1988, 6, 21)));

        // CompareTo is method which present in comparable interface
        employees.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));

        for (Employee employee : employees) {
            System.out.println(employee); // This means employee.toString()
        }

        employees.add(new Employee("Rony", 32, 9, LocalDate.of(1988, 6, 21)));
        employees.add(new Employee("shan", 32, 91, LocalDate.of(1988, 6, 21)));
        // checking if date same then sort by id thing
        employees.sort((o1, o2) -> {
            if(o1.getDate().equals(o2.getDate())){
                return  o2.getId().compareTo(o1.getId());
            } else {
               return o2.getDate().compareTo(o1.getDate());
            }
        });

        System.out.println("After sort if date same then sort by id");
        for (Employee employee : employees) {
            System.out.println(employee); // This means employee.toString()
        }
    }
}
