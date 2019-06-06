package com.common.apicommon.utils;

import java.util.Date;

public class GetTime {
    public static long getTime(Date startTime, Date endTime) {
        //计算时差
        long start = startTime.getTime();
        long end = endTime.getTime();
        long trainingTime = (end - start) / (1000 * 60);
        return trainingTime;
    }
}
