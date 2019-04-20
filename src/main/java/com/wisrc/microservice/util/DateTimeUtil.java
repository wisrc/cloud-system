package com.wisrc.microservice.util;


import org.joda.time.DateTime;

import java.sql.Timestamp;

public class DateTimeUtil {


    public static String currentTime(){
        return DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }

    public static Timestamp currentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }
}
