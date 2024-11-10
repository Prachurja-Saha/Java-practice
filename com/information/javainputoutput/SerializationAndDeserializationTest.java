package com.information.javainputoutput;

import java.io.*;

/**
 * {@link Serializable}: It's a marker interface in Java (an interface with no methods).
 * When a class implements Serializable, it indicates that objects of that class can be
 * serialized (converted into a byte stream) and deserialized (converted back into an object).
 * This is required for serialization in Java
 */
class Student implements Serializable {
    private static final long serialVersionUID = 1L;  // recommended for version control
    String name;

    /**
     * {@link transient}: It's a keyword used to mark a variable that should not be serialized.
     * When an object is serialized, the transient variables are ignored, meaning their values
     * are not included in the byte stream. Upon deserialization,
     * transient variables will be initialized to their default values
     * (e.g., null for objects, 0 for integers).
     */
    transient int age;



    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SerializationAndDeserializationTest {

    public void serializationTest(){

        Student student = new Student("John", 25);
        try (FileOutputStream fileOut = new FileOutputStream("student.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            // Serialization: Writing object to file
            out.writeObject(student);
            System.out.println("Student object serialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void deserializationTest(){

        try (FileInputStream fileIn = new FileInputStream("student.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            // Deserialization: Reading object from file
            Student student = (Student) in.readObject();
            System.out.println("Deserialized Student: " + student.name + ", Age: " + student.age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
