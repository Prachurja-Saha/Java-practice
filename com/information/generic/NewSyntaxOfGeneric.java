package com.information.generic;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

// Multiple Bound
/* Java does not support multiple inheritance so 1 Class is allowed to extends and others should be interface*/
class Box<T extends Number & Printable> { // T should extends Number Abstract Class & Implements Printable Interface

}

class MyClass extends Number implements Printable {

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        return 0;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}

public class NewSyntaxOfGeneric {

    public static void main(String[] args){

        Box<MyClass> myClassBox = new Box<>();
    }
}
