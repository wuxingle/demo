package com.common.apicommon.model;

public enum ResultStatus {

    SUCCESS(200, "请求成功"),

    FAIL(4000,"请求失败");

    private final int code;

    private final String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
