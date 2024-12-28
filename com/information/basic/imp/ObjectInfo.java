package com.information.basic.imp;



public class ObjectInfo {

    /*
    * Wrapper classes, String, Date and time classes, Collection classes, BigInteger/BigDecimal, UUID, File, etc.,
    * all override the equals() method to perform value-based equality.
    * enums compare by reference but act like value comparisons due to their singleton nature.
    *
    * To Compare the address for wrapper and Collection classes use -> ==
    *
    * If type is Object than we typecast by (Integer)/ (String)
    * */


    /*
    * 1. If it is public class than file name should be that public class name .java
            but we can create multiple class without public modifier

            i.e
            ex-1
            Class A {} -> DEFAULT CLASSES
            Class B {}

            public Class C{ main method}  here file name should be C.java

            ex-2
            public Class A{}
            public Class B{} --> Error not allowed 2 or more public class
    * */


    public static void main(String[] args){

        /*
        * Very Important : Integer Cache
        *
        * Integer Caching: When you assign the value 10 to a and b, Java uses the cached Integer objects
        * for these values because 10 is within the range of -128 to 127.
        * Reference Comparison: a and b reference the same Integer object, so a == b evaluates to true.
        * */
        Integer a = 10;
        Integer b = 10;
        if(a==b){ // ==  will check object reference
            System.out.println("Integer range is in between -128 to 127, Java will use cache integer object ");
        }

        // outside the cache range
        Integer c = 1000;
        Integer d = 1000;
        if(c!=d){
            System.out.println("Two different object of Integer class and also outside the cache range");
        }

        try {
            ObjectInfo objectInfo = new ObjectInfo();
            objectInfo.testException();
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }

    }

    public int testException(){
        int d = 10/0; // If there is exception it  will go to caller method even without throws (throws just provide type)

        return d;
    }
}
