package com.common.apicommon.utils;

import java.text.DecimalFormat;

public class BMIUtil {
    public static String getBmi(String height,String weight){
        double stature=Double.valueOf(height)/100;
        double quality=Double.valueOf(weight);
        double bmi=(double) ((quality/stature)/stature);
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(bmi);
    }
}
