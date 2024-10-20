package com.information.basic.singelton;

/* More about Enum */
public final class Day{   // -> internally extends Enum<Day> {

    public static final Day SUNDAY = new Day("SUNDAY", 0); // single instance (Singleton behaviour)
    public static final Day MONDAY = new Day("MONDAY", 1);
    public static final Day TUESDAY = new Day("TUESDAY", 2);
    public static final Day WEDNESDAY = new Day("WEDNESDAY", 3);
    public static final Day THURSDAY = new Day("THURSDAY", 4);
    public static final Day FRIDAY = new Day("FRIDAY", 5);
    public static final Day SATURDAY = new Day("SATURDAY", 6);

    // Private constructor to prevent instantiation
    private Day(String name, int ordinal) {
        //super(name, ordinal); internally this happens
    }

    public static void main(String[] args){

        Day d =  Day.MONDAY;
        Day e = Day.MONDAY;

        if(d==e) System.out.println("Same instance");
    }
}

