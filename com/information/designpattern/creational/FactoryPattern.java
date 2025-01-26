package com.information.designpattern.creational;

/**
 *  Used
 *  When a class doesn't know what subclasses will be required to create
 *  When a class wants that its subclasses specify the objects to be created.
 *  When the parent classes choose the creation of objects to its subclasses.
 */
public class FactoryPattern {

    /*
    * Factory Method Pattern says that just define an interface or abstract class for creating an object
    * but let the subclasses decide which class to instantiate.
    * In other words, subclasses are responsible to create the instance of the class.
    *
    * The Factory Method Pattern is also known as Virtual Constructor.
    * */

    private double getAreaForAllTypeOfShape(Shape shape){ // Flexible can be used for any object

        System.out.println("Area : " + shape.getArea());
        return shape.getArea();
    }

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10,10);
        Circle circle = new Circle(10);

        System.out.println("Area of rectangle is: " + rectangle.getArea());
        System.out.println("Area of circle is: " + circle.getArea());
    }
}

interface Shape{

    double getArea();
}

// Rectangle Implementation
class Rectangle implements Shape{

    private final double width;
    private final double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

// Circle Implementation
class Circle implements Shape{
    private final double radius;
    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return (double) 22 /7 * Math.pow(radius, 2);
    }
}
