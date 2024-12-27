package com.information.basic.singelton;

// Enumeration
// An enum type is a special data type that enables for a variable to be a set of predefined constants
public enum EnumTest {

    MERCURY (3.303e+23, 2.4397e6), // Implicitly public static final
    NEPTUNE (1.024e+26, 2.4746e7);

    /*EnumTest.MERCURY, EnumTest.NEPTUNE, etc.) is a unique singleton instance of the EnumTest enum.*/

    private  double mass;   // in kilograms
    private final double radius; // in meters
    EnumTest(double mass, double radius) { // Private constructor b/c values cannot be changed
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() { // No setter method b/c values cannot be changed
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public static void main(String[] args){

        EnumTest enumTest = EnumTest.MERCURY;
        System.out.println(enumTest.getMass());
//        EnumTest enumTest1 = new EnumTest();

        if(EnumTest.MERCURY == EnumTest.NEPTUNE) {
            System.out.println("Same");
        } else {
            System.out.println("each enum is different instance");
        }

    }

    /* Each enum constant is a singleton, meaning each constant is a single, unique instance of the enum class.
     For example, EnumTest.MERCURY is always the same instance.*/

    /*Normal Class and Enum
    Key Differnce is Enum Class -> Private Constructor, Implicitly public static final constant*/

    /* While it might seem that removing the private constructor would not affect the enum's functionality
    (because you can't change the predefined constants), it’s more about enforcing a design principle and ensuring
    clarity in your code */
}
