package com.test.usercenter.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PremissionVo implements Serializable {
    private Integer id;
    private String premissionName;
    private String premissionCode;
    private String type;
    private Integer sort;
    private String url;
}
