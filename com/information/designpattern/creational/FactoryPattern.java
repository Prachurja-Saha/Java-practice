package com.information.designpattern.creational;

/**
 *  Used
 *  When a class doesn't know what subclasses will be required to create
 *  When a class wants that its subclasses specify the objects to be created.
 *  When the parent classes choose the creation of objects to its subclasses.
 */
public class FactoryPattern {

    /*
    * Factory Method Pattern says that just define an interface(here it is ShapeFactory) or abstract class for
    * creating an object but let the classes decide which class to instantiate.
    * In other words, subclasses are responsible to create the instance of the class.
    *
    * The Factory Method Pattern is also known as Virtual Constructor.
    * */


    private double getAreaForAllTypeOfShape(Shape shape){ // Flexible can be used for any object

        System.out.println("Area : " + shape.getArea());
        return shape.getArea();
    }

    public static void main(String[] args) {

        FactoryPattern factoryPattern = new FactoryPattern();

        // Using factories to create shapes
        ShapeFactory rectangleFactory = new RectangleFactory(10, 10);
        Shape rectangle = rectangleFactory.createShape();
        factoryPattern.getAreaForAllTypeOfShape(rectangle); // Output: Area: 100.0

        ShapeFactory circleFactory = new CircleFactory(10);
        Shape circle = circleFactory.createShape();
        factoryPattern.getAreaForAllTypeOfShape(circle); // Output: Area: 314.28
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

/////
// Abstract Factory
abstract class ShapeFactory {

    // Factory method
    public abstract Shape createShape();
}

// Concrete Factory for Rectangle
class RectangleFactory extends ShapeFactory {
    private final double width;
    private final double height;

    RectangleFactory(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Shape createShape() {
        return new Rectangle(width, height);
    }
}

// Concrete Factory for Circle
class CircleFactory extends ShapeFactory {
    private final double radius;

    CircleFactory(double radius) {
        this.radius = radius;
    }

    @Override
    public Shape createShape() {
        return new Circle(radius);
    }
}