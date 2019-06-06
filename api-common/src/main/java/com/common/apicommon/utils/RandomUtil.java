package com.common.apicommon.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    /**
    * 生成4位随机数
    * */
    public static String generateRandom(int length) {
        return RandomStringUtils.random(length, 0, 0, false, true, null, ThreadLocalRandom.current());
    }

    public static void main(String[] args){
        RandomUtil.generateRandom(4);
    }
}
