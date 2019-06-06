package com.common.apicommon.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    //MD5加密,32位小写
    public static String MD5(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bs = digest.digest(str.getBytes("utf-8"));
            StringBuffer zm = new StringBuffer();
            for (byte b : bs) {
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                zm.append(hexString);
            }
            return zm.toString();
        } catch (Exception e) {
            return null;
        }
    }
    //获取MD5 加密32位小写
    public static String stringMD5(String pw) {
        try {
            MessageDigest messageDigest =MessageDigest.getInstance("MD5");
            byte[] inputByteArray = pw.getBytes();
            messageDigest.update(inputByteArray);
            byte[] resultByteArray = messageDigest.digest();
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    private static String byteArrayToHex(byte[] byteArray) {

        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'a','b','c','d','e','f' };
        char[] resultCharArray =new char[byteArray.length * 2];
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b& 0xf];
        }
        return new String(resultCharArray);
    }
}
