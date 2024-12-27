package com.information.basic.singelton;

/* More about Enum */
public final class Day{

    public static final Day SUNDAY = new Day("SUNDAY", 0); // single instance (Singleton behaviour)
    public static final Day MONDAY = new Day("MONDAY", 1);
    public static final Day TUESDAY = new Day("TUESDAY", 2);
    public static final Day WEDNESDAY = new Day("WEDNESDAY", 3);
    public static final Day THURSDAY = new Day("THURSDAY", 4);
    public static final Day FRIDAY = new Day("FRIDAY", 5);
    public static final Day SATURDAY = new Day("SATURDAY", 6);

    // Private constructor to prevent instantiation
    private Day(String name, int ordinal) {

    }

    public static void main(String[] args){

        Day d =  Day.MONDAY;
        Day e = Day.MONDAY;


//        Day x = new Day();  why cant i do that ans below
        /*
        * In Java, every class does indeed have a default no-argument constructor if no other constructors are defined.
        * However, once you explicitly define any constructor (with or without arguments),
        * Java does not automatically provide a default no-argument constructor.
        * */

        if(d==e) System.out.println("Same instance");
    }
}

