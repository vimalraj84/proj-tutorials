package com.bilqu.java8.date;

import java.util.Calendar;
import java.util.Date;

public class DayFinder {


    public static void main(String[] args) {
        printAllSundays();
    }

    public static void printAllSundays(){
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        start.set(2019,10,01);
        end.set(2019,10,30);

        for (Calendar c = start;
             c.before(end);
             c.set(Calendar.DATE,(c.get(Calendar.DATE)+1)))
        {
            if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                System.out.println(c.getTime());
        }
    }
}
