package com.test.usercenter.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleVo implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private List<PremissionVo> premissionVoList;


}
