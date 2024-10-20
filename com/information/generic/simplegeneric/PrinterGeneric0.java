package com.information.generic.simplegeneric;

import java.util.List;

public class PrinterGeneric0<T> { // can be anything -> T or <XYZ> Here T -> convention

    T show;

    // Convention -> T -> type K-> key V -> value
    public PrinterGeneric0(T show) {
        this.show = show;
    }

    public void printMessage() {
        System.out.println(this.show);
    }

    public List<T> sort (List<T> unsortedList) {// Here T should also be in the Class level

        //Not yet done implementation

        return unsortedList;
    }

    // But there is alternative where we don't need to change class to -> Class<T>
    // we can use wildcard but problem in wildcard can take any type so better we can bound by extending Number,.. etc
    // Best ytvideo -> https://www.youtube.com/@geekific

}
