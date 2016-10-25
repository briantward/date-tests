package com.dataxf.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@RunWith(JUnit4.class)
public class DateUtilTest {
    @Test
    public void compareDayInDifferentTimeZoneTest() throws Exception {
        // 1473681600000
        // Human time (your time zone): Mon 12 Sep 2016 08:00:00 AM EDT
        // Human time (GMT): Mon, 12 Sep 2016 12:00:00 GMT
        Date date1 = new Date(1473681600000L);
        System.out.println(date1);
        TimeZone timeZone1 = TimeZone.getTimeZone("EST");

        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeZone(timeZone1);
        cal1.setTime(date1);
        System.out.println(cal1);
        System.out.println(cal1.get(Calendar.DATE));

        // 1473724800000
        // Human time (GMT): Tue, 13 Sep 2016 00:00:00 GMT
        // Human time (your time zone): Mon 12 Sep 2016 08:00:00 PM EDT
        Date date2 = new Date(1473724800000L);
        System.out.println(date2);
        TimeZone timeZone2 = TimeZone.getTimeZone("UTC");

        Calendar cal2 = Calendar.getInstance();
        cal2.setTimeZone(timeZone2);
        cal2.setTime(date2);
        System.out.println(cal2);
        System.out.println(cal2.get(Calendar.DATE));

        Assert.assertFalse(DateUtil.compareDayInDifferentTimeZone(date1, timeZone1, date2, timeZone2));

    }

    @Test
    public void compareDayInDifferentTimeZoneTest2() throws Exception {
        // 1473681600000
        // Human time (your time zone): Mon 12 Sep 2016 08:00:00 AM EDT
        // Human time (GMT): Mon, 12 Sep 2016 12:00:00 GMT
        Date date1 = new Date(1473681600000L);
        System.out.println(date1);
        TimeZone timeZone1 = TimeZone.getTimeZone("EST");

        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeZone(timeZone1);
        cal1.setTime(date1);
        System.out.println(cal1);
        System.out.println(cal1.get(Calendar.DATE));

        // 1473703200000
        // Human time (GMT): Mon, 12 Sep 2016 18:00:00 GMT
        // Human time (your time zone): Mon 12 Sep 2016 02:00:00 PM EDT
        Date date2 = new Date(1473703200000L);
        System.out.println(date2);
        TimeZone timeZone2 = TimeZone.getTimeZone("UTC");

        Calendar cal2 = Calendar.getInstance();
        cal2.setTimeZone(timeZone2);
        cal2.setTime(date2);
        System.out.println(cal2);
        System.out.println(cal2.get(Calendar.DATE));

        Assert.assertTrue(DateUtil.compareDayInDifferentTimeZone(date1, timeZone1, date2, timeZone2));

    }

    @Test
    public void compareDayInDifferentTimeZoneTest3(){
        Instant instant1 = Instant.ofEpochMilli(1473681600000L);
        ZoneId zone1 = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(instant1, zone1);
        System.out.println(zonedDateTime1);

        Instant instant2 = Instant.ofEpochMilli(1473724800000L);
        ZoneId zone2 = ZoneId.of("UTC");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.ofInstant(instant2, zone2);
        System.out.println(zonedDateTime2);

        Assert.assertFalse(DateUtil.compareDayInDifferentTimeZone(zonedDateTime1,zonedDateTime2));
    }

    @Test
    public void compareDayInDifferentTimeZoneTest4(){
        Instant instant1 = Instant.ofEpochMilli(1473681600000L);
        ZoneId zone1 = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(instant1, zone1);
        System.out.println(zonedDateTime1);

        Instant instant2 = Instant.ofEpochMilli(1473703200000L);
        ZoneId zone2 = ZoneId.of("UTC");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.ofInstant(instant2, zone2);
        System.out.println(zonedDateTime2);

        Assert.assertTrue(DateUtil.compareDayInDifferentTimeZone(zonedDateTime1,zonedDateTime2));
    }

}
