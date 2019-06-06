package com.common.apicommon.utils;

/**
 * 手机号规则验证
 */
public class MobileVerifyUtil {
    public static boolean mobileVerify(String mobile){
        String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
        boolean falg=mobile.matches(PHONE_NUMBER_REG);
        return falg;
    }
}
