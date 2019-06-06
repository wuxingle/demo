package com.common.apicommon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultData<T> implements Serializable {

    private static final long serialVersionUID = 1862906172390850647L;

    @JsonProperty("data")
    protected T data;

    @JsonProperty("code")
    protected int code=ResultStatus.SUCCESS.code();

    @JsonProperty("message")
    protected String message;

    public ResultData(T data) {
        this.data = data;
    }

    public ResultData(){
    }

    public static ResultData success() {
        ResultData result = new ResultData("");
        result.setMessage("success");
        return result;
    }

    public static ResultData failure(String msg) {
        ResultData<String> result = new ResultData<String>("");
        result.setMessage(msg);
        result.setCode(4000);
        return result;
    }
}
