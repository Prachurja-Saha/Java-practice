package com.information.generic;

import com.information.generic.extendgeneric.DogGeneric1;
import com.information.generic.extendgeneric.GermanShepard;
import com.information.generic.extendgeneric.Husky;
import com.information.generic.multiplegeneric.MultipleGenericClass3;
import com.information.generic.simplegeneric.PrinterGeneric0;

import java.util.ArrayList;
/**
 * ? -> public void processList(List<?> list) {
 *     // You can read from the list but can't add specific types (other than null)
 * }
 *
 * T -> T is a type parameter you define
 */
public class MainClass {

    public static void main(String[] args) {

        // BASIC GENERIC

        // cannot be primitive always wrapper class
        // Printer<int> -> C.T  Error
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

        // Multiple Generic in classes
        MultipleGenericClass3<Integer,Integer> class3 = new MultipleGenericClass3<>();

    }

    //Method
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
