package com.common.apicommon.utils;

/**
 * 手机号规则验证
 */
public class PasswordVerifyUtil {
    public static boolean mobileVerify(String mobile){
        String PASSWORD_NUMBER_REG = "^[0-9A-Za-z]{6,20}$";
        boolean falg=mobile.matches(PASSWORD_NUMBER_REG);
        return falg;
    }
}
