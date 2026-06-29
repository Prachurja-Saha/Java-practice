package com.information.basic;

import com.information.basic.singelton.EnumTest;

// In Java, you cannot have a top-level class that is private or protected but nested can
public class MainClass {

    public String a;

    void aa (){

        String subject = switch (a) {
            case "an" -> "BILLING_SALESFORCE_SUBSCRIBE_FIRST_TIME";
            case "bn" -> "BILLING_SALESFORCE_SUBSCRIBE_ADDITIONAL_REQUEST";
            default -> "c";
        };

        if (subject.equals("BILLING_SALESFORCE_SUBSCRIBE_ADDITIONAL_REQUEST")) {
            System.out.println("axap");
        }
    }




    public static void main(String[] args) {

        String xyz="", abc="";
        EnumTest enumTest = EnumTest.MERCURY;

        System.out.println(enumTest.getMass());
        enumTest.setMass(1.1111);
        System.out.println(enumTest.getMass());

        MainClass mainClass = new MainClass();
        mainClass.a= "bn";
        mainClass.aa();


    }
/*    # Notes (System.out.println)
1. System -> Class
    out -> static member of type PrintStream in System class (public static final PrintStream out = null;)
    and println is the method of PrintStream class
    System.out.println()
            2. String xyz=" ", abc="x"; -> allowed, variable declared in method is called local variable
    In java there is no global variable, but there is static variable which can be access from any where if it is
    not declare private*/
}
