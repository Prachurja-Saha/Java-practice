package com.information.designpattern.creational;

/**
 * It constructs a complex object from simple objects using step-by-step approach
 *
 * It provides clear separation between the construction and representation of an object.
 * It provides better control over construction process.
 * It supports to change the internal representation of objects.
 */
public class BuilderPattern {

    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentBuilder();
        Student student = studentBuilder.age(18).name("Jack").build();
        System.out.println(student);

        Student newStudent = Student.Builder().age(18).name("Jack").build();
    }
}


class Student{
    private String name;
    private int age;

    Student(StudentBuilder builder){
        this.name = builder.getName();
        this.age = builder.getAge();
    }

   public static StudentBuilder Builder(){
        return new StudentBuilder();
    }

}

class StudentBuilder{
    private String name;
    private int age;

    // setName only changing to name (i want to replicate same like i was wroking in project (digihub)
    public StudentBuilder name(String name){
        this.name = name;
        return this;
    }
    public StudentBuilder age(int age){
        this.age = age;
        return this;
    }
    public Student build(){
        return new Student(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}