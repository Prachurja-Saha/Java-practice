package com.information.generic.extendgeneric;

// <T extends Animal> -> T should also extend Animal Class
// Here it means it will take object type T which extends Animal Class
//it means Type Animal or subclass of Animal are allowed in T
public class DogGeneric1<T extends Animal>{ // here Animal is Class we use extends same for interface need to use extends
                                    // <T extends AnimalClass & XyzInterface> , <T extends Interface1>
    public T typeOfDog;

    private final int leg = 4 ;

    public void print() {
        typeOfDog.print(); // from that object type we are calling Animal class methods
                           // Husky Class also have same method name print() its calling that method
                           // But for GermanShepard don't have any method name print() so its calling animal method
    }

}
