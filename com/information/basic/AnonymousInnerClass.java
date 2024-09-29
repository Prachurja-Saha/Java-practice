package com.information.basic;

public class AnonymousInnerClass {

    int b =10; //instance

    public static void main(String[] args){

        // cannot use instance variable without object reference, cannot use static variable
        // A static variable belongs to the class
        int a = 10; //local
        int c =11;

        Employee employee  =  new Employee() { // Here is the anonymous

            @Override
            public String getName() {
                return "Amit";
            }

            @Override
            public int getSalary() {
                return 10;
            }
        };

        System.out.println(employee.getName() + "Earns salary: " + employee.getSalary());
    }


}
