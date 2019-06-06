package com.common.apicommon.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandException extends RuntimeException {

    public int errorCode;

    public CommandException(int errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CommandException(ExceptionData exceptionData) {
        super(exceptionData.getMessage());
        this.errorCode = exceptionData.getCode();
    }
}
