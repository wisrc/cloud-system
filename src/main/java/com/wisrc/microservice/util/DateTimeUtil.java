package com.wisrc.microservice.util;


import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import java.sql.Timestamp;

@Slf4j
public class DateTimeUtil {

    public static Timestamp currentTimestamp(){
        String currentTime = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
        return Timestamp.valueOf(currentTime);
    }
}
