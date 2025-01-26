package com.information.string;

/**
 * Java String class provides a lot of methods to perform operations on strings such as
 * compare(), concat(), equals(), split(), length(), replace(), compareTo(), intern(), substring() etc.
 * The java.lang.String class implements Serializable, Comparable and CharSequence interfaces.
 * <p>
 * The CharSequence interface is used to represent the sequence of characters.
 * String, StringBuffer and StringBuilder classes implement it.
 * It means, we can create strings in Java by using these three classes.
 */
public class StringBasic {

    char[] c =  {'1','2','3'}; // Sequence of characters
    String s = new String(c); // String is sequence of character and CharSequence interface represent sequence of char
    String x = "avx"; // different from above one

    //IMPORTANT String -> == and .equals difference
    void conditionTest() {
        String s1 = new String("Deepak");// It will create 2 new obj outside SCP and inside SCP
        String s2 = new String("Deepak");// It will create a new object in heap but not in SCP

        //== -> Reference/ address comparison s1 and s2 are pointing different object not same object
        //      which is outside SPC b/c it is created using new keyword
        if(s1 == s2){ // false address different
            System.out.println("Here we are checking if both the address are same which means refernce is " +
                    "pointing same object or not");
        }

        //.equals -> obect class method-> public boolean equals(Object obj) { return this==obj;}
        //IMPORTANT s1.equals(s2) but String override this equals method b/c String extends object class
        // Before -> adress check   after override by String -> content check
        if(s1.equals(s2)){ // True content same

            System.out.println("Here we are checking if both the content b/c string overrides " +
                    ".equals by extending object class");
        }


        // # String Buffer -> Mutable -> used when string is changing frequently
        // Synchronized -> All method inside String buffer class is synchronized -> Performance issue
        StringBuffer stringBuffer = new StringBuffer("Deepak");
        stringBuffer.append("Sen"); // It will change the original object from Deepak to Deepak Sen but String we can't
                                    // Do that b/c String is immutable


        // # String Builder same as it is String builder only difference is non synchronized method
        // Performance increased
        StringBuilder stringBuilder = new StringBuilder("Rahul");
        stringBuilder.append("Sen");

    }






/*
# VVIMP
The CharSequence interface is used to represent the sequence of characters. String, StringBuffer
and StringBuilder classes implement it. It means, we can create strings in Java by using these three classes.
*/

}
