package com.dataxf.tests;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    public static boolean compareDayInDifferentTimeZone(Date date1, TimeZone timeZone1, Date date2, TimeZone timeZone2) {
        if (date1 == null
                || timeZone1 == null
                || date2 == null
                || timeZone2 == null){
            throw new NullPointerException("Missing input parameter.");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeZone(timeZone1);
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTimeZone(timeZone2);
        cal2.setTime(date2);

        return (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE));
    }

    public static boolean compareDayInDifferentTimeZone(ZonedDateTime zonedDateTime1, ZonedDateTime zonedDateTime2) {
        if (zonedDateTime1 == null
                || zonedDateTime2 == null){
            throw new NullPointerException("Missing input parameter.");
        }
        return (zonedDateTime1.getYear() == zonedDateTime2.getYear()
                && zonedDateTime1.getMonth() == zonedDateTime2.getMonth()
                && zonedDateTime1.getDayOfMonth() == zonedDateTime2.getDayOfMonth());
    }
}
