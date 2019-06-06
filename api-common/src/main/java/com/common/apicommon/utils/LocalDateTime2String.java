package com.common.apicommon.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTime2String {

    public  static String localDateTime2String(LocalDateTime localDateTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = df.format(localDateTime);
        return localTime;
    }
}
