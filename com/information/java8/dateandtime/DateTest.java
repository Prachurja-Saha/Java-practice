package com.information.java8.dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * Legacy Date and Calendar Class
 * issues -> Mutable, confusing, limited (Zone, Difference)
 * <p>
 * Java 8 new Classes -> immutable
 * Local Date, Local Time, Local Date Time, Zoned Date Time, Instant, Period, Duration
 * Date Time Formatter
 *
 */
public class DateTest {

    /*Immutable*/
    public static void main(String[] args){

        /*Local Date*/
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // Operation
        LocalDate yesterday = today.minusDays(1);
        System.out.println(yesterday);

        if(today.isAfter(yesterday))
            System.out.println("Correct");

        LocalDate previousMonth = today.minusMonths(1);
        System.out.println(previousMonth);

        // Custom Date
        LocalDate myDate = LocalDate.of(2024, 10, 13);
        System.out.println(myDate.getDayOfYear()); // 287th day of year

        int year = myDate.getYear();
        Month month = myDate.getMonth();
        int day = myDate.getDayOfMonth();
        int monthNo = myDate.getMonthValue();

        System.out.println(day + "/" + month + "/" + year);
        System.out.println(day + "/" + monthNo + "/" + year);
        
        /* Local Time */
        LocalTime nowTime = LocalTime.now();
        LocalTime customTime = LocalTime.of(14,30,30);

        // Converting String to time
        LocalTime parsedTime = LocalTime.parse("15:20:11");


        /* Local date and time */
        LocalDateTime current = LocalDateTime.now();
        System.out.println("Date and time current :" + current);

        LocalDateTime custom = LocalDateTime.of(2023,11,28,15,45,30);
        System.out.println(custom);

    }
}
