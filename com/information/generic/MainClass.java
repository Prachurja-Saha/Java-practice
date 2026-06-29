package com.information.generic;

import com.information.generic.boundtype.upperboundtypeparameter.DogGeneric1;
import com.information.generic.boundtype.upperboundtypeparameter.GermanShepard;
import com.information.generic.boundtype.upperboundtypeparameter.Husky;

import java.util.ArrayList;
import java.util.List;

/**
 * ? -> public void processList(List<?> list) {
 *     // You can read from the list but can't add specific types (other than null)
 * }
 *
 * T -> T is a type parameter you define
 */
public class MainClass {

    public static void main(String[] args) {


        PrinterGeneric0<Integer> integerPrinter
                = new PrinterGeneric0<>(1); // Printer class is parameterize constructor so need to pass parameter

        PrinterGeneric0<Double> doublePrinter
                = new PrinterGeneric0<>(1.233445);


        doublePrinter.printMessage();
        integerPrinter.printMessage();


        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("Amit");
        arrayList.add(12);

        System.out.println(arrayList);

        int a = (int) arrayList.get(1); // Needs to cast here otherwise C.T error
        System.out.println(a);
        //int b = (int)arrayList.get(0); // Run time error -> Class cast exception b/c arrayList[0]-> String


        // Using EXTENDS
        DogGeneric1<Husky> huskyDog = new DogGeneric1<>(); // Here Husky should extends Animal
        huskyDog.typeOfDog = new Husky(4, 30.123);
        huskyDog.print();

        DogGeneric1<GermanShepard> germanShepardDog = new DogGeneric1<>(); // Here Husky should extends Animal
        germanShepardDog.typeOfDog = new GermanShepard(4, 40.123);
        germanShepardDog.print();

        Integer i = 10;
        shout(i);
        shout(germanShepardDog);
        shout(10);

        multipleShout(1,2);
        multipleShout(germanShepardDog,i);

    }

    //Method type generics
    private static <T> void shout(T newType) {
        System.out.println(newType + "!!!!");
    }

    //Multiple Generic
    private static <T,V> void multipleShout(T newType, V value) { // We can do same Classes also
        System.out.println(newType + "!!!!" + value +"!!!!");
    }

    //Your generic type definition for CustomLinkedList<T extends Number, String>
    // is incorrect because generics in Java don't allow multiple types in the form you provided
    // Allowed -> public class CustomLinkedList<T extends Number, U>
}

class PrinterGeneric0<T> { // can be anything -> T or <XYZ> Here T -> convention

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
