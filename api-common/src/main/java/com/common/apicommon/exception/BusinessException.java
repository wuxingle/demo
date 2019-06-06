package com.common.apicommon.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException {

    public int errorCode;

    public BusinessException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ExceptionData exceptionData) {
        super(exceptionData.getMessage());
        this.errorCode = exceptionData.getCode();
    }
}
