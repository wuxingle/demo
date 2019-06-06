package com.common.apicommon;

public enum StatusCode {
    PARAMETERR_VALIDATION_ERROR(4001, "参数不能为空"),
    UNKNOWN_ERROR(10002, "未知的错误"),
    USER_NOT_EXIST(4002, "用户不存在"),
    USER_LOGIN_FULL(4003, "用户手机号或者密码不正确"),
    USER_NOT_LOGIN(4004, "用户未登录"),
    DATA_NOT_FIND(4005, "没有发现相关数据,请检查参数值"),
    PARAMETERR_VALUE_ERROR(4006, "输入的参数值有误"),
    PASSWPRD_VALUE_ERROR(4007, "密码不符合要求"),
    OPERATE_ERROR(4008, "操作失败请重新操作"),
    PARAMETERR_PASSWORD_ERROR(4009, "密码错误"),
    RECORD_EXIST(4010,"记录存在"),
    PHONE_NO_ERROR(4011,"手机号码不符合要求"),
    VERIFICATION_CODE_LOSE(4012,"验证码已过期"),
    PHONE_NO_ALREADY_REGISTER(4013,"手机号已经被注册")


    ;
    private int ErrorCode;
    private String message;
    StatusCode(int errorCode, String message){
        ErrorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return this.ErrorCode;
    }

    public String getErrorMessage() {
        return this.message;
    }


}
