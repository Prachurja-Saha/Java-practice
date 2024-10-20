package com.information.generic.wildcards;

import java.util.List;
/** The declaration List<? extends Number> numbers
 * means that numbers can be a list of Number or any subclass of Number.
 * This includes types like Integer, Double, Float, etc.*/
// we specify any type of list
public class WildCardTest {

    private void printList(List<Object> listOfObject) {
        System.out.println(listOfObject);
    }

    private void printListAnyType(List<?> listOfAnyType) { // Use of wildcard
        System.out.println(listOfAnyType);
    }

    public static void main(String[] args){
        WildCardTest wildCardTest = new WildCardTest();

        List<?> anyList = List.of("1",1,30.2123,true); // use of wildcards
//        anyList.add(""); // C.T error
        wildCardTest.printListAnyType(anyList);

        List<Integer> integerList = List.of(1,2,3);

//      wildCardTest.printList(integerList); //C.TError (b/c)-> Integer is a subclass of object but List of Integer
        // is not the subclass of List of Object that's why we use wildcard.
    }
}
