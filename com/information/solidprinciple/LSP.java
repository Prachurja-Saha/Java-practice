package com.information.solidprinciple;


/* Subclass should extend the capability of parent class should not narrow it down*/
public class LSP {

    /*
    * If class B is a subclass of class A, then objects of class A should be able to be replaced with objects
    * of class B without altering the correctness of the program.
    * */

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird = new Ostrich(); // Object is replaced but it will break the correctness of program or narrowing it down

        Shape shape = new Shape();
        shape = new Rectangle(10, 10); // following LSP, it won't break correctness of program

    }
}

// Violating or not following lsp
class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}

/*
* Ostrich is a subclass of Bird, but an Ostrich cannot fly. If we try to substitute a Bird object with an Ostrich
* object, it will break the behavior of our program. Here, Ostrich class violates the LSP because it does not fulfill
* the contract of the Bird class, which states that all birds can fly.
* */


// Following LSP

class Shape {
    public double getArea() {
        return 0;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

/*
* Square is a subclass of Rectangle, which in turn is a subclass of Shape. This follows the LSP because instances of
*  can replace instances of Rectangle and Shape without causing any issues. Both Square and Rectangle classes provide a
*  getArea method, which adheres to the contract provided by the Shape class.
* */