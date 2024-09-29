package com.practice;

import java.util.List;

public class GenericWithT <T>{

    T type;

    public List<T> printTList(List<T> list) { // here to use this need to change the class -><T>

        System.out.println(list);
        return list;
    }

    public List<?> printWList(List<?> list) {

        System.out.println(list);
        return list;
    }

    // Making Restriction
    public List<?> printWListRestriction(List<? extends Number> list) { // Only consider Number/subclass of Number

        System.out.println(list);
        return list;
    }

    // Here ? means multi type of list-> list[1,"1",true,1000000L,0.1]
    public List<?> printSuperClassWLowerBound(List<? super Integer> list) { //? super Integer means any type that is a
                                                                       // superclass of Integer or Integer
        System.out.println(list);
        return list;
    }


}
