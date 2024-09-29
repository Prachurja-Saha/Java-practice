package com.information.generic.extendgeneric;

public class DogGeneric2<T> {// if we mention extends<T entend Animal> than can use Animal method inside class

    public T type;

    void paste() {
        System.out.println("Testing how type which extending other class works");
    }

    public static void main(String[] args) {

        DogGeneric2<GermanShepard> germanShepardDogGeneric2 = new DogGeneric2<>();

        // To call the method for germanShepardDogGeneric2 u need to create an object
        germanShepardDogGeneric2.type = new GermanShepard(4,40.01);

        germanShepardDogGeneric2.type.printk(); // Calling GermanShepard method
        germanShepardDogGeneric2.type.print(); // Calling Animal method
    }

}
