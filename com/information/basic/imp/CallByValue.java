package com.information.basic.imp;

/**
 * <div style="color:orange">
 *      In Java, method arguments are always passed by value,
 *      This means that when you pass variables to methods, a copy of the variable is made <br>
 *      <ul style = "color: yellow"> Call by value are Two types
 *          <li style = "color: white"> Using Primitive type (float, int, char etc.)
 *              When you pass a primitive data type to a method, the method receives a copy of the value.
 *              Changes made to the parameter within the method do not affect the original value.
 *          </li>
 *          <li style = "color: white"> Using Object Reference
 *               When you pass an object to a method, the method receives a copy of the reference to the object,
 *               not the object itself. This means that while the reference itself is a copy, it points to the same
 *               object, so changes to the object’s fields within the method affect the original object.
 *          </li>
 *      </ul>
 *
 * </div>
 */
public class CallByValue {

    public static void main(String[] args){

        /* Using Primitive */
        int num = 5;
        System.out.println("Before calling method: " + num); // Output: 5
        changePrimitive(num);
        System.out.println("After calling method: " + num); // Output: 5

        /* Using Reference */
        Person person = new Person("Alice");
        // Person --pointing--> { Person object address,  name ref --> name object}
        System.out.println("Before calling method: " + person.name); // Output: Alice
        changeObject(person);
        System.out.println("After calling method: " + person.name); // Output: Bob

    }

    public static void changePrimitive(int num) {
        num = 10; // This change is not reflected outside this method
    }

    public static void changeObject(Person person) {
        // Person Copy --pointing--> { Person same object address, same name ref(b/c obj is same) ---> name object }
        person.name = "Bob"; // This change is reflected outside this method
    }
}

class Person {
    String name; Person(String name) {
        this.name = name;
    }
}
