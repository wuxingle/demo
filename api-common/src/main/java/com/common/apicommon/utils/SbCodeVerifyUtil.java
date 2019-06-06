package com.common.apicommon.utils;

/**
 * 产品编号规则验证
 */
public class SbCodeVerifyUtil {
    public static boolean sbCodeVerify(String mobile){
        String PASSWORD_NUMBER_REG = "^[0-9A-Za-z]{6,30}$";
        boolean falg=mobile.matches(PASSWORD_NUMBER_REG);
        return falg;
    }
}
