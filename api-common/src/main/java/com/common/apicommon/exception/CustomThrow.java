package com.common.apicommon.exception;

import com.common.apicommon.model.ResultStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.lang.reflect.Field;

public final class CustomThrow {
    private CustomThrow() {
    }

    public static ExceptionData throwCustom(int errorCode, String customMessage) {
        return new ExceptionData(errorCode, customMessage);
    }

    public static ExceptionData throwCustom(String customMessage) {
        return new ExceptionData(ResultStatus.FAIL.code(), customMessage);
    }

    public static ExceptionData throwInvalidFields(BindingResult result) {
        if (result != null) {
            StringBuffer buffer = new StringBuffer();
            boolean valid_flag = true;
            if (result.getErrorCount() > 0) {
                valid_flag = false;
                String errorFieldName;
                for (FieldError fieldError : result.getFieldErrors()) {
                    errorFieldName = getErrorFieldName(result, fieldError);
                    if (errorFieldName != null) {
                        String errorMessage = fieldError.getDefaultMessage();
                        buffer.append(errorMessage).append("\n");
                    }
                }
            }
            if (!valid_flag) {
                return new ExceptionData(ResultStatus.FAIL.code(), buffer.toString());
            }
        }
        return null;
    }

    private static String getErrorFieldName(BindingResult bindingResult, FieldError fieldError) {
        if (bindingResult != null && fieldError != null) {
            String errorFieldName = fieldError.getField();
            try {
                Class clazz = bindingResult.getTarget().getClass();
                Field field = clazz.getDeclaredField(fieldError.getField());
                JsonProperty annotation = field.getAnnotation(JsonProperty.class);
                if (annotation != null) {
                    errorFieldName = annotation.value();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            return errorFieldName;
        }
        return null;
    }
}
