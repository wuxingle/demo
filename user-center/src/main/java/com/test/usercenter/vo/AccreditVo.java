package com.test.usercenter.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccreditVo implements Serializable {
    private String userId;
//    private List<RoleVo> roleList;


}
