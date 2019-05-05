package com.bilqu.java8.cons;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.util.Date;

public class DateApiTest {

    public static void main(String[] a){
        Date date = new Date();
        System.out.println(date);

        //With Java 8

        // The LocalDate class represents a date. There is no representation of a time or time-zone.

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = LocalDate.of(2018,12,12);
        System.out.println(localDate);

        //The LocalTime class represents a time. There is no representation of a date or time-zone.
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        localTime = LocalTime.of(10,12,14);
        System.out.println(localTime);

        //The LocalDateTime class represents a date-time. There is no representation of a time-zone.
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);


        // If you want to use the date functionality with zone information OffsetTime and OffsetDateTime
        OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(offsetDateTime);

        //The Instant class represents an instant in time to an accuracy of nanoseconds
        //Duration deals with small unit of time such as milliseconds, seconds, minutes and hour.
        //Period is used for bigger durations
        OffsetTime offsetTime = OffsetTime.ofInstant(Instant.now().plus(Duration.ofMillis(100000l)),ZoneId.of("Asia/Kolkata"));
        System.out.println(offsetTime);
    }

}
