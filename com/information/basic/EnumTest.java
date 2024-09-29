package com.information.basic;

// An enum type is a special data type that enables for a variable to be a set of predefined constants
public enum EnumTest {

    MERCURY (3.303e+23, 2.4397e6),
    NEPTUNE (1.024e+26, 2.4746e7);

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

}
